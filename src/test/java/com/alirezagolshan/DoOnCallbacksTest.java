package com.alirezagolshan;

import junit.framework.TestCase;
import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

 class DoOnCallbacksTest extends TestCase {

    @Test
     void testLevelGenerator() {
        StepVerifier.create(DoOnCallbacks.levelGenerator()).expectNextCount(4).verifyComplete();
    }

    @Test
     void testDoOnCallbacks() {
        StepVerifier.create(DoOnCallbacks.doOnCallbacks()).expectNext("Easy","Medium","Hard","WordClass").verifyComplete();
    }
}