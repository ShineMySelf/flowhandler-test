package com.iquantex.t3compliance.runner;

import com.iquantex.flowhandler.sevice.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class Runner implements ApplicationRunner {

    @Autowired
    private Worker worker;

    @Override
    public void run(ApplicationArguments args){
        worker.startup();
    }
}
