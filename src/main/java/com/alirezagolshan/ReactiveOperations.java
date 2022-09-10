package com.alirezagolshan;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

public class ReactiveOperations {
    public static void main(String[] args) {
        fluxGenerator().doOnNext((x) -> System.out.println("Element is arrived : " + x)).subscribe();
    }

    public static Flux<String> fluxGenerator() {
        Function<Flux<String>, Flux<String>> mapFilterTransform = name ->
                name.map(String::toUpperCase)
                        .filter(x -> x.length() > 4)  // Change 2 to 7 etc.
                        .flatMap(rec -> Flux.fromArray(rec.split("")));

        var defaultFlux = Flux.just("default").transform(mapFilterTransform);

        return Flux.fromIterable(List.of("Ash", "Brook", "Mislee"))
                .transform(mapFilterTransform)
                .switchIfEmpty(defaultFlux);
    }

    public static Flux<String> concatExample() {
        // Delay added because while testing it is easy to catch logs and concatination
        var firstFlux = Flux.just("A", "B", "C").delayElements(Duration.ofMillis(3000));
        var secondFlux = Flux.just("D", "E", "F");
        return Flux.concat(firstFlux, secondFlux).log();
    }

    public static Flux<String> concatWithExample() {
        var aMono = Mono.just("A");
        var stringFlux = Flux.just("B", "C", "D");
        return aMono.concatWith(stringFlux).log();
    }

    public static Flux<String> mergeExample() {
        var firstFlux = Flux.just("A", "B", "C").delayElements(Duration.ofMillis(1000));
        var secondFlux = Flux.just("D", "E", "F").delayElements(Duration.ofMillis(1800));
        // Result --> A,D,B,C,E,F
        return Flux.merge(firstFlux, secondFlux).log();
    }

    public static Flux<String> mergeWithExample() {
        var firstFlux = Flux.just("A", "B", "C").delayElements(Duration.ofMillis(1000));
        var secondFlux = Flux.just("D", "E", "F").delayElements(Duration.ofMillis(1800));
        return firstFlux.mergeWith(secondFlux).log();
    }

    public static Flux<String> mergeWithMonoExample() {
        var aMono = Mono.just("A");
        var bMono = Mono.just("B");
        return aMono.mergeWith(bMono).log();
    }

    public static Flux<String> mergeSequantialExample() {
        var firstFlux = Flux.just("A", "S", "D").delayElements(Duration.ofMillis(100));
        var secondFlux = Flux.just("Q", "W", "E").delayElements(Duration.ofMillis(125));
        return Flux.mergeSequential(firstFlux, secondFlux).log();
    }

    public static Flux<String> zipExample() {
        var firstFlux = Flux.just("A", "S", "D");
        var secondFlux = Flux.just("Q", "W", "E", "R", "T");
        BiFunction<String, String, String> combinator = (first, second) -> first + second;
        return Flux.zip(firstFlux, secondFlux, combinator).log();
    }

}