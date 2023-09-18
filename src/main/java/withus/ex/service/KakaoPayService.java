package withus.ex.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import lombok.RequiredArgsConstructor;
<<<<<<< HEAD
import withus.ex.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import withus.ex.mapper.CartMapper;
import withus.ex.mapper.OrderMapper;
=======
>>>>>>> parent of a57dceb (develop 요청파일)
import withus.ex.vo.KakaoApproveResponse;
import withus.ex.vo.KakaoCancelResponse;
import withus.ex.vo.KakaoReadyResponse;

@Service
@RequiredArgsConstructor
@Transactional
public class KakaoPayService{
	
<<<<<<< HEAD
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	public OrderMapper orderMapper;
	
	@Autowired
	public CartMapper cartMapper;
	
=======
>>>>>>> parent of a57dceb (develop 요청파일)
    static final String cid = "TC0ONETIME"; // 가맹점 테스트 코드
    static final String admin_Key = "dc4cc79c267d4d604d38862f7c9d8bc6"; // 공개 조심! 본인 애플리케이션의 어드민 키를 넣어주세요
    private KakaoReadyResponse kakaoReady;
    
    public KakaoReadyResponse kakaoPayReady() {

         // 카카오페이 요청 양식
        MultiValueMap<String, String> parameters = new LinkedMultiValueMap<>();
        parameters.add("cid", cid);
        parameters.add("partner_order_id", "가맹점 주문 번호");
        parameters.add("partner_user_id", "가맹점 회원 ID");
        parameters.add("item_name", "상품명");
        parameters.add("quantity", "1"); //주문 수량
        parameters.add("total_amount", "10000");//총 금액
        parameters.add("vat_amount", "1000");//부가세
        parameters.add("tax_free_amount", "0");//상품 비과세 금액
        parameters.add("approval_url", "http://localhost:8181/payment/success"); // 성공 시 redirect url
        parameters.add("cancel_url", "http://localhost:8181/payment/cancel"); // 취소 시 redirect url
        parameters.add("fail_url", "http://localhost:8181/payment/fail"); // 실패 시 redirect url
        
        // 파라미터, 헤더
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(parameters, this.getHeaders());
        
        // 외부에 보낼 url
        RestTemplate restTemplate = new RestTemplate();

        kakaoReady = restTemplate.postForObject(
                "https://kapi.kakao.com/v1/payment/ready",
                requestEntity,
                KakaoReadyResponse.class);
                
        return kakaoReady;
    }
    
    /**
     * 결제 완료 승인
     */
    public KakaoApproveResponse ApproveResponse(String pgToken) {
    
        // 카카오 요청
        MultiValueMap<String, String> parameters = new LinkedMultiValueMap<>();
        parameters.add("cid", cid);
        parameters.add("tid", kakaoReady.getTid());
        parameters.add("partner_order_id", "가맹점 주문 번호");
        parameters.add("partner_user_id", "가맹점 회원 ID");
        parameters.add("pg_token", pgToken);

        // 파라미터, 헤더
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(parameters, this.getHeaders());
        
        // 외부에 보낼 url
        RestTemplate restTemplate = new RestTemplate();
        
        KakaoApproveResponse approveResponse = restTemplate.postForObject(
                "https://kapi.kakao.com/v1/payment/approve",
                requestEntity,
                KakaoApproveResponse.class);
                
        return approveResponse;
    }
    
    /**
    * 결제 환불
    */
    public KakaoCancelResponse kakaoCancel() {

        // 카카오페이 요청
        MultiValueMap<String, String> parameters = new LinkedMultiValueMap<>();
        parameters.add("cid", cid);
        parameters.add("tid", "환불할 결제 고유 번호");
        parameters.add("cancel_amount", "환불 금액");
        parameters.add("cancel_tax_free_amount", "환불 비과세 금액");
        parameters.add("cancel_vat_amount", "환불 부가세");

        // 파라미터, 헤더
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(parameters, this.getHeaders());
    
        // 외부에 보낼 url
        RestTemplate restTemplate = new RestTemplate();
    
        KakaoCancelResponse cancelResponse = restTemplate.postForObject(
                "https://kapi.kakao.com/v1/payment/cancel",
                requestEntity,
                KakaoCancelResponse.class);
                
        return cancelResponse;
    }
    
    /**
     * 카카오 요구 헤더값
     */
    private HttpHeaders getHeaders() {
        HttpHeaders httpHeaders = new HttpHeaders();

        String auth = "KakaoAK " + admin_Key;

        httpHeaders.set("Authorization", auth);
        httpHeaders.set("Content-type", "application/x-www-form-urlencoded;charset=utf-8");

        return httpHeaders;
    }

}
