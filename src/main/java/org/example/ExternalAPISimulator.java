package org.example;

import java.util.Random;

class ExternalAPISimulator {
    private static Random random = new Random();

    public static ExternalAPIResult callExternalAPI() {
        // Simulate external API call
        return new ExternalAPIResult(System.currentTimeMillis(), random.nextInt(100));
    }
}