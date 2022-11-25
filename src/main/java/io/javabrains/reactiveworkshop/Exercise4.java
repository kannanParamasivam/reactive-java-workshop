package io.javabrains.reactiveworkshop;

import java.io.IOException;
import java.util.Optional;

public class Exercise4 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumberMono()

        // Print the value from intNumberMono when it emits
        ReactiveSources.intNumberMono().subscribe(number -> System.out.println(number));

        // Get the value from the Mono into an integer variable
        Integer number = ReactiveSources.intNumberMono().block(); // Blocking statement
        System.out.println("The Number is " + number);

        // Get the value from the Mono into an optional  integer variable
        Optional<Integer> optionalNumber = ReactiveSources.intNumberMono().blockOptional(); // Blokcing statement

        optionalNumber.ifPresentOrElse(
                num -> System.out.println("Mono returned value: " + num),
                () -> System.out.println("Mono have nothing"));

        System.out.println("Press a key to end");
        System.in.read();
    }

}
