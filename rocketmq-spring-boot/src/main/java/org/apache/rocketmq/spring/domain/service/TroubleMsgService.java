package org.apache.rocketmq.spring.domain.service;

import com.alibaba.fastjson.JSON;
import org.apache.rocketmq.client.producer.SendStatus;
import org.apache.rocketmq.spring.domain.dao.TroubleMsgMapper;
import org.apache.rocketmq.spring.domain.model.TroubleMsg;
import org.apache.rocketmq.spring.domain.num.MsgType;
import org.apache.rocketmq.spring.domain.num.TroubleMsgStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;

/**
 * @author lijiangtao
 * @description 发送错误消息服务类
 * @date 2020/8/22 0022
 */
@Service
public class TroubleMsgService {
    private static final Logger log = LoggerFactory.getLogger(TroubleMsgService.class);
    @Autowired
    private TroubleMsgMapper troubleMsgMapper;

    public TroubleMsg getById(int id){
        return troubleMsgMapper.getById(id);
    }

    public void insert(String topic, Map<String, String> properties, Object payload, SendStatus sendStatus) {
        try {
            log.info("monitor trouble msg service insert trouble msg param:topic:{},properties:{},payload:{},sendStatus:{}"
                    ,topic,properties.toString(),JSON.toJSONString(payload),sendStatus);
            TroubleMsg troubleMsg = new TroubleMsg();
            troubleMsg.setType(MsgType.SEND_FAIL);
            troubleMsg.setTopic(topic);
            troubleMsg.setMsgBody(JSON.toJSONString(payload));
            troubleMsg.setSendTime(new Date());
            troubleMsg.setSendStatus(sendStatus);
            troubleMsg.setStatus(TroubleMsgStatus.TO_DO);
            troubleMsg.setMsgProperty(JSON.toJSONString(properties));
            troubleMsg.setCreateTime(new Date());
            troubleMsg.setUpdateTime(new Date());
            troubleMsgMapper.insert(troubleMsg);
        }catch (Exception e){
            log.error("monitor trouble msg service insert trouble msg fail",e);
        }
    }
}
