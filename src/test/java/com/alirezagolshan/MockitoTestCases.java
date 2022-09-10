package com.alirezagolshan;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.test.StepVerifier;

@ExtendWith(MockitoExtension.class)
class MockitoTestCases {

    @Mock
    FakeServiceForTestReason service;

    @InjectMocks
    ReactiveExceptionHandling reactiveExceptionHandling;

    @Test
    void fakeServiceCallError() {
        Mockito.when(reactiveExceptionHandling.fakeServiceCallExample()).thenCallRealMethod();
        StepVerifier.create(reactiveExceptionHandling.fakeServiceCallExample())
                .expectNext("Ali", "Dan", "Alex", "Marshall", "Lindsey")
                .verifyComplete();
    }
}