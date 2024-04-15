package com.kodilla.events.controller;

import com.kodilla.events.domain.CalculationDto;
import com.kodilla.events.exception.DivisionException;
import com.kodilla.events.service.CalculationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("v1/calculation")
public class CalculationController {

    private final CalculationService calculationService;

    @PostMapping("/sum")
    public ResponseEntity<Integer> findSum(@RequestBody CalculationDto calculationDto) {
        return ResponseEntity.ok(calculationService.add(calculationDto));
    }

    @PostMapping("/difference")
    public ResponseEntity<Integer> findDifference(@RequestBody CalculationDto calculationDto) {
        return ResponseEntity.ok(calculationService.substract(calculationDto));
    }

    @PostMapping("/product")
    public ResponseEntity<Integer> findProduct(@RequestBody CalculationDto calculationDto) {
        return ResponseEntity.ok(calculationService.multiply(calculationDto));
    }

    @PostMapping("/quotient")
    public ResponseEntity<Integer> findQuotient(@RequestBody CalculationDto calculationDto) {
        if (calculationDto.getB() == 0) {
            throw new DivisionException("Division exception: Cannot divide by 0", HttpStatus.BAD_REQUEST.getReasonPhrase());
        }
        return ResponseEntity.ok(calculationService.divide(calculationDto));
    }

}
