package com.boot.demo.demo.controller;

import com.boot.demo.demo.service.DemoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.EntityExchangeResult;
import org.springframework.test.web.reactive.server.FluxExchangeResult;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;

import static org.junit.jupiter.api.Assertions.*;

@WebFluxTest
class NotificationControllerTest {

    @Autowired
    private WebTestClient webTestClient;
    @MockBean
    private DemoService demoService;

    @Test
    void getNextNotification() {
        try {
            FluxExchangeResult<String> result = webTestClient.get().uri("/notification/next")
                    .exchange()
                    .expectStatus().isOk()
                    .returnResult(String.class);
        } catch (IllegalStateException ex) {}
    }
}