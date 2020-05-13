package com.froyo.messages;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class AbstractResponse implements Serializable {

    private static final long serialVersionUID = -2762361600162949130L;

    private List<MessagePair> messagePairList = new ArrayList<>();

    public void addMessagePair(MessagePair messagePair) {
        messagePairList.add(messagePair);
    }

    public Boolean has(MessagePairTypeCode messagePairTypeCode) {
        return messagePairList.stream() //
                .anyMatch(s -> messagePairTypeCode.equals(s.getMessagePairTypeCode()));
    }

    public List<MessagePair> fetchMessagePair(MessagePairTypeCode messagePairTypeCode) {
        return messagePairList.stream() //
                .filter(s -> messagePairTypeCode.equals(s.getMessagePairTypeCode())) //
                .collect(Collectors.toList());
    }

}
