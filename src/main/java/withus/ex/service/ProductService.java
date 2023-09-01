package withus.ex.service;

import java.util.List;

import javax.servlet.http.HttpSession;


import withus.ex.vo.ProductVO;
import withus.ex.vo.UsersVO;


public interface ProductService {

	// 카테고리별 상품 리스트
	//public List<ProductVO> list(int cateCode, int level)  throws Exception;
	public List<ProductVO> getProductlist();

	// 상품조회
//	public ProductVO goodsView(int gdsNum) throws Exception;

	// 카트 리스트
	//public List<CartVO> cartList(String userId) throws Exception;

	
	// 특정 주문 목록
	//public List<OrderListVO> orderView(OrderVO order) throws Exception;
}


