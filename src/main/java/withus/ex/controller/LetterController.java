package withus.ex.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.realm.CombinedRealm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import withus.ex.page.Criteria;
import withus.ex.page.PageVO;
import withus.ex.service.LetterImgService;
import withus.ex.service.LetterService;
import withus.ex.vo.LetterImgVO;
import withus.ex.vo.LetterVO;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/letter/*")
public class LetterController {
	
	@Autowired
	private LetterService letterService;
	
	@Autowired
	private LetterImgService letterImgService;
	
	//상품메인
	@GetMapping("/letterList")
	public List<LetterVO> letterList() {
		List<LetterVO> letter = letterService.getLeList();
		return letter;
	}
	
	//상품상세
	@GetMapping("/detail/{wid}")
	public LetterVO detail(@PathVariable int wid) {
		LetterVO detail = letterService.getLeInfoList(wid);
		return detail;
	}
	
	//페이징처리
	@GetMapping("/list")	//get 메소드로 처리하도록
	public String list(Criteria cri, Model model) {
		model.addAttribute("letterList", letterService.getListLePaging(cri)); //글 10개 가져오는 부분
		
		int total = letterService.getTotal();
		model.addAttribute("pageMaker", new PageVO(cri, total)); //페이지버튼그리기위한 정보
		return "letter/list";
	}
	
	
	/* 이미지 출력 */
	@GetMapping("/display")
	public ResponseEntity<byte[]> getImage(String fileName){
		
		File file = new File("c:\\upload\\" + fileName);
		
		ResponseEntity<byte[]> result = null;
		
		try {
			
			HttpHeaders header = new HttpHeaders();
			
			header.add("Content-type", Files.probeContentType(file.toPath()));
			
			result = new ResponseEntity<>(FileCopyUtils.copyToByteArray(file), header, HttpStatus.OK);
			
		}catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/* 이미지 정보 반환 */
	@GetMapping("/letterImgList")
	public ResponseEntity<List<LetterImgVO>> getImgList(int wid){
		
		return new ResponseEntity<List<LetterImgVO>>(letterImgService.getImgList(wid), HttpStatus.OK);
		
	}


} 