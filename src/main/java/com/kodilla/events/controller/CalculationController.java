package com.kodilla.events.controller;

import com.kodilla.events.domain.CalculationDto;
import com.kodilla.events.service.CalculationService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("v1/calculation")
public class CalculationController implements ApplicationEventPublisherAware {
    private ApplicationEventPublisher publisher;
    private final CalculationService calculationService;

    @PatchMapping("/sum")
    public ResponseEntity<Integer> getSum(@RequestBody CalculationDto calculationDto) {
        return ResponseEntity.ok(calculationService.add(calculationDto));
    }

    @PatchMapping("/difference")
    public ResponseEntity<Integer> getDifference(@RequestBody CalculationDto calculationDto) {
        return ResponseEntity.ok(calculationService.substract(calculationDto));
    }

    @PatchMapping("/product")
    public ResponseEntity<Integer> getProduct(@RequestBody CalculationDto calculationDto) {
        return ResponseEntity.ok(calculationService.multiply(calculationDto));
    }

    @PatchMapping("/quotient")
    public ResponseEntity<Integer> getQuotient(@RequestBody CalculationDto calculationDto) {
        return ResponseEntity.ok(calculationService.divide(calculationDto));
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.publisher = applicationEventPublisher;
    }

}
