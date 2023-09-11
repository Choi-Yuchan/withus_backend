package withus.ex.vo;


import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LetterVO {
	
	private int wid;
	private String wname;
	private int wprice;
	private String wdetailed;
	private List<LetterImgVO> imgList;
}
