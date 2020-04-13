package com.pandorax.wallpapervolleyapi;

public class WallpaperItem {

    private String webformatURL,likes,downloads;

    public WallpaperItem() {
    }

    public WallpaperItem(String webformatURL, String likes, String downloads) {
        this.webformatURL = webformatURL;
        this.likes = likes;
        this.downloads = downloads;
    }

    public String getWebformatURL() {
        return webformatURL;
    }

    public void setWebformatURL(String webformatURL) {
        this.webformatURL = webformatURL;
    }

    public String getLikes() {
        return likes;
    }

    public void setLikes(String likes) {
        this.likes = likes;
    }

    public String getDownloads() {
        return downloads;
    }

    public void setDownloads(String downloads) {
        this.downloads = downloads;
    }
}
