package com.boot.demo.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.Calendar;

@RestController
public class NotificationController {

    @GetMapping("/notification/next")
    public Flux<String> getNextNotification() {
        return Flux.interval(Duration.ofSeconds(1))
                .map(aLong -> Calendar.getInstance().getTimeInMillis() + " : " + BigDecimal.valueOf(Math.random()*100).intValue())
                .log();
    }
}
