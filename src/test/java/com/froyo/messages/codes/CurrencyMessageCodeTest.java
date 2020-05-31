package com.froyo.messages.codes;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.froyo.messages.MessagePairTypeCode.ERROR;
import static com.froyo.messages.codes.CurrencyMessageCode.*;
import static org.junit.jupiter.api.Assertions.*;

class CurrencyMessageCodeTest {

    @Test
    void test_enums(){

        assertEquals("CY-1001",CY_1001.getCode());
        assertEquals("ERROR",CY_1001.getDescription());
        assertEquals(ERROR,CY_1001.getMessagePairTypeCode());

//        assertEquals("CY-1002",CY_1002.getCode());
//
//        assertEquals("CY-1101",CY_1101.getCode());
//        assertEquals("CY-1102",CY_1102.getCode());


    }

}
