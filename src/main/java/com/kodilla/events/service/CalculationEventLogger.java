package com.kodilla.events.service;

import com.kodilla.events.event.CalculationEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CalculationEventLogger implements ApplicationListener<CalculationEvent> {
    @Override
    public void onApplicationEvent(CalculationEvent event) {
        log.info("Calculation done. {} of {} and {} equals {}",
                event.getOperator(),
                event.getOperands().get(0),
                event.getOperands().get(1),
                event.getResult());
    }

}
