package com.alirezagolshan;

import reactor.core.publisher.Flux;

import java.util.List;

public class IntroductionToFlux {
    public static void main(String[] args) {
        Flux<String> namesFlux = fluxGenerator();
        namesFlux.filter(x -> x.length() < 5)
                .map(x -> x + " Awesome")
                .subscribe(data -> System.out.println("Flux Data is : " + data));
    }

    static Flux<String> fluxGenerator() {
        return Flux.fromIterable(List.of("Muhammet", "Ali", "Robert", "Ivana", "Jessie", "Chen")).log();
    }

    static Flux<String> names_map(){
        return fluxGenerator().map(String::toUpperCase);
    }
}
