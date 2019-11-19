package com.froyo.messages;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;

@AllArgsConstructor
@Getter
@ToString
public enum MessagePairTypeCode implements Serializable {

    INFO("I", "INFO"), //
    SUCCESS("S", "SUCCESS"), //
    WARNING("W", "WARNING"), //
    ERROR("E", "ERROR");

    private String code;
    private String description;

}
