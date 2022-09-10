package com.alirezagolshan;

import lombok.NoArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.util.retry.Retry;

import java.time.Duration;

@NoArgsConstructor
public class RetryMechanism {
    public static void main(String[] args) {
        RetryMechanism rm = new RetryMechanism();
        rm.retryWhenExample().subscribe();
    }

    public Flux<String> fakeServiceCallRetryExample() {
        return Flux.just("1", "2", "3", "4")
                .map(e -> "Time-" + retryElementProcess(e))
                .onErrorMap(e -> {
                    System.out.println("Error!");
                    throw new RuntimeException();
                })
                .log()
                .retry(2);
    }

    public Flux<String> retryWhenExample() {
        return Flux.just("1", "2", "3", "4")
                .retryWhen(retrySpecs())
                .map(e -> retryElementProcess(e))
                .onErrorMap(e -> {
                    throw new IllegalStateException("Er-Occurred");
                })
                .log();



    }

    public String retryElementProcess(String element) {
        if ("3".equals(element)) {
            throw new RuntimeException("Illegal element!!");
        }
        return element;
    }

    public Retry retrySpecs() {
        System.out.println("Called retrySpecs");
        return Retry.backoff(4, Duration.ofSeconds(3));//.filter(e -> e instanceof IllegalStateException);
    }
}