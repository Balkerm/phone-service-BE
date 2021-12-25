package com.phoneservice.domain;

public enum Country {
    CAMEROON("237"),
    ETHIOPIA("251"),
    MOROCCO("212"),
    MOZAMBIQUE("258"),
    UGANDA("256"),
    UNKNOWN("");

    private final String code;

    Country(String code){
        this.code = code;
    }

    public static Country getByCode(String code){

        for (Country country:values()){
            if(country.code.equals(code)){
                return country;
            }
        }
        return UNKNOWN;
    }

    public String getCode(){
        return this.code;
    }
}
