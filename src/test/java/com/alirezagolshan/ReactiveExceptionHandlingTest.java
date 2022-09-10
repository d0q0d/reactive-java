package com.alirezagolshan;

import junit.framework.TestCase;
import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

class ReactiveExceptionHandlingTest extends TestCase {

    @Test
    void testOnErrorReturnExample() {
        StepVerifier.create(ReactiveExceptionHandling.onErrorReturnExample())
                .expectNext("Person1", "Person2", "Person3", "Person4")
                .verifyComplete();
    }

    @Test
    void testOnErrorResumeExample() {
        StepVerifier.create(ReactiveExceptionHandling.onErrorResumeExample())
                .expectNext("Person1", "Person2", "Person3", "Person4", "Person5")
                .verifyComplete();
    }

    @Test
    void testOnErrorContinueExample() {
        StepVerifier.create(ReactiveExceptionHandling.onErrorContinueExample())
                .expectNext("PERSON1", "PERSON3")
                .verifyComplete();
    }

    @Test
    void testOnErrorMapExample() {
        StepVerifier.create(ReactiveExceptionHandling.onErrorMapExample())
                .expectNext("Person1")
                .expectError(IllegalAccessException.class)
                .verify();
    }

    @Test
    void doOnErrorExample() {
        StepVerifier.create(ReactiveExceptionHandling.doOnErrorExample())
                .expectNext("Person1", "Person2", "Person3")
                .expectError(Exception.class)
                .verify();
    }

    @Test
    void monoOnErrorContinue_JustCompleteSignal() {
        StepVerifier.create(ReactiveExceptionHandling.monoOnErrorContinue("abc"))
                .verifyComplete();
    }

    @Test
    void monoOnErrorContinue_Passed() {
        StepVerifier.create(ReactiveExceptionHandling.monoOnErrorContinue("reactor"))
                .expectNext("reactor")
                .verifyComplete();
    }

}