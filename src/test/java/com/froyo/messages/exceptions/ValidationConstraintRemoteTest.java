package com.froyo.messages.exceptions;

import com.froyo.messages.MessagePair;
import com.froyo.messages.MessagePairTypeCode;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ValidationConstraintRemoteTest {

    private static ValidationConstraintRemote validationConstraintRemote;

    @BeforeAll
    static void beforeAll() {

        List<Set<ConstraintViolation<MessagePair>>> listOfConstraintsFound =
                new ArrayList<>();

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        List<MessagePair> messagePairList = new ArrayList<>();
        MessagePair messagePair2 = new MessagePair("CODE-003", "", MessagePairTypeCode.INFO);
        MessagePair messagePair3 = new MessagePair("CODE-002", "", null);
        messagePairList.add(messagePair2);
        messagePairList.add(messagePair3);

        messagePairList.forEach(v -> {
            Set<ConstraintViolation<MessagePair>> violations = validator.validate(v);
            if(!violations.isEmpty()){
                listOfConstraintsFound.add(violations);
            }
        });

        validationConstraintRemote = new ValidationConstraintRemote(listOfConstraintsFound);
    }

    @Test
    void getExceptionMessage() {
        String exceptionMessage = "Please check the constraints for <<MessagePair>> class";
        assertThat(validationConstraintRemote.getExceptionMessage()).isEqualTo(exceptionMessage);
    }

    @Test
    void getListOfConstraintsFound() {
        assertThat(validationConstraintRemote.getListOfConstraintsFound().size()).isEqualTo(2);
    }
}
