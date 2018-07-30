package com.cherry.domain;

/**
 * Created by gaoxiaoqing on 2018/7/26.
 */
public class Music {
    /**
     * 音乐家信息
     */
    private Artist artist;
    /**
     *
     */
    private Track track;
    /**
     * 专辑信息
     */
    private Album album;

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public Track getTrack() {
        return track;
    }

    public void setTrack(Track track) {
        this.track = track;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }
}
