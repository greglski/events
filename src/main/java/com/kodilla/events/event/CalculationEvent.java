package com.kodilla.events.event;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

import java.util.List;

@Getter
public class CalculationEvent extends ApplicationEvent {
    private final List<Integer> operands;
    private final String operator;
    private final Integer result;

    public CalculationEvent(Object source, List<Integer> operands, String operator, Integer result) {
        super(source);
        this.operands = operands;
        this.operator = operator;
        this.result = result;
    }

}
