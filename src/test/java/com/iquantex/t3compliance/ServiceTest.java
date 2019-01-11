package com.iquantex.t3compliance;

import com.iquantex.flowhandler.sevice.TupleMarket;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceTest {

    @Autowired
    private TupleMarket flowManager;

    @Test
    public void test1(){
//        for (int i=0;i<2;i++){
//            String ss = String.valueOf(i);
//            new Thread(()-> flowManager.putMsg("riskResult",ss)).start();
//        }
//        for (int i=0;i<2;i++){
//            String ss = String.valueOf(i);
//            new Thread(()-> flowManager.putMsg("emailResult",ss)).start();
//        }

        try {
            Thread.sleep(100*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
