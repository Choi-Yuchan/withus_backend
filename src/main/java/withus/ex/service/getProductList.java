package withus.ex.service;

import java.util.List;


import withus.ex.VO.GoodsViewVO;
import withus.ex.VO.CartListVO;
import withus.ex.VO.OrderListVO;


public interface getProductList {

	// 회원 탈퇴 처리
    public void withdraw(String userId) throws Exception;
    
	// 로그인 처리
    public MemberVO login(String userId, String password) throws Exception;
    
    // 로그아웃 처리
    public void logout(HttpSession session) throws Exception;
    
	//회원가입
	public void registerMember(UsersVO users) throws Exception;
	
	// 카테고리별 상품 리스트
	public List<GoodsViewVO> list(int cateCode, int level)  throws Exception;

	// 상품조회
	public GoodsViewVO goodsView(int gdsNum) throws Exception;

	// 카트 리스트
	public List<CartListVO> cartList(String userId) throws Exception;

	
	// 특정 주문 목록
	public List<OrderListVO> orderView(OrderVO order) throws Exception;
}


