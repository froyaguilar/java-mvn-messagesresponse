package com.froyo.messages;

import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Log
class MessagePairTest {

    private Validator validator;

    @BeforeEach
    void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void whenNotBlankDescription_thenNoConstraintViolations() {
        MessagePair messagePair = new MessagePair(null, "error description", MessagePairTypeCode.INFO);
        Set<ConstraintViolation<MessagePair>> violations = validator.validate(messagePair);

        assertEquals(violations.size(), 0);
    }

    @Test
    public void whenBlankDescription_thenOneConstraintViolation() {
        MessagePair messagePair = new MessagePair(null, StringUtils.SPACE, MessagePairTypeCode.INFO);
        Set<ConstraintViolation<MessagePair>> violations = validator.validate(messagePair);

        violations.forEach(p -> {
            log.warning(p.getMessage());
        });

        assertThat(violations.size()).isEqualTo(1);
    }

    @Test
    public void whenEmptyDescription_thenOneConstraintViolation() {
        MessagePair messagePair = new MessagePair(null, StringUtils.EMPTY, MessagePairTypeCode.INFO);
        Set<ConstraintViolation<MessagePair>> violations = validator.validate(messagePair);

        assertThat(violations.size()).isEqualTo(1);
    }

    @Test
    public void whenNullDescription_thenOneConstraintViolation() {
        MessagePair messagePair = new MessagePair(null, null, MessagePairTypeCode.INFO);
        Set<ConstraintViolation<MessagePair>> violations = validator.validate(messagePair);

        assertThat(violations.size()).isEqualTo(1);
    }

    @Test
    void whenNullMessagePairType_thenOneConstraintViolation() {

        MessagePair messagePair = new MessagePair(null,"Description OK",null);
        Set<ConstraintViolation<MessagePair>> violations = validator.validate(messagePair);

        assertEquals(violations.size(),1);

    }

    @Test
    void testedGetters() {

        String code = "CODE-001";
        String description = "Code One";
        MessagePairTypeCode messagePairTypeCode = MessagePairTypeCode.INFO;

        MessagePair messagePair = new MessagePair(code,description,messagePairTypeCode);

        assertAll("getters",
                () -> assertEquals(code,messagePair.getCode()),
                () -> assertEquals(description,messagePair.getDescription()),
                () -> assertEquals(messagePairTypeCode,messagePair.getMessagePairTypeCode())
        );



    }
}
