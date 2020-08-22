package org.apache.rocketmq.spring.domain.service;

import org.apache.rocketmq.spring.domain.dao.TroubleMsgMapper;
import org.apache.rocketmq.spring.domain.model.TroubleMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lijiangtao
 * @description 发送错误消息服务类
 * @date 2020/8/22 0022
 */
@Service
public class TroubleMsgService {
    @Autowired
    private TroubleMsgMapper troubleMsgMapper;


    public TroubleMsg getById(int id){
        return troubleMsgMapper.getById(id);
    }

}
