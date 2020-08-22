package org.apache.rocketmq.spring.domain.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
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
    TroubleMsg getById(@Param("id") int id);
}
