package com.example.demo.aca.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SchemaResponseDTO {

    @JsonProperty("schema_id")
    private String schema_id;
    @JsonProperty("schema")
    private Schema schema;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public class Schema {
        @JsonProperty("ver")
        private String ver;
        @JsonProperty("id")
        private String id;
        @JsonProperty("name")
        private String name;
        @JsonProperty("version")
        private String version;
        @JsonProperty("attrNames")
        private List<String> attrNames;
        @JsonProperty("seqNo")
        private int seqNo;


    }


}
