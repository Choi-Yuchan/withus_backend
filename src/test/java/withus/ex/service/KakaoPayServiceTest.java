package withus.ex.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import withus.ex.kakaoPay.KakaoReadyResponse;

@SpringBootTest
class KakaoPayServiceTest {
	
	@Autowired
	private KakaoPayService kakaoPayService;

	@Test
	void testKakaoPayReady() {
		System.out.println("Kakao Service" + kakaoPayService);
		System.out.println("Kakao Respose" + kakaoPayService.kakaoPayReady());
		
	}

}
