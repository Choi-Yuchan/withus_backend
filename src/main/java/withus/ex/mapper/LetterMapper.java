package withus.ex.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import withus.ex.page.Criteria;
import withus.ex.vo.LetterVO;

@Mapper
public interface LetterMapper {

	//상품메인
	List<LetterVO> selectLeList();
	
	//상품상세페이지
	LetterVO selectLeInfo(int wid);
	
	//페이징
	int getTotalCount();
	public List<LetterVO> getListLePaging(Criteria cri);
	
	

}