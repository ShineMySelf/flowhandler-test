package com.iquantex.t3compliance.service.customer;

import com.iquantex.flowhandler.annotation.Parallel;
import com.iquantex.flowhandler.bean.Fields;
import com.iquantex.flowhandler.bean.ReportMsg;
import com.iquantex.flowhandler.bean.Values;
import com.iquantex.flowhandler.sevice.Emitor;
import com.iquantex.flowhandler.sevice.FieldsDeclarer;
import com.iquantex.flowhandler.sevice.ISpout;
import org.springframework.stereotype.Service;

import java.util.Arrays;


@Service
public class OriginNode1 implements ISpout {

    public static final String OriginNode1 = "OriginNode1";

    public static final String code = "code";

    private int count = 0;



    @Override
    public void execute(Emitor emitor) {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        emitor.emit(OriginNode1,new Values(Arrays.asList("a","b","c")));
    }

    @Override
    public void ack(ReportMsg reportMsg) {
        if (reportMsg.getCurrent()==null){
            System.out.println(reportMsg.getSource()+":发送成功");
        }else {
            System.out.println(reportMsg.getCurrent()+":消费成功，消费时间为："+reportMsg.getTime()+",源节点是："+reportMsg.getSource());
        }
//        count++;
//        if (count==400){
//            System.out.println(this.getClass().getSimpleName()+"消费完成："+System.currentTimeMillis());
//        }
    }

    @Override
    public void fail(ReportMsg reportMsg) {
        if (reportMsg.getCurrent()==null){
            System.out.println(reportMsg.getSource()+":消费失败");
        }else {
            System.out.println(reportMsg.getCurrent()+":消费失败，消费时间为："+reportMsg.getTime()+",源节点是："+reportMsg.getSource());
        }
    }

    @Override
    public FieldsDeclarer OutputFieldsDeclare(FieldsDeclarer declarer) {
        declarer.delare(new Fields(code));
        declarer.delareStream(OriginNode1,new Fields(code));
        return declarer;
    }
}
