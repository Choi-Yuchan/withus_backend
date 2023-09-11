package withus.ex.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import withus.ex.vo.OrderPageItemVO;

@Mapper
public interface OrderMapper {
	
	/* 주문 상품 정보 */ //상품의 정보를 DB로부터 요청하는 메서드 선언부를 작성합니다. 
	//public OrderPageItemVO getGoodsInfo(int product_number);
	List<OrderPageItemVO> getGoodsInfo();
	


}
