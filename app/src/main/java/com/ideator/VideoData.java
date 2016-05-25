package com.ideator;

import java.util.Date;

/**
 * @author Patrick Shaw (Patrick.Leong.Shaw@gmail.com)
 * @since {25/05/2016}
 */
public class VideoData {
    private String url;
    private Date date;

    public VideoData(String url, Date date) {
        this.url = url;
        this.date = date;
    }

    public String getUrl() {
        return url;
    }

    public Date getDate() {
        return date;
    }
}
