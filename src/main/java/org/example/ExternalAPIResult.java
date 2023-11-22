package org.example;

class ExternalAPIResult {
    private long currentTime;
    private int randomNumber;

    public ExternalAPIResult(long currentTime, int randomNumber) {
        this.currentTime = currentTime;
        this.randomNumber = randomNumber;
    }

    public long getCurrentTime() {
        return currentTime;
    }

    public int getRandomNumber() {
        return randomNumber;
    }
}