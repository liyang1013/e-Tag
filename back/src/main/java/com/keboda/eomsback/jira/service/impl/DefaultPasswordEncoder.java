package com.keboda.eomsback.jira.service.impl;

import java.util.Arrays;

import com.keboda.eomsback.jira.service.PasswordEncoder;
import com.keboda.eomsback.jira.service.PasswordHashGenerator;
import com.keboda.eomsback.jira.service.SaltGenerator;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.StringUtils;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.Validate;

public final class DefaultPasswordEncoder implements PasswordEncoder {
    static final PasswordEncoder DEFAULT_INSTANCE = new DefaultPasswordEncoder("PKCS5S2", new PKCS5S2PasswordHashGenerator(), new RandomSaltGenerator());
    private static final int DEFAULT_SALT_LENGTH_BYTES = 16;
    private final String prefix;
    private final PasswordHashGenerator hashGenerator;
    private final SaltGenerator saltGenerator;

    public static PasswordEncoder getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static PasswordEncoder newInstance(String identifier, PasswordHashGenerator hashGenerator) {
        return new DefaultPasswordEncoder(identifier, hashGenerator, new RandomSaltGenerator());
    }

    public DefaultPasswordEncoder(String identifier, PasswordHashGenerator hashGenerator, SaltGenerator saltGenerator) {
        this.prefix = "{" + identifier + "}";
        this.hashGenerator = hashGenerator;
        this.saltGenerator = saltGenerator;
    }

    public final boolean canDecodePassword(String encodedPassword) {
        return encodedPassword != null && encodedPassword.startsWith(this.prefix);
    }

    public final String encodePassword(String rawPassword) throws IllegalArgumentException {
        Validate.notEmpty(rawPassword, "Password must not be empty");
        byte[] salt = this.saltGenerator.generateSalt(this.getSaltLength());
        byte[] hash = this.hashGenerator.generateHash(StringUtils.getBytesUtf8(rawPassword), salt);
        String encodedPassword = this.toEncodedForm(salt, hash);
        return this.prependPrefix(encodedPassword);
    }

    private int getSaltLength() {
        return this.hashGenerator.getRequiredSaltLength() > 0 ? this.hashGenerator.getRequiredSaltLength() : 16;
    }

    public final boolean isValidPassword(String rawPassword, String prefixedEncodedPassword) throws IllegalArgumentException {
        Validate.notNull(rawPassword);
        Validate.notNull(prefixedEncodedPassword);
        if (!this.canDecodePassword(prefixedEncodedPassword)) {
            return false;
        } else {
            String encodedPassword = this.removePrefix(prefixedEncodedPassword);
            byte[] storedBytes = this.fromEncodedForm(encodedPassword);
            byte[] salt = ArrayUtils.subarray(storedBytes, 0, this.getSaltLength());
            byte[] storedHash = ArrayUtils.subarray(storedBytes, this.getSaltLength(), storedBytes.length);
            byte[] hashAttempt = this.hashGenerator.generateHash(StringUtils.getBytesUtf8(rawPassword), salt);
            return Arrays.equals(storedHash, hashAttempt);
        }
    }

    private String prependPrefix(String encodedPassword) {
        return this.prefix + encodedPassword;
    }

    private String removePrefix(String encodedPassword) {
        return encodedPassword.substring(this.prefix.length());
    }

    private byte[] fromEncodedForm(String encodedPassword) {
        return Base64.decodeBase64(StringUtils.getBytesUtf8(encodedPassword));
    }

    private String toEncodedForm(byte[] salt, byte[] hash) {
        byte[] saltAndHash = ArrayUtils.addAll(salt, hash);
        byte[] base64 = Base64.encodeBase64(saltAndHash);
        return StringUtils.newStringUtf8(base64);
    }
}
