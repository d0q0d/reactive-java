package com.alirezagolshan;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.test.StepVerifier;

@ExtendWith(MockitoExtension.class)
class ProgrammaticallyFluxMonoCreationTest {

    @Mock
    ProgrammaticallyFluxMonoCreation pfmc;

    @Test
    void programmaticallyFluxGeneration() {
        Mockito.when(pfmc.programmaticallyFluxGeneration()).thenCallRealMethod();
        var flux = pfmc.programmaticallyFluxGeneration();
        StepVerifier.create(flux)
                .expectNextCount(10)
                .verifyComplete();
    }
}