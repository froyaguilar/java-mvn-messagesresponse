package com.froyo.messages.codes;

import com.froyo.messages.MessagePairTypeCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;

@AllArgsConstructor
@Getter
@ToString
public enum FilesMessageCode implements Serializable {

    //1001 General
    FILE_1001("FILE_1001", "ERROR", MessagePairTypeCode.ERROR), //
    FILE_1002("FILE_1002", "SUCCESS", MessagePairTypeCode.SUCCESS), //

    //1101
    FILE_1101("1101", "Error upload photo", MessagePairTypeCode.ERROR), //
    FILE_1102("1102", "Success to save album", MessagePairTypeCode.SUCCESS);

    private String code;
    private String description;
    private MessagePairTypeCode messagePairTypeCode;

}
