package com.example.demo.dto;

import javax.annotation.Nonnull;

public class AcceptRequestDTO {


    @Nonnull
    private String conn_id;
    private String meditation_id;
    private String my_endpoind;

    @Nonnull
    public String getConn_id() {
        return conn_id;
    }

    public void setConn_id(@Nonnull String conn_id) {
        this.conn_id = conn_id;
    }

    public String getMeditation_id() {
        return meditation_id;
    }

    public void setMeditation_id(String meditation_id) {
        this.meditation_id = meditation_id;
    }

    public String getMy_endpoind() {
        return my_endpoind;
    }

    public void setMy_endpoind(String my_endpoind) {
        this.my_endpoind = my_endpoind;
    }
}
