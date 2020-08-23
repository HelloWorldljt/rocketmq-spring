package org.apache.rocketmq.spring.core;

import org.apache.rocketmq.spring.autoconfigure.MointorDataSourceConfiguration;
import org.apache.rocketmq.spring.domain.model.TroubleMsg;
import org.apache.rocketmq.spring.domain.service.TroubleMsgService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author lijiangtao
 * @description
 * @date 2020/8/23 0023
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {MointorDataSourceConfiguration.class})
public class TroubleMsgTest {

    @Autowired
    private TroubleMsgService troubleMsgService;

    @Test
    public void testTroubleMsg(){
        TroubleMsg byId = troubleMsgService.getById(1);
        System.out.println(byId);
    }


}
