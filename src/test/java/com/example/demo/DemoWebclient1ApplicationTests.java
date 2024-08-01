package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.AutoConfigureWebClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.assertj.core.api.Assertions.assertThat;


@AutoConfigureWebClient
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DemoWebclient1ApplicationTests {

	@Autowired
	WebTestClient webTestClient;

	/**
	 * webClient 활용예제
	 * https://velog.io/@discphy/%EC%8A%A4%ED%94%84%EB%A7%81-API-%EB%B9%84%EB%8F%99%EA%B8%B0-%EB%85%BC%EB%B8%94%EB%A1%9C%ED%82%B9-%EB%B0%A9%EC%8B%9D-%ED%98%B8%EC%B6%9C-How-to-call-API-with-async-nonblocking-method
	 */
	@Test
	void contextLoads() {
		System.out.println("webTestClient = " + webTestClient);

		webTestClient.method(HttpMethod.GET)
				.uri("/hello")
				.exchange()
				.expectStatus().isOk() // 응답 코드 기대값
				.expectBody(String.class) // 응답 body 클래스 타입 기대값
				.value(response -> { // 응답 바디 response
					System.out.println("response = " + response);
					assertThat(response).isEqualToIgnoringCase("Hello World");
				});

	}


}
