package org.apache.rocketmq.spring.domain.dao;

import org.apache.ibatis.annotations.*;
import org.apache.rocketmq.spring.domain.model.TroubleMsg;

/**
 * @author lijiangtao
 * @description trouble msg dao
 * @date 2020/8/22 0022
 */
@Mapper
public interface TroubleMsgMapper {

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @Select("select * from trouble_msg where id = #{id} ")
    @Results(id = "baseResultMap",value = {
            @Result(column = "id",property = "id"),
            @Result(column = "msg_id",property = "msgId"),
            @Result(column = "type",property = "type"),
            @Result(column = "topic",property = "topic"),
            @Result(column = "msg_property",property = "msgProperty"),
            @Result(column = "msg_body",property = "msgBody"),
            @Result(column = "send_time",property = "sendTime"),
            @Result(column = "status",property = "status"),
            @Result(column = "create_time",property = "createTime"),
            @Result(column = "update_time",property = "updateTime"),
    })
    TroubleMsg getById(@Param("id") int id);

    /**
     * 插入记录
     * @param troubleMsg 发送失败消息实体
     */
    @Insert("insert into trouble_msg (msg_id,type,topic,msg_property,msg_body,send_time,status,create_time,update_time) " +
            " value (#{msgId},#{type},#{topic} ,#{msgProperty} ,#{msgBody} ,#{sendTime} ,#{status} ,#{createTime} ,#{updateTime} )")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(TroubleMsg troubleMsg);
}
