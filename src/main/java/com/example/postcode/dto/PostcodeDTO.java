package com.example.postcode.dto;

public class PostcodeDTO {

    public PostcodeDTO(Long code, String name){
        this.code = code;
        this.name = name;
    }
    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private Long code;
    private String name;
}
