package com.alirezagolshan;

import junit.framework.TestCase;
import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

class IntroductionToFluxTest extends TestCase {

    @Test
    void testNames_Map() {
        StepVerifier.create(IntroductionToFlux.names_map()).expectNext("MUHAMMET", "ALI", "ROBERT",
                "IVANA", "JESSIE", "CHEN").verifyComplete();
    }
}