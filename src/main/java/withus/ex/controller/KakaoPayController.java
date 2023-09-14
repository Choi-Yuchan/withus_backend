package withus.ex.controller;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.siot.IamportRestClient.IamportClient;
import com.siot.IamportRestClient.exception.IamportResponseException;
import com.siot.IamportRestClient.response.IamportResponse;
import com.siot.IamportRestClient.response.Payment;

import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import withus.ex.service.KakaoPayService;
import withus.ex.vo.KakaoApproveResponse;
import withus.ex.vo.KakaoCancelResponse;
import withus.ex.vo.KakaoReadyResponse;

@RestController
@RequestMapping("/payment")
@RequiredArgsConstructor
public class KakaoPayController{
	
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
    public ResponseEntity<KakaoApproveResponse> afterPayRequest(@RequestParam("pg_token") String pgToken) {

        KakaoApproveResponse kakaoApprove = kakaoPayService.ApproveResponse(pgToken);

        return new ResponseEntity<>(kakaoApprove, HttpStatus.OK);
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
