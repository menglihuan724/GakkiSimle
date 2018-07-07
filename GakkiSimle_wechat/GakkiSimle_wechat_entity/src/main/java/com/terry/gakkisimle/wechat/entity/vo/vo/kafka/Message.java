package com.terry.gakkisimle.wechat.entity.vo.vo.kafka;

import java.time.LocalDate;

public class Message {
    private Long id;
    private String msg;
    private LocalDate date;

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", msg='" + msg + '\'' +
                ", date=" + date +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
