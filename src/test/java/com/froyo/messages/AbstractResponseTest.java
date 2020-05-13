package com.froyo.messages;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AbstractResponseTest {

    @Test
    void test_addMessagePair(){

        MessagePair messagePair = new MessagePair(null,null,null);

        AbstractResponse abstractResponse = new AbstractResponse();
        abstractResponse.addMessagePair(messagePair);
        assertEquals(1,abstractResponse.getMessagePairList().size());

    }

}
