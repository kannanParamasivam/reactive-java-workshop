package io.javabrains.reactiveworkshop;

import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;

import java.io.IOException;
import java.text.MessageFormat;

public class Exercise5 {

    public static void main(String[] args) throws IOException {
        // Use ReactiveSources.intNumberFlux() and ReactiveSources.userMono()

        // Subscribe to a flux using the error and completion hooks
        ReactiveSources.intNumbersFlux()
                .subscribe(number -> System.out.println(number),
                        err -> System.out.println(err.getMessage()),
                        () -> System.out.println("Number Complete"));

        // Subscribe to a mono using the error and completion hooks
        ReactiveSources.userMono()
                .subscribe(user -> System.out.println(MessageFormat.format(
                                "User name is {0} {1}",
                                user.getFirstName(), user.getLastName())),
                        err -> System.out.println(err.getMessage()),
                        () -> System.out.println("User Completed"));

        // Subscribe to Flux of numbers with error
        ReactiveSources.intNumbersFluxWithException()
                .subscribe(
                        number -> System.out.println(MessageFormat.format("Err Flux {0}",
                                number)),
                        err -> System.out.println(MessageFormat.format("Err Flux -> error occured: {0}",
                                err.getMessage())),
                        () -> System.out.println("Number Complete")
                );

        // Subscribe to a flux using an implementation of BaseSubscriber
        ReactiveSources.intNumbersFlux()
                .subscribe(new MySubscriber<>());

        System.out.println("Press a key to end");
        System.in.read();
    }
}


class MySubscriber<T> extends BaseSubscriber<T> {
    @Override
    protected void hookOnSubscribe(Subscription subscription) {
//        super.hookOnSubscribe(subscription);
        System.out.println("Subscribe happened");
        request(1); // Ask for first item if there is anything
    }

    @Override
    protected void hookOnNext(T value) {
//        super.hookOnNext(value);
        System.out.println(value + " received");
        request(1); // Ask for next item if there is anything
    }
}
