package org.apache.rocketmq.spring.domain.num;

/**
 * mybatis 数据库int值转换java枚举转换接口
 * @author lijiangtao
 */
public interface IntEnum {
    /**
     * 获取枚举对应数值
     */
    int getCode();
}
