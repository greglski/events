package com.kodilla.events.service;

import com.kodilla.events.event.ProductRegisteredEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ProductImageManager implements ApplicationListener<ProductRegisteredEvent> {
    @Override
    public void onApplicationEvent(ProductRegisteredEvent event) {
        log.info("Processing image of: {}", event.getProductName());
        log.info("The graphics is: {}", event.getOtherData());
    }

}
