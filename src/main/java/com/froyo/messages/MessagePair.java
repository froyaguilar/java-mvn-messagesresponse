package com.froyo.messages;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@AllArgsConstructor
@Getter
public class MessagePair implements Serializable {

    private static final long serialVersionUID = 2734364864701881278L;

    private String code;
    @NotBlank
    private String description;
    @NotNull
    private MessagePairTypeCode messagePairTypeCode;

}
