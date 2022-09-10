package com.alirezagolshan;

import lombok.NoArgsConstructor;
import reactor.core.publisher.Flux;

@NoArgsConstructor
public class RepeatProcess {
    public static void main(String[] args) {
       RepeatProcess rp = new RepeatProcess();
       rp.repeatProcess().subscribe();

    }
    public  Flux<String> repeatProcess(){
        return stringFluxGenerator().map(e->testUpperCase(e))
                .onErrorMap(e->{throw new RuntimeException("Error occurred. Process will not be repeated");})
                .repeat()
                .log();
    }

    public Flux<String> stringFluxGenerator(){
        return Flux.just("First","Second","Third");
    }

    public String testUpperCase(String e){return e.toUpperCase();}

}
