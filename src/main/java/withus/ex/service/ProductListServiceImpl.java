package withus.ex.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import withus.ex.mapper.ProductMapper;
import withus.ex.vo.ProductImgVO;
import withus.ex.vo.ProductVO;

@Service
public class ProductListServiceImpl implements ProductListService {

	@Autowired
	private ProductMapper productMapper;
    
	// 카테고리별 상품 리스트
	@Override
	public List<ProductVO> getProductlist() {
		return productMapper.selectList();
	}
	
	@Override
	public List<ProductImgVO> getProductImglist() {
		return productMapper.selectImgList();
	}

	// 상품 조회
//	@Override
//	public ProductVO goodsView(int gdsNum) throws Exception {
//		return getproductlist.goodsView(gdsNum);
//	}

	// 카트 리스트
//	@Override
//	public List<CartVO> cartList(String userId) throws Exception {
//		return getproductlist.cartList(userId);
//	}


	// 특정 주문
//	@Override
//	public List<OrderListVO> orderView(OrderVO order) throws Exception {
//		return getproductlist.orderView(order);
//	}


}








