package com.froyo.messages.codes;

import org.junit.jupiter.api.Test;

import static com.froyo.messages.MessagePairTypeCode.ERROR;
import static com.froyo.messages.codes.FilesMessageCode.FILE_1001;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FilesMessageCodeTest {

    @Test
    void test_enums(){

        assertEquals("FILE-1001",FILE_1001.getCode());
        assertEquals("ERROR",FILE_1001.getDescription());
        assertEquals(ERROR,FILE_1001.getMessagePairTypeCode());

    }

}
