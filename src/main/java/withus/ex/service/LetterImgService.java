package withus.ex.service;

import java.util.List;

import withus.ex.vo.LetterImgVO;


public interface LetterImgService {

	/* 이미지 데이터 반환 */
	public List<LetterImgVO> getImgList(int wid);
}


