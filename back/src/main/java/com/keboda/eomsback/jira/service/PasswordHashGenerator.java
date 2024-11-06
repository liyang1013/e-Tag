package com.keboda.eomsback.jira.service;

public interface PasswordHashGenerator {
    byte[] generateHash(byte[] var1, byte[] var2);

    int getRequiredSaltLength();
}
