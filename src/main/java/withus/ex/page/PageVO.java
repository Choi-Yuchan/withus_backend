package withus.ex.page;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class PageVO {
	//페이징 처리 할때 필요한 정보들
	private int startPage; //화면에 보여지는 페이지 시작번호	
	private int endPage;	//이전과 다음으로 이동 가능한 링크 표시
	private boolean prev, next; //이전과 다음으로 이동 가능한 링크 표시
	
	private int total; //전체 상품 글 수
	private Criteria cri;
	
	public PageVO(Criteria cri, int total) {
		this.cri = cri;
		this.total = total;	//전체 데이타 수 
		
		this.endPage = (int) (Math.ceil(cri.getPageNum() / 10.0)) * 10; // 1부터10까지보여줄거니까 현재페이지*10
		this.startPage = this.endPage - 9; // 마지막페이지10에서 9빼면 현재페이지니까
		// Total을 통한 endPage의 재계산
		// 10개씩 보여주는 경우, 전체 데이터 수가 80개라고 가정하면 끝번호는 10이 아닌 8이 됨
		int realEnd = (int) (Math.ceil((total * 1.0) / cri.getAmount()));

		if (realEnd <= this.endPage) { // 제일 마지막 페이지
			this.endPage = realEnd;		
		}
		// 페이지 옆으로 넘기는 버튼 부분
		// 시작번호가 1보다 큰경우 존재(0번에서시작하는 게시글 없으니까 제한두기)
		this.prev = this.startPage > 1; // <<
		// realEnd가 끝번호(endPage)보다 큰 경우에만 존재
		this.next = this.endPage < realEnd; // >>		

	}
	
	public String makeQuery(int page) {
		UriComponents uriComponentsBuilder = UriComponentsBuilder.newInstance()
				.queryParam("pageNum", page) // pageNum =																											// 3
				.queryParam("amount", cri.getAmount()) // pageNum=3&amount=10
				.build(); // ?pageNum=3&amount=10
		return uriComponentsBuilder.toUriString(); // ?pageNum=3&amount=10 리턴
	}
	
}
