package com.alirezagolshan;

import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

class IntroductionToMonoTest {

    @Test
    void monoGenerator() {
        StepVerifier.create(IntroductionToMono.monoGenerator()).expectNext("Muhammet").verifyComplete();
    }

    @Test
    void namesMono_map_filter(){
        StepVerifier.create(IntroductionToMono.namesMono_map_filter(3)).expectNext("ALEX").verifyComplete();
    }
}
