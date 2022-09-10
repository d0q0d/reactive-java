package com.alirezagolshan;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class RepeatProcessTest {
    @Mock
    RepeatProcess repeatProcess;

    @Test
    void repeatProcess() {
        Mockito.when(repeatProcess.repeatProcess()).thenCallRealMethod();
        Mockito.when(repeatProcess.stringFluxGenerator()).thenCallRealMethod();
        Mockito.when(repeatProcess.testUpperCase(any())).thenCallRealMethod();
        Flux<String> stringFlux = repeatProcess.repeatProcess();
        StepVerifier.create(stringFlux).expectNextCount(3).thenCancel().verify();
        verify(repeatProcess, times(3)).testUpperCase(any());
    }
}