package com.froyo.messages.codes;

import com.froyo.messages.MessagePairTypeCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;

import static com.froyo.messages.MessagePairTypeCode.ERROR;
import static com.froyo.messages.MessagePairTypeCode.SUCCESS;

@AllArgsConstructor
@Getter
public enum CurrencyMessageCode implements Serializable {

    //1001 General
    CY_1001("CY-1001", "ERROR", ERROR), //
    CY_1002("CY-1002", "SUCCESS", SUCCESS), //

    //1101
    CY_1101("CY-1101", "Error when try to save currency", ERROR), //
    CY_1102("CY-1102", "Save currency successfully", SUCCESS);

    private String code;
    private String description;
    private MessagePairTypeCode messagePairTypeCode;

}
