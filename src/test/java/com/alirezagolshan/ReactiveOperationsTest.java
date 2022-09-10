package com.alirezagolshan;

import junit.framework.TestCase;
import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

 class ReactiveOperationsTest extends TestCase {

    @Test
     void testFluxGenerator() {
        StepVerifier.create(ReactiveOperations.fluxGenerator()).expectNext("default").verifyComplete();
    }

    @Test
     void concatExample() {
        StepVerifier.create(ReactiveOperations.concatExample()).expectNextCount(6).verifyComplete();
    }

    @Test
     void concatWithExample() {
        StepVerifier.create(ReactiveOperations.concatWithExample()).expectNext("A", "B", "C", "D").verifyComplete();
    }

    @Test
     void mergeExample() {
        StepVerifier.create(ReactiveOperations.mergeExample()).expectNext("A", "D", "B", "C", "E", "F").verifyComplete();
    }

    @Test
     void mergeWithExample() {
        StepVerifier.create(ReactiveOperations.mergeWithExample()).expectNext("A", "D", "B", "C", "E", "F").verifyComplete();
    }

    @Test
     void mergeWithMonoExample() {
        StepVerifier.create(ReactiveOperations.mergeWithMonoExample()).expectNext("A", "B").verifyComplete();
    }

    @Test
     void mergeSequantialExample() {
        StepVerifier.create(ReactiveOperations.mergeSequantialExample()).expectNext("A", "S", "D", "Q", "W", "E").verifyComplete();
    }

    @Test
     void zipExample() {
        StepVerifier.create(ReactiveOperations.zipExample()).expectNext("AQ", "SW", "DE").verifyComplete();
    }
}
