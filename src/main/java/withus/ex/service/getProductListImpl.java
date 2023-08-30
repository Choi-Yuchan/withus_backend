package withus.ex.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import withus.ex.VO.GoodsViewVO;
import withus.ex.VO.CartListVO;
import withus.ex.VO.OrderListVO;

@Service
public abstract class getProductListImpl implements getProductList {

	@Autowired
	private getProductList getproductlist;

	//로그인 구현
	@Override
    public MemberVO login(String userId, String password) throws Exception {
        // 로그인 처리 로직 구현
        // ...
    }
    
	//로그아웃 구현
    @Override
    public void logout(HttpSession session) throws Exception {
        session.invalidate(); // 세션 종료
    }
    
    // 회원 탈퇴 로직 구현
    @Override
    public void withdraw(String userId) throws Exception {
    }
    
	// 회원 가입 구현
    @Override
    public void registerMember(UsersVO users) throws Exception {
    	getproductlist.registerMember(users);
    }
    
	// 카테고리별 상품 리스트
	@Override
	public List<GoodsViewVO> list(int cateCode, int level) throws Exception {
		int cateCodeRef = 0;  // 카테고리 참조 코드. 없어도 무관

		if(level == 1) {  // lavel 1 = 1차 분류.
			cateCodeRef = cateCode;
			return getproductlist.list(cateCode, cateCodeRef);
			// 두가지 모두 cateCode로 해도 무관
		} else {  // lavel 2 = 2차 분류
			return getproductlist.list(cateCode);
		} 
	}

	// 상품 조회
	@Override
	public GoodsViewVO goodsView(int gdsNum) throws Exception {
		return getproductlist.goodsView(gdsNum);
	}

	// 카트 리스트
	@Override
	public List<CartListVO> cartList(String userId) throws Exception {
		return getproductlist.cartList(userId);
	}


	// 특정 주문
	@Override
	public List<OrderListVO> orderView(OrderVO order) throws Exception {
		return getproductlist.orderView(order);
	}
}








