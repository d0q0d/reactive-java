package com.alirezagolshan;

import reactor.core.publisher.Flux;

public class DoOnCallbacks {
    public static final String ERROR_MESSAGE = "Throwing exception just for testing the finally signal type. Comment error and see the signalType changes on doFinally()";

    public static void main(String[] args) {
        doOnCallbacks().subscribe();
    }

    public static Flux<String> levelGenerator() {
        return Flux.just("Easy", "Medium", "Hard", "WordClass");
    }

    public static Flux<String> doOnCallbacks() {
        return levelGenerator()
                .doOnSubscribe((subscription) -> System.out.println("Subscribed to : " + subscription))
                .doOnNext((element) -> System.out.println("Next element is : " + element))
                .doOnComplete(() -> System.out.println("Publisher sent complete signal and process finished"))
                .doFinally((signalType) -> System.out.println("This is executed finally and signal type is : " + signalType));

    }
}
