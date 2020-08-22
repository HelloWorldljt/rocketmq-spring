package org.apache.rocketmq.spring.domain.num;

/**
 * 异常消息状态
 * @author lijiangtao
 */
public enum TroubleMsgStatus implements IntEnum {

    /**
     * 未处理
     */
    TO_DO(1,"未处理"),

    /**
     * 已处理
     */
    DONE(2,"已处理");

    private int code;
    private String desc;

    TroubleMsgStatus(int code, String desc) {
        this.code=code;
        this.desc=desc;
    }

    @Override
    public int getCode() {
        return this.code;
    }

    @Override
    public String toString() {
        return desc;
    }
}
