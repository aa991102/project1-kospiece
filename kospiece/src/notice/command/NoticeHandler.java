package notice.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.command.CommandHandler;
import dto.NoticeVO;
import notice.service.NoticeListService;

public class NoticeHandler implements CommandHandler{
	
	private static final String FORM_VIEW = "/notice/notice.jsp";
	
	NoticeListService noticeListService = new NoticeListService(); //서비스객체 생성
	List<NoticeVO> noticeList=new ArrayList<NoticeVO>();
	String column="";
	String value="";
	
	@Override
	public String process(HttpServletRequest request, 
						  HttpServletResponse response) throws Exception {
		System.out.print("NoticeHandler 진입 ");

		//
		if(request.getMethod().equalsIgnoreCase("GET")) {
			System.out.print("get방식, 파라미터 없음, 전체 공지사항 출력");
			return processTotalNotice(request,response);
		}else if(request.getMethod().equalsIgnoreCase("POST")) {
			System.out.print("post방식, 파라미터 있음, 선택된 조건의 공지사항 출력");
			return processSelectedNotice(request,response);
		}else {
			response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED); 
			return   null;
		}
	}
	
	private String processTotalNotice(HttpServletRequest request, HttpServletResponse response) {
		//파라미터 없을때 실행하는 로직. 전체 공지사항 리스트를 출력
		
		noticeList=noticeListService.noticeListService(column,value);
		
		request.setAttribute("noticeList",noticeList);
		//페이지에서 출력할 공지사항 객체 arrayList를 request속성에 담아보내기
		//<1번글객체,2번글객체.....>
		
		return FORM_VIEW;
		
	}
	private String processSelectedNotice(HttpServletRequest request, HttpServletResponse response) {
		
		column=request.getParameter("search");
		value=request.getParameter("notice-inform");
		
		System.out.println(column+"컬럼의 "+value+"가 들어있는 공지사항만 출력");
		
		noticeList=noticeListService.noticeListService(column,value);
		request.setAttribute("noticeList",noticeList);
		//페이지에서 출력할 공지사항 객체 arrayList를 request속성에 담아보내기
		//<1번글객체,2번글객체.....>
		
		return FORM_VIEW;
		
	}
}
