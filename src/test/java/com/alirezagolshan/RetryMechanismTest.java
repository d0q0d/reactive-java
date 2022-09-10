package com.alirezagolshan;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;
import reactor.util.retry.Retry;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RetryMechanismTest {

    @Spy
    RetryMechanism retryMechanism;

    @Mock
    Retry retry;

    @Test
    void fakeServiceCallRetryExample() {
        Mockito.when(retryMechanism.fakeServiceCallRetryExample()).thenCallRealMethod();
        Flux<String> stringFlux = retryMechanism.fakeServiceCallRetryExample().log();
        StepVerifier.create(stringFlux)
                .expectNextCount(4)
                .verifyComplete();
    }

    @Test
    void retryWhenExampleTest() {
        Mockito.when(retryMechanism.retrySpecs()).thenCallRealMethod();
        Mockito.when(retryMechanism.retryWhenExample()).thenCallRealMethod();
        retryMechanism.retryWhenExample();
        verify(retryMechanism, times(6)).retryElementProcess("3");
    }

}