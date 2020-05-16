package com.froyo.messages;

import com.froyo.messages.exceptions.ValidationConstraintRemote;
import lombok.extern.java.Log;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

@Log
class AbstractResponseTest {

    private Validator validator;

    @BeforeEach
    void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void test_addMessagePair() {

        MessagePair messagePair3 = new MessagePair("CODE-003", "", MessagePairTypeCode.INFO);
        MessagePair messagePair2 = new MessagePair("CODE-002", "", null);
        MessagePair messagePair1 = new MessagePair("CODE-001", "Code One", MessagePairTypeCode.ERROR);

        AbstractResponse abstractResponse = new AbstractResponse();
        abstractResponse.addMessagePair(messagePair3);
        abstractResponse.addMessagePair(messagePair2);
        abstractResponse.addMessagePair(messagePair1);

        abstractResponse.getMessagePairList().forEach(v -> {
            Set<ConstraintViolation<MessagePair>> violations = validator.validate(v);

            violations.forEach(p -> {
                log.warning(p.toString());
            });

        });

        assertEquals(3, abstractResponse.getMessagePairList().size());
        assertTrue(abstractResponse.has(MessagePairTypeCode.ERROR));

        //JUnit 5
        assertThrows(NullPointerException.class, () -> abstractResponse.has(null));

        //assertj
        assertThatThrownBy(() -> {
            abstractResponse.has(null);
        }).isInstanceOf(NullPointerException.class)
                .hasMessageContaining("messagePairTypeCode is marked non-null but is null");


        //assertj
        assertThatThrownBy(() -> {
            abstractResponse.fetchMessagePair(null);
        }).isInstanceOf(NullPointerException.class)
                .hasMessageContaining("messagePairTypeCode is marked non-null but is null");


        assertEquals(1,abstractResponse.fetchMessagePair(MessagePairTypeCode.ERROR).size());

        assertThatThrownBy(() -> {
            abstractResponse.hasValidationConstraint();
        }).isInstanceOf(ValidationConstraintRemote.class)
                .hasNoNullFieldsOrProperties();


    }

}
