package com.alirezagolshan;

import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;
import reactor.core.publisher.Flux;

public class BufferedBackpressureMechanism {
    public static void main(String[] args) {
        fluxGenerator()
                .onBackpressureBuffer(10, lastItem -> System.out.println("Last item is : " + lastItem))
                .subscribe(new BaseSubscriber<Integer>() {
                    @Override
                    protected void hookOnSubscribe(Subscription subscription) {
                        request(1);
                    }

                    @Override
                    protected void hookOnNext(Integer value) {
                        System.out.println("Next value is : " + value);
                        if (value < 50) {
                            request(1);
                        } else {
                            hookOnCancel();
                        }
                    }

                    @Override
                    protected void hookOnComplete() {
                        System.out.println("Process completed");
                    }

                    @Override
                    protected void hookOnError(Throwable throwable) {
                        System.out.println("Error occurred!");
                    }

                    @Override
                    protected void hookOnCancel() {
                        System.out.println("Process is canceled!");

                    }
                });
    }

    public static Flux<Integer> fluxGenerator() {
        return Flux.range(1, 100)
                .log();
    }
}
