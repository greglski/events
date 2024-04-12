package com.kodilla.events.service;

import com.kodilla.events.domain.CalculationDto;
import com.kodilla.events.domain.Operation;
import com.kodilla.events.event.CalculationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalculationService implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher publisher;

    public Integer add(CalculationDto calculationDto) {
        var result = calculationDto.getA() + calculationDto.getB();
        publishCalculationEvent(calculationDto, Operation.SUM.getValue(), result);
        return result;
    }

    public Integer multiply(CalculationDto calculationDto) {
        var result = calculationDto.getA() * calculationDto.getB();
        publishCalculationEvent(calculationDto, Operation.MULTIPLICATION.getValue(), result);
        return result;
    }

    public Integer substract(CalculationDto calculationDto) {
        var result = calculationDto.getA() - calculationDto.getB();
        publishCalculationEvent(calculationDto, Operation.SUBTRACTION.getValue(), result);
        return result;
    }

    public Integer divide(CalculationDto calculationDto) {
        var result = calculationDto.getA() / calculationDto.getB();
        publishCalculationEvent(calculationDto, Operation.DIVISION.getValue(), result);
        return result;
    }

    private void publishCalculationEvent(CalculationDto calculationDto, String operation, Integer result) {
        publisher.publishEvent(
                new CalculationEvent(
                        this,
                        List.of(calculationDto.getA(), calculationDto.getB()),
                        operation,
                        result));
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.publisher = applicationEventPublisher;
    }

}
