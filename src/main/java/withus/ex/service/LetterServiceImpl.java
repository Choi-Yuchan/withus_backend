package withus.ex.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import withus.ex.mapper.LetterImgMapper;
import withus.ex.mapper.LetterMapper;
import withus.ex.page.Criteria;
import withus.ex.vo.LetterImgVO;
import withus.ex.vo.LetterVO;

@Service
public class LetterServiceImpl implements LetterService {
	
	@Autowired
	private LetterMapper letterMapper;
	
	@Autowired
	private LetterImgMapper letterImgMapper;
	
	//청첩장 리스트
	@Override
	public List<LetterVO> getLeList() {
		return letterMapper.selectLeList();
	}

	//상품상세페이지
	@Override
	public LetterVO getLeInfoList(int wid) {
		//return letterMapper.selectLeInfo(wid);
		LetterVO goodsInfo = letterMapper.selectLeInfo(wid);
		goodsInfo.setImgList(letterImgMapper.selectImgList(wid));
		
		return goodsInfo;
	}
	
	//페이징 처리
	@Override
	public int getTotal() {
		return letterMapper.getTotalCount();
	}

	@Override
	public List<LetterVO> getListLePaging(Criteria cri) {
		return letterMapper.getListLePaging(cri);
	}

}


