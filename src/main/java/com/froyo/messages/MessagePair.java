package com.froyo.messages;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@AllArgsConstructor
@Data
public class MessagePair implements Serializable {

    private static final long serialVersionUID = 2734364864701881278L;

    private String code;
    private String description;
    private MessagePairTypeCode messagePairTypeCode;

}
