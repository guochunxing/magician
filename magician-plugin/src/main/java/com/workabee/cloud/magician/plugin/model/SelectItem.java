package com.workabee.cloud.magician.plugin.model;

/**
 * author: chunxing
 * date: 2021/3/15 14:28
 * description:
 */
public class SelectItem {

    public Object id;

    public String name;

    public String desc;

    public Object getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
