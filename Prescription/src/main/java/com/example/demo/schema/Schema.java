package com.example.demo.schema;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Schema {

    private String ver;
    private String id;
    private String name;
    private String version;
    @SerializedName("attrNames")
    private List<String> attrNames;
    @SerializedName("seqNo")
    private Integer seqNo;

    public Schema(String id, String name,Integer seqNo,String ver, String version, List<String> attrNames) {
        this.ver = ver;
        this.id = id;
        this.name = name;
        this.version = version;
        this.attrNames = attrNames;
        this.seqNo = seqNo;
    }
}
