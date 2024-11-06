package com.keboda.eomsback.jira.service;

public interface PasswordEncoder {
    String encodePassword(String var1) throws IllegalArgumentException;

    boolean isValidPassword(String var1, String var2) throws IllegalArgumentException;

    boolean canDecodePassword(String var1);
}

