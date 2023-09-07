package withus.ex.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import withus.ex.vo.ProductImgVO;
import withus.ex.vo.ProductVO;

@Mapper
public interface ProductMapper {

	List<ProductVO> selectList();

	List<ProductImgVO> selectImgList();
	ProductVO selectDetail(int productNumber);
}