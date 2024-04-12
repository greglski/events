package com.kodilla.events.domain;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Value;

@Getter
@RequiredArgsConstructor
public enum Operation {
    SUM("Sum"),
    SUBTRACTION("Difference"),
    MULTIPLICATION("Product"),
    DIVISION("Quotient");

    private final String value;

}
