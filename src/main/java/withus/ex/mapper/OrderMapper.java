package withus.ex.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import withus.ex.page.Criteria;
import withus.ex.vo.OrderPageItemVO;
import withus.ex.vo.OrderVO;

@Mapper
public interface OrderMapper {
	
	/* 주문 상품 정보 */ //상품의 정보를 DB로부터 요청하는 메서드 선언부를 작성합니다. 
	List<OrderPageItemVO> getGoodsInfo();
	
	void insertItem(OrderVO order); //바로주문하기
	
	//페이징
	int getTotalCount();
	public List<OrderPageItemVO> getOrderPaging(Criteria cri);

}
