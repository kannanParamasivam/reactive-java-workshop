package io.javabrains.reactiveworkshop;

import java.io.IOException;
import java.util.List;

public class Exercise3 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFlux()

        //Asynchronous subscription
        ReactiveSources.intNumbersFlux()
                .subscribe(num -> System.out.println(num));

        // Get all numbers in the ReactiveSources.intNumbersFlux stream
        // into a List and print the list and its size

        // Synchronous subscription
        List<Integer> numbers = ReactiveSources.intNumbersFlux()
                .log() //Logs the stream flow. Useful when debugging
                .toStream() // Blocking operation
                .toList();

        System.out.println("Numbers is " + numbers);
        System.out.println("Numbers count is " + numbers.size());

        System.out.println("Press a key to end");
        System.in.read();
    }

}
