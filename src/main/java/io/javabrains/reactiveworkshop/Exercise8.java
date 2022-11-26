package io.javabrains.reactiveworkshop;

import reactor.core.publisher.Flux;

import java.io.IOException;

public class Exercise8 {


    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFluxWithException()

        // Print values from intNumbersFluxWithException and print a message when error happens
        // TODO: Write code here
//        ReactiveSources.intNumbersFluxWithException()
//                .doOnError(err -> System.out.println(MessageFormat.format("Exception happened: {0}", err.getMessage()))) // DoOnError is called when exception is thrown
//                .subscribe(
//                        System.out::println,
//                        err -> System.out.println("Error detected in subscription lambda"));

        // Print values from intNumbersFluxWithException and continue on errors
        // TODO: Write code here
//        ReactiveSources.intNumbersFluxWithException()
//                .onErrorContinue(
//                        (err, item) -> System.out.println(MessageFormat.format(
//                                "Error: {0}\tvalue:{1}",
//                                err.getMessage(), String.valueOf(item))) //Do something for exception and continue
//                )
//                .subscribe(System.out::println);

        // Print values from intNumbersFluxWithException and when errors
        // happen, replace with a fallback sequence of -1 and -2
        // TODO: Write code here
        ReactiveSources.intNumbersFluxWithException()
                .onErrorResume(err -> Flux.just(-1, -2)) // Process different set of values when error occurs
                .subscribe(System.out::println);

        System.out.println("Press a key to end");
        System.in.read();
    }

}
