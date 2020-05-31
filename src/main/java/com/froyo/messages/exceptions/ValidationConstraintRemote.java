package com.froyo.messages.exceptions;

import com.froyo.messages.MessagePair;
import lombok.Getter;
import lombok.NonNull;

import javax.validation.ConstraintViolation;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class ValidationConstraintRemote extends RuntimeException {

    private String exceptionMessage;
    private List<Set<ConstraintViolation<MessagePair>>> listOfConstraintsFound;

    private ValidationConstraintRemote(){
        throw new AssertionError();
    }

    public ValidationConstraintRemote(@NonNull List<Set<ConstraintViolation<MessagePair>>> listOfConstraintsFound){
        this.exceptionMessage = "Please check the constraints for <<MessagePair>> class";
        this.listOfConstraintsFound = listOfConstraintsFound;
    }

    public String getExceptionMessage() {
        return exceptionMessage;
    }

    public List<Set<ConstraintViolation<MessagePair>>> getListOfConstraintsFound() {
        return Collections.unmodifiableList(this.listOfConstraintsFound);
    }

}
