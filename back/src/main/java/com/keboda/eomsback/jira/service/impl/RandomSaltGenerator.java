package com.keboda.eomsback.jira.service.impl;

import com.keboda.eomsback.jira.service.SaltGenerator;

import java.util.Random;

public final class RandomSaltGenerator implements SaltGenerator {
    private static final Random random = new Random();

    public RandomSaltGenerator() {
    }

    public byte[] generateSalt(int length) {
        byte[] result = new byte[length];
        random.nextBytes(result);
        return result;
    }
}