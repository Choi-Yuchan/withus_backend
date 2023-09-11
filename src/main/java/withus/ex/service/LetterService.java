package withus.ex.service;

import java.util.List;

import withus.ex.page.Criteria;
import withus.ex.vo.LetterVO;


public interface LetterService {

	//상품메인
	public List<LetterVO> getLeList();
	
	//상품상세페이지
	LetterVO getLeInfoList(int wid);
	
	//페이징처리
	public int getTotal();
	public List<LetterVO> getListLePaging(Criteria cri);
	
	
}


