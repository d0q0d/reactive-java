package com.alirezagolshan;

import reactor.core.publisher.Flux;

public class ProgrammaticallyFluxMonoCreation {
    public static void main(String[] args) {}

    public Flux<Object> programmaticallyFluxGeneration() {
        return Flux.generate(() -> 1, (state, sink) -> {
            sink.next(state * 2);
            if (state == 10) {
                sink.complete();
            }
            return state + 1;
        }).log();
    }
}
