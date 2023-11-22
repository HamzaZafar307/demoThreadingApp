package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {

    private static List<User> userList = Collections.synchronizedList(new ArrayList<>());
    private static ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);
    private static Random random = new Random();


    public static void main(String[] args) {
        System.out.println("Hello world!");
        userList.add(new User("User1"));
        userList.add(new User("User2"));
        userList.add(new User("User3"));

        // Create and start threads

        // Thread for simulating external API calls
        scheduler.scheduleAtFixedRate(() -> {
            ExternalAPIResult result = ExternalAPISimulator.callExternalAPI();
            System.out.println("External API Result: " + result.getCurrentTime() + ", " + result.getRandomNumber());
            processExternalAPIResult(result);
        }, 0, 5, TimeUnit.SECONDS); // Simulate API call every 5 seconds

        // Thread for processing external API results and updating users
        scheduler.scheduleAtFixedRate(() -> {
            System.out.println("Updating Users thread...");
            updateUserList();
        }, 0, 10, TimeUnit.SECONDS); // Update users every 10 seconds


    }

    private static void processExternalAPIResult(ExternalAPIResult result) {
        synchronized (userList) {
            userList.add(new User("NewUser_" + result.getRandomNumber()));
        }
    }

    private static void updateUserList() {
        synchronized (userList) {
            System.out.println("Current Users:");
            for (User user : userList) {
                System.out.println(user.getName());
            }
            System.out.println();
        }
    }

}