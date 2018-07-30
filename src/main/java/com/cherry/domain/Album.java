package com.cherry.domain;

import java.util.List;

/**
 * 专辑多曲目
 * Created by gaoxiaoqing on 2018/7/26.
 */
public class Album {
    /**
     * 名称
     */
    private String name;

    /**
     * 专辑信息
     */
    private List<Track> tracks;

    /**
     * 音乐家列表
     */
    private List<String> musicians;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Track> getTracks() {
        return tracks;
    }

    public void setTracks(List<Track> tracks) {
        this.tracks = tracks;
    }

    public List<String> getMusicians() {
        return musicians;
    }

    public void setMusicians(List<String> musicians) {
        this.musicians = musicians;
    }

    @Override
    public String toString() {
        return "Album{" +
                "name='" + name + '\'' +
                ", tracks=" + tracks +
                ", musicians=" + musicians +
                '}';
    }
}
