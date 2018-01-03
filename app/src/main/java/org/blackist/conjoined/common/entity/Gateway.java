package org.blackist.conjoined.common.entity;

import java.util.List;

/**
 * TODO
 *
 * @author LiangLiang.Dong <1075512174@qq.com>.
 * @Date 2018/1/3 13:58.
 */
public class Gateway {

    /**
     * id : 31525
     * idName : 01
     * templateName :
     * no : null
     * name : 默认网关
     * typeName : other
     * description : null
     * position : null
     * isPublic : true
     * isControlled : false
     * internetAvailable : false
     * internetIPAddress : null
     * apiAddress : null
     * apiAddressInternet :
     * version : null
     * modbusSlaveId : null
     * modbusFunc : null
     * interval : null
     * wsInterval : null
     * sensors : []
     * controllers : []
     */

    private int id;
    private String idName;
    private String templateName;
    private Object no;
    private String name;
    private String typeName;
    private Object description;
    private Object position;
    private boolean isPublic;
    private boolean isControlled;
    private boolean internetAvailable;
    private Object internetIPAddress;
    private Object apiAddress;
    private String apiAddressInternet;
    private Object version;
    private Object modbusSlaveId;
    private Object modbusFunc;
    private Object interval;
    private Object wsInterval;
    private List<Sensor> sensors;
    private List<Controller> controllers;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdName() {
        return idName;
    }

    public void setIdName(String idName) {
        this.idName = idName;
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    public Object getNo() {
        return no;
    }

    public void setNo(Object no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Object getDescription() {
        return description;
    }

    public void setDescription(Object description) {
        this.description = description;
    }

    public Object getPosition() {
        return position;
    }

    public void setPosition(Object position) {
        this.position = position;
    }

    public boolean isIsPublic() {
        return isPublic;
    }

    public void setIsPublic(boolean isPublic) {
        this.isPublic = isPublic;
    }

    public boolean isIsControlled() {
        return isControlled;
    }

    public void setIsControlled(boolean isControlled) {
        this.isControlled = isControlled;
    }

    public boolean isInternetAvailable() {
        return internetAvailable;
    }

    public void setInternetAvailable(boolean internetAvailable) {
        this.internetAvailable = internetAvailable;
    }

    public Object getInternetIPAddress() {
        return internetIPAddress;
    }

    public void setInternetIPAddress(Object internetIPAddress) {
        this.internetIPAddress = internetIPAddress;
    }

    public Object getApiAddress() {
        return apiAddress;
    }

    public void setApiAddress(Object apiAddress) {
        this.apiAddress = apiAddress;
    }

    public String getApiAddressInternet() {
        return apiAddressInternet;
    }

    public void setApiAddressInternet(String apiAddressInternet) {
        this.apiAddressInternet = apiAddressInternet;
    }

    public Object getVersion() {
        return version;
    }

    public void setVersion(Object version) {
        this.version = version;
    }

    public Object getModbusSlaveId() {
        return modbusSlaveId;
    }

    public void setModbusSlaveId(Object modbusSlaveId) {
        this.modbusSlaveId = modbusSlaveId;
    }

    public Object getModbusFunc() {
        return modbusFunc;
    }

    public void setModbusFunc(Object modbusFunc) {
        this.modbusFunc = modbusFunc;
    }

    public Object getInterval() {
        return interval;
    }

    public void setInterval(Object interval) {
        this.interval = interval;
    }

    public Object getWsInterval() {
        return wsInterval;
    }

    public void setWsInterval(Object wsInterval) {
        this.wsInterval = wsInterval;
    }

    public List<?> getSensors() {
        return sensors;
    }

    public void setSensors(List<Sensor> sensors) {
        this.sensors = sensors;
    }

    public List<?> getControllers() {
        return controllers;
    }

    public void setControllers(List<Controller> controllers) {
        this.controllers = controllers;
    }
}
