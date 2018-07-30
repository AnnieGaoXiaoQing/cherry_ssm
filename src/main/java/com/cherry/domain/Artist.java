package com.cherry.domain;

/**
 * 艺术家
 * Created by gaoxiaoqing on 2018/7/26.
 */
public class Artist {
    /**
     * 姓名
     */
    private String name;
    /**
     * 乐队成员
     */
    private String members;
    /**
     * 来源
     */
    private String origin;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMembers() {
        return members;
    }

    public void setMembers(String members) {
        this.members = members;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    @Override
    public String toString() {
        return "Artist{" +
                "name='" + name + '\'' +
                ", members='" + members + '\'' +
                ", origin='" + origin + '\'' +
                '}';
    }
}
