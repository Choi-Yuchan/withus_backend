package withus.ex.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import withus.ex.service.KakaoPayService;
import withus.ex.service.OrderService;
import withus.ex.vo.KakaoApproveResponse;
import withus.ex.vo.KakaoCancelResponse;
import withus.ex.vo.KakaoReadyResponse;
import withus.ex.vo.OrderPageItemVO;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/payment")
@RequiredArgsConstructor
public class KakaoPayController{
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
    private final KakaoPayService kakaoPayService;
    
    /**
     * 결제요청
     */
    @GetMapping("/ready")//@PostMapping 
    public KakaoReadyResponse readyToKakaoPay() {

        return kakaoPayService.kakaoPayReady();
    }
    
    
    /**
     * 결제 성공
     */
    @GetMapping("/success")
    public List<Object> afterPayRequest(@RequestParam("pg_token") String pgToken) {
    	List<Object> combined = new ArrayList<>();
        KakaoApproveResponse kakaoApprove = kakaoPayService.ApproveResponse(pgToken);
        List<OrderPageItemVO> order = orderService.getOrderInfo();
        
        combined.add(kakaoApprove);
        combined.addAll(order);
        
        return combined;
    }


    /**
     * 결제 진행 중 취소
     */
    @GetMapping("/cancel")
    public void cancel() {

        //throw new BusinessLogicException(ExceptionCode.PAY_CANCEL);
    	//throw new Exception(ExceptionCode.PAY_CANCEL);
    }

    /**
     * 결제 실패
     */
    @GetMapping("/fail")
    public void fail() {

        //throw new BusinessLogicException(ExceptionCode.PAY_FAILED);
    }
    
    /**
     * 환불
     */
    @PostMapping("/refund")
    public ResponseEntity<KakaoCancelResponse> refund() {

        KakaoCancelResponse kakaoCancelResponse = kakaoPayService.kakaoCancel();

        return new ResponseEntity<>(kakaoCancelResponse, HttpStatus.OK);
    }

	
}
