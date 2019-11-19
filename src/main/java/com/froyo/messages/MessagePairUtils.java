package com.froyo.messages;

import com.froyo.messages.codes.CurrencyMessageCode;
import com.froyo.messages.codes.FilesMessageCode;

public interface MessagePairUtils {

    static MessagePair messagePair(CurrencyMessageCode currencyMessageCode) {
        return new MessagePair(currencyMessageCode.getCode(), //
                currencyMessageCode.getDescription(), //
                currencyMessageCode.getMessagePairTypeCode());
    }

    static MessagePair messagePair(FilesMessageCode filesMessageCode) {
        return new MessagePair(filesMessageCode.getCode(), //
                filesMessageCode.getDescription(), //
                filesMessageCode.getMessagePairTypeCode());
    }

}
