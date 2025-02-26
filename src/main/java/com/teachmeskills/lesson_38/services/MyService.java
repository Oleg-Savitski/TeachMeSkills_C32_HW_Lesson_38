package com.teachmeskills.lesson_38.services;

import com.teachmeskills.lesson_38.annotations.LeadTimed;
import org.springframework.stereotype.Service;

@Service
public class MyService {

    @LeadTimed("-> Loading data from the database")
    public void performTask() throws InterruptedException {
        System.out.println("Loading data from the database...");
        Thread.sleep(1500);
        System.out.println("Data successfully loaded.");
    }

    @LeadTimed("-> Processing data")
    public void processData() throws InterruptedException {
        System.out.println("Processing data...");
        Thread.sleep(1200);
        System.out.println("Data successfully processed.");
    }

    @LeadTimed("-> Calculating the sum of numbers in the array")
    public void calculateSum(int[] numbers) throws InterruptedException {
        System.out.println("Calculating the sum of numbers...");
        Thread.sleep(1100);
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        System.out.println("Sum of numbers: " + sum);
    }

    @LeadTimed("-> Fetching data from external API")
    public void fetchData() throws InterruptedException {
        System.out.println("Fetching data from external API...");
        Thread.sleep(2000);
        String data = "Data from API";
        System.out.println("Data successfully received: " + data);
    }
}
