package com.keboda.eomsback.jira.service.impl;

import com.keboda.eomsback.jira.service.PasswordHashGenerator;
import org.bouncycastle.crypto.generators.PKCS5S2ParametersGenerator;
import org.bouncycastle.crypto.params.KeyParameter;

public final class PKCS5S2PasswordHashGenerator implements PasswordHashGenerator {
    private static final int ITERATION_COUNT = 10000;
    private static final int OUTPUT_SIZE_BITS = 256;
    private static final int SALT_LENGTH = 16;

    public PKCS5S2PasswordHashGenerator() {
    }

    public byte[] generateHash(byte[] rawPassword, byte[] salt) {
        PKCS5S2ParametersGenerator generator = new PKCS5S2ParametersGenerator();
        generator.init(rawPassword, salt, 10000);
        KeyParameter output = (KeyParameter)generator.generateDerivedMacParameters(256);
        return output.getKey();
    }

    public int getRequiredSaltLength() {
        return 16;
    }
}

