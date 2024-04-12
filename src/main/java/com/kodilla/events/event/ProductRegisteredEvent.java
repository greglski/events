package com.kodilla.events.event;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class ProductRegisteredEvent extends ApplicationEvent {
    private final String productName;
    private final String otherData;

    public ProductRegisteredEvent(Object source, String productName, String otherData) {
        super(source);
        this.productName = productName;
        this.otherData = otherData;
    }

}
