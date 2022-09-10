package com.alirezagolshan;

import lombok.Data;
import lombok.NoArgsConstructor;
import reactor.core.publisher.Flux;

@Data
@NoArgsConstructor
public class FakeServiceForTestReason {
    public Flux<String> fakeServiceCall() {
        return Flux.just("Dan", "Alex", "Marshall", "Lindsey")
                .onErrorMap((e) -> {
                    throw new RuntimeException("Test exception");
                });
    }
}