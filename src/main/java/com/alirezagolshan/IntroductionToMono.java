package com.alirezagolshan;

import reactor.core.publisher.Mono;

public class IntroductionToMono {
    public static void main(String[] args) {
        Mono<String> monoName = monoGenerator();
        System.out.println(monoName.subscribe(name -> System.out.println("Mono Data is : " + name)));
    }

    public static Mono<String> monoGenerator() {
        return Mono.just("Muhammet").log();
    }

    public static Mono<String> namesMono_map_filter(int stringLength) {
        return Mono.just("alex").map(String::toUpperCase).filter(name -> name.length() > stringLength);
    }
}
