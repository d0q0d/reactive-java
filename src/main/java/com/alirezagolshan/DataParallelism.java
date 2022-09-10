package com.alirezagolshan;

import reactor.core.publisher.Flux;
import reactor.core.publisher.ParallelFlux;
import reactor.core.scheduler.Schedulers;

public class DataParallelism {
    public static void main(String[] args) throws InterruptedException {
        DataParallelism dataParallelism = new DataParallelism();
        dataParallelism.parallelDataProcess().log()
                .subscribe(item -> System.out.println("Item is : " + item));
        Thread.sleep(60000);
    }

    public ParallelFlux<Integer> parallelDataProcess() {
        return fluxGenerator()
                .parallel()
                .runOn(Schedulers.parallel())
                .map(this::fakeCalculate);
    }

    public Flux<Integer> fluxGenerator() {
        return Flux.range(0, 10);
       }

    public int fakeCalculate(int input) {
        try {
            Thread.sleep(500);
            return input * 2;

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }
}