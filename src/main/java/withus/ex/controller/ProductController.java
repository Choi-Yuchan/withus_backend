package withus.ex.controller;

import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.List;


import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;
import withus.ex.service.ProductService;
import withus.ex.vo.ProductVO;
import withus.ex.vo.UsersVO;

@Controller
@RequestMapping("/shop/*")
@Slf4j
public class ProductController<getproductlist> {

//	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

	@Autowired
	private ProductService productService;

//// 회원 탈퇴 처리
//    @RequestMapping(value = "/withdraw", method = RequestMethod.POST)
//    public String withdraw(HttpSession session) throws Exception {
//        UsersVO users = (UsersVO) session.getAttribute("users");
//        String userId = users.getUserId();
//
//        service.withdraw(userId); // 회원 탈퇴 처리 메서드 호출
//
//        session.invalidate(); // 로그아웃과 동시에 세션 종료
//
//        return "redirect:/shop/login"; // 회원 탈퇴 후 로그인 페이지로 리다이렉트
//    }
//    
//// 로그인 페이지로 이동
//    @RequestMapping(value = "/login", method = RequestMethod.GET)
//    public String showLoginPage() {
//        return "login"; // login.jsp와 같은 로그인 폼 페이지 이름
//    }
//
//// 로그인 처리
//    @RequestMapping(value = "/login", method = RequestMethod.POST)
//    public String login(@RequestParam("userId") String userId, @RequestParam("password") String password, HttpSession session, Model model) throws Exception {
//        // 로그인 정보 확인
//    	UsersVO users = service.login(userId, password);
//        
//        if (users != null) {
//            // 로그인 성공한 경우 세션에 사용자 정보 저장
//            session.setAttribute("users", users);
//            return "redirect:/shop/list"; // 로그인 후 페이지 이동
//        } else {
//            // 로그인 실패한 경우 에러 메시지 전달
//            model.addAttribute("error", "아이디 또는 비밀번호가 일치하지 않습니다.");
//            return "login"; // 다시 로그인 폼 페이지로 이동
//        }
//    }
//
//// 로그아웃 처리
//    @RequestMapping(value = "/logout", method = RequestMethod.GET)
//    public String logout(HttpSession session) {
//        session.invalidate(); // 세션 종료
//        return "redirect:/shop/list"; // 로그아웃 후 페이지 이동
//    }
//
//// 회원가입 페이지로 이동
//    @RequestMapping(value = "/register", method = RequestMethod.GET)
//    public String showRegisterPage() {
//        return "register"; // register.jsp와 같은 회원가입 폼 페이지 이름
//    }
//
//// 회원가입 처리
//    @RequestMapping(value = "/register", method = RequestMethod.POST)
//    public String registerMember(UsersVO users) {
//        // 회원 정보 저장하는 서비스 메서드 호출
//        // service.registerMember(member);
//
//        // 회원가입 후 로그인 페이지로 리다이렉트 또는 자동 로그인 처리
//        return "redirect:/shop/login"; // login.jsp와 같은 로그인 페이지 이름
//    }
	//전체 상품 리스트
    @GetMapping("/list")
    @ResponseBody
    public List<ProductVO> productList() {
    	return productService.getProductlist();
    	
    }
//    
//// 카테고리별 상품 리스트
//	@RequestMapping(value = "/list", method = RequestMethod.GET)
//	public void getList(@RequestParam("c") int cateCode,
//						@RequestParam("l") int level, Model model) throws Exception {
//		logger.info("get list");
//
//		List<ProductVO> list = null;
//		list = service.list(cateCode, level);
//
//		model.addAttribute("list", list);
//
//	}
//
//// 상품 조회
//	@RequestMapping(value = "/view", method = RequestMethod.GET)
//	public void getView(@RequestParam("n") int gdsNum, Model model) throws Exception {
//		logger.info("get view");
//
//		ProductVO view = service.goodsView(gdsNum);
//		model.addAttribute("view", view);
//
//		/*
//		List<ReplyListVO> reply = service.replyList(gdsNum);
//		model.addAttribute("reply", reply);
//		*/
//
//	}
//
//	/*
//// 상품 조회 - 소감(댓글) 작성
//	@RequestMapping(value = "/view", method = RequestMethod.POST)
//	public String registReply(ReplyVO reply, HttpSession session) throws Exception {
//		logger.info("regist reply");
//		
//		MemberVO member = (MemberVO)session.getAttribute("member");
//		reply.setUserId(member.getUserId());
//		
//		service.registReply(reply);
//		
//		return "redirect:/shop/view?n=" + reply.getGdsNum();
//	}*/
//	// 상품 소감(댓글) 작성
//	@ResponseBody
//	@RequestMapping(value = "/view/registReply", method = RequestMethod.POST)
//	public void registReply(ReplyVO reply, HttpSession session) throws Exception {
//		logger.info("regist reply");
//
//		UsersVO users = (UsersVO)session.getAttribute("users");
//		reply.setUserId(users.getUserId());
//
//		service.registReply(reply);
//	}	
//
//	// 상품 소감(댓글) 목록
//	@ResponseBody
//	@RequestMapping(value = "/view/replyList", method = RequestMethod.GET)
//	public List<ReplyListVO> getReplyList(@RequestParam("n") int gdsNum) throws Exception {
//		logger.info("get reply list");
//
//		List<ReplyListVO> reply = service.replyList(gdsNum);
//
//		return reply;
//	}
//
//	// 상품 소감(댓글) 삭제
//	@ResponseBody
//	@RequestMapping(value = "/view/deleteReply", method = RequestMethod.POST)
//	public int getReplyList(ReplyVO reply,  HttpSession session) throws Exception {
//		logger.info("post delete reply");
//
//		// 정상작동 여부를 확인하기 위한 변수
//		int result = 0;
//
//		UsersVO users = (UsersVO)session.getAttribute("users");  // 현재 로그인한  member 세션을 가져옴
//		String userId = service.idCheck(reply.getRepNum());  // 소감(댓글)을 작성한 사용자의 아이디를 가져옴
//
//		// 로그인한 아이디와, 소감을 작성한 아이디를 비교
//		if(users.getUserId().equals(userId)) {
//
//			// 로그인한 아이디가 작성한 아이디와 같다면
//
//			reply.setUserId(users.getUserId());  // reply에 userId 저장
//			service.deleteReply(reply);  // 서비스의 deleteReply 메서드 실행
//
//			// 결과값 변경
//			result = 1;
//		}
//
//		// 정상적으로 실행되면 소감 삭제가 진행되고, result값은 1이지만
//		// 비정상적으로 실행되면 소감 삭제가 안되고, result값이 0
//		return result;	
//	}
//
//	// 상품 소감(댓글) 수정
//	@ResponseBody
//	@RequestMapping(value = "/view/modifyReply", method = RequestMethod.POST)
//	public int modifyReply(ReplyVO reply, HttpSession session) throws Exception {
//		logger.info("modify reply");
//
//		int result = 0;
//
//		UsersVO users = (UsersVO)session.getAttribute("users");
//		String userId = service.idCheck(reply.getRepNum());
//
//		if(users.getUserId().equals(userId)) {
//
//			reply.setUserId(users.getUserId());
//			service.modifyReply(reply);
//			result = 1;
//		}
//
//		return result;
//
//	}	
//
//	// 카트 담기
//	@ResponseBody
//	@RequestMapping(value = "/view/addCart", method = RequestMethod.POST)
//	public int addCart(CartVO cart, HttpSession session) throws Exception {
//
//		int result = 0;
//
//		UsersVO users = (UsersVO)session.getAttribute("users");
//
//		if(users != null) {
//			cart.setUserId(users.getUserId());
//			service.addCart(cart);
//			result = 1;
//		}
//
//		return result;
//	}
//
//	// 카트 목록
//	@RequestMapping(value = "/cartList", method = RequestMethod.GET)
//	public void getCartList(HttpSession session, Model model) throws Exception {
//		logger.info("get cart list");
//
//		UsersVO users = (UsersVO)session.getAttribute("users");
//		String userId = users.getUserId();
//
//		List<CartVO> cartList = service.cartList(userId);
//
//		model.addAttribute("cartList", cartList);
//	}
//
//
//	// 카트 삭제
//	@ResponseBody
//	@RequestMapping(value = "/deleteCart", method = RequestMethod.POST)
//	public int deleteCart(HttpSession session, @RequestParam(value = "chbox[]") List<String> chArr, CartVO cart) throws Exception {
//		logger.info("delete cart");
//
//		UsersVO users = (UsersVO)session.getAttribute("users");
//		String userId = users.getUserId();
//
//		int result = 0;
//		int cartNum = 0;		
//
//		// 로그인 여부 구분
//		if(users != null) {
//			cart.setUserId(userId);
//
//			for(String i : chArr) {  // 에이젝스에서 받은 chArr의 갯수만큼 반복
//				cartNum = Integer.parseInt(i);  // i번째 데이터를 cartNum에 저장
//				cart.setCartNum(cartNum);
//				service.deleteCart(cart);
//			}			
//			result = 1;
//		}		
//		return result;		
//	}
//
//	// 주문
//	@RequestMapping(value = "/cartList", method = RequestMethod.POST)
//	public String order(HttpSession session, OrderVO order, OrderDetailVO orderDetail) throws Exception {
//		logger.info("order");
//
//		UsersVO users = (UsersVO)session.getAttribute("users");		
//		String userId = users.getUserId();
//
//		// 캘린더 호출
//		Calendar cal = Calendar.getInstance();
//		int year = cal.get(Calendar.YEAR);  // 연도 추출
//		String ym = year + new DecimalFormat("00").format(cal.get(Calendar.MONTH) + 1);  // 월 추출
//		String ymd = ym +  new DecimalFormat("00").format(cal.get(Calendar.DATE));  // 일 추출
//		String subNum = "";  // 랜덤 숫자를 저장할 문자열 변수
//
//		for(int i = 1; i <= 6; i ++) {  // 6회 반복
//			subNum += (int)(Math.random() * 10);  // 0~9까지의 숫자를 생성하여 subNum에 저장
//		}
//
//		String orderId = ymd + "_" + subNum;  // [연월일]_[랜덤숫자] 로 구성된 문자
//
//		order.setOrderId(orderId);
//		order.setUserId(userId);
//
//		service.orderInfo(order);
//
//		orderDetail.setOrderId(orderId);			
//		service.orderInfo_Details(orderDetail);
//
//		// 주문 테이블, 주문 상세 테이블에 데이터를 전송하고, 카트 비우기
//		service.cartAllDelete(userId);
//
//		return "redirect:/shop/orderList";		
//	}
//
//	// 주문 목록
//	@RequestMapping(value = "/orderList", method = RequestMethod.GET)
//	public void getOrderList(HttpSession session, OrderVO order, Model model) throws Exception {
//		logger.info("get order list");
//
//		UsersVO users = (UsersVO)session.getAttribute("users");
//		String userId = users.getUserId();
//
//		order.setUserId(userId);
//
//		List<OrderVO> orderList = service.orderList(order);
//
//		model.addAttribute("orderList", orderList);
//	}
//
//	// 주문 상세 목록
//	@RequestMapping(value = "/orderView", method = RequestMethod.GET)
//	public void getOrderList(HttpSession session,
//							@RequestParam("n") String orderId,
//							OrderVO order, Model model) throws Exception {
//		logger.info("get order view");
//
//		UsersVO users = (UsersVO)session.getAttribute("users");
//		String userId = users.getUserId();
//
//		order.setUserId(userId);
//		order.setOrderId(orderId);
//
//		List<OrderListVO> orderView = service.orderView(order);
//
//		model.addAttribute("orderView", orderView);
//	}



} 