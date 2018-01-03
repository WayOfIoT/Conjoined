package org.blackist.conjoined.common.entity;

/**
 * TODO
 *
 * @author LiangLiang.Dong <1075512174@qq.com>.
 * @Date 2018/1/3 13:59.
 */
public class Controller {

    /**
     * id : 7148
     * shortName : demoswitch
     * name : RemoteSwitch
     * type : SWITCH
     * typeName : 开关控制
     * remark : null
     * minValue : null
     * maxValue : null
     */

    private int id;
    private String shortName;
    private String name;
    private String type;
    private String typeName;
    private Object remark;
    private Object minValue;
    private Object maxValue;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Object getRemark() {
        return remark;
    }

    public void setRemark(Object remark) {
        this.remark = remark;
    }

    public Object getMinValue() {
        return minValue;
    }

    public void setMinValue(Object minValue) {
        this.minValue = minValue;
    }

    public Object getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(Object maxValue) {
        this.maxValue = maxValue;
    }
}
