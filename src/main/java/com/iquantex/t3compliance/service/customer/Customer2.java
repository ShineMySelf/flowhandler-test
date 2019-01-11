package com.iquantex.t3compliance.service.customer;

import com.iquantex.flowhandler.annotation.Parallel;
import com.iquantex.flowhandler.annotation.Stream;
import com.iquantex.flowhandler.bean.Fields;
import com.iquantex.flowhandler.bean.Tuple;
import com.iquantex.flowhandler.bean.Values;
import com.iquantex.flowhandler.sevice.Emitor;
import com.iquantex.flowhandler.sevice.FieldsDeclarer;
import com.iquantex.flowhandler.sevice.IBolt;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Stream(streamIds = OriginNode1.OriginNode1)
public class Customer2 implements IBolt {

    @Override
    public void execute(Tuple tuple, Emitor emitor) {
        List<String> valueByField = (List)tuple.getValueByField(OriginNode1.code);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        emitor.emit("finishResult",new Values());
    }

    @Override
    public FieldsDeclarer OutputFieldsDeclare(FieldsDeclarer declarer) {
        declarer.delareStream("finishResult",new Fields("test"));
        return declarer;
    }

}
