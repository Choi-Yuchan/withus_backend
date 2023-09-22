package withus.ex.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import withus.ex.mapper.LetterImgMapper;
import withus.ex.vo.LetterImgVO;

@Service
public class LetterImgServiceImpl implements LetterImgService {
	
	@Autowired
	private LetterImgMapper letterImgMapper;

	@Override
	public List<LetterImgVO> getImgList(int wid) {
		return letterImgMapper.selectImgList(wid);
	}
	
	

}


