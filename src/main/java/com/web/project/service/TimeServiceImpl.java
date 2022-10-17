package com.web.project.service;

import java.time.LocalDateTime;

public class TimeServiceImpl {

    public final String url;

    public TimeServiceImpl(String url) {
        this.url = url;
    }

    public LocalDateTime getTime(){
        return LocalDateTime.now();
    }
}
