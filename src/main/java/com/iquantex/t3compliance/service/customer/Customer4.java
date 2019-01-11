package com.iquantex.t3compliance.service.customer;

import com.iquantex.flowhandler.annotation.Parallel;
import com.iquantex.flowhandler.annotation.Stream;
import com.iquantex.flowhandler.bean.Tuple;
import com.iquantex.flowhandler.sevice.Emitor;
import com.iquantex.flowhandler.sevice.FieldsDeclarer;
import com.iquantex.flowhandler.sevice.IBolt;
import org.springframework.stereotype.Service;

@Service
@Stream(streamIds = "finishResult")
@Parallel(parallel = 2)
public class Customer4 implements IBolt {


    @Override
    public void execute(Tuple flowMsg, Emitor emitor) {
        try {
            Thread.sleep(1000);
//            throw new NullPointerException();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public FieldsDeclarer OutputFieldsDeclare(FieldsDeclarer declarer) {
        return null;
    }
}
