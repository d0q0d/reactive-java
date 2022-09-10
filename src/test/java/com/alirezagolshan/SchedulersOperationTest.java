package com.alirezagolshan;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class SchedulersOperationTest {

    @Mock
    SchedulersOperation schedulersOperation;

    @Test
    void publishOn() {
        Mockito.when(schedulersOperation.publishOnExample()).thenCallRealMethod();
        Flux<String> stringFlux = schedulersOperation.publishOnExample();
        StepVerifier.create(stringFlux)
                .expectNextCount(6)
                .verifyComplete();
    }

    @Test
    void subscribeOn() {
        Mockito.when(schedulersOperation.subscribeOn()).thenCallRealMethod();

        StepVerifier.create(schedulersOperation.subscribeOn())
                .expectNext("ADAM", "MIKE", "KATE")
                .verifyComplete();
    }

    @Test
    void blockingToNonBlocking() throws InterruptedException {
        Mockito.when(schedulersOperation.fakeBlockingApiCalls()).thenReturn(List.of("Fake", "Api", "Data"));
        Mockito.when(schedulersOperation.blockingToNonBlocking()).thenCallRealMethod();

        StepVerifier.create(schedulersOperation.blockingToNonBlocking())
                .consumeNextWith(element -> {
                    assert (element.size() == 6);
                })
                .expectComplete()
                .verify();
    }

}