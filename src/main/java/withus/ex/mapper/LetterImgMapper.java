package withus.ex.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import withus.ex.vo.LetterImgVO;
import withus.ex.vo.LetterVO;

@Mapper
public interface LetterImgMapper {

	/* 이미지 데이터 반환 */
	public List<LetterImgVO> selectImgList(int wid);

}