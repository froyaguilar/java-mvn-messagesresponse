package com.froyo.messages.codes;

import com.froyo.messages.MessagePairTypeCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;

@AllArgsConstructor
@Getter
@ToString
public enum CurrencyMessageCode implements Serializable {

    //1001 General
    CY_1001("CY_1001", "ERROR", MessagePairTypeCode.ERROR), //
    CY_1002("CY_1002", "SUCCESS", MessagePairTypeCode.SUCCESS), //

    //1101
    CY_1101("CY_1101", "Save currency successfully", MessagePairTypeCode.ERROR), //
    CY_1102("CY_1102", "Save currency fail", MessagePairTypeCode.SUCCESS);

    private String code;
    private String description;
    private MessagePairTypeCode messagePairTypeCode;

}
