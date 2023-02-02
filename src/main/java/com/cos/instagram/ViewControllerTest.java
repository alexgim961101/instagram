package com.cos.instagram;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controller VS (Servlet) Dispatcher
 * Controller : 요청을 받아 처리하는 곳
 * Dispatcher : 요청을 분기시켜주는 곳 (보통 도메인 단위로 분기)
 * */

/**
 * Http method
 * GET : 데이터 요청
 * POST : 데이터 전송 (Http Body 필요)
 * PUT : 데이터 갱신 (Http Body 필요)
 * DELETE : 데이터 삭제
 * */

/**
 * 쿼리스트링, 주소 변수 매핑
 * 쿼리스트링 : http://localhost:8080/chicken?type=치킨    ->  String type 로 받음
 * 주소 변수 매핑 :http://localhost:8080/chicken/{type}     -> @Pathvariable String type 로 받음    (스프링 부트에서는 주로 주소 변수 매핑을 씀)
 * */

/**
 * Http Body 데이터 전송 (Post, Put 에서만 사용)
 * Content-Type : x-www-form-urlencoded(스프링이 기본적으로 파싱해줌) , form-data(파일 업/다운로드시 사용) , text/plain(@RequestBody로 받음) , application/json(@RequestBody + DTO객체로 받음)
 * */

/**
 * logger 사용 방법
 * private static final Logger logger = LoggerFactory.getLogger(해당 콘트롤러 명.class)
 * */

/**
 * JSON 응답 방법
 * 객체를 리턴시키면 됨 
 * MessageConverter가 자동으로 Java 객체를 Json으로 변경시켜줌
 * */

/**
 * 템플릿 엔진 (JSP, 타임리프)
 * 정의 : 자바 코드를 HTML로 변환시켜주는 도구
 * 웹 서버에 .jsp 파일 요청 -> 웹 서버에 톰켓으로 .jsp 파일을 톰겟으로 보냄 -> 톰켓에서 JSP파일 해석후 HTML로 변환 -> 클라이언트에게 응답
 * 템플릿 등록 후 파일을 templates 폴더 안에 두면 확장자 없이 파일명만 적으면 자동으로 찾아감
 * */

/**
 * JSP 사용법
 * <%@ %> : import 문
 * <% %> : 자바 코드 영역
 * <%= %> : 변수 값 출력
 * ${} : model에서 값 가져오기
 * */

/**
 * redirect 사용법
 * @Controller 에서 return redirect: 키워드 이용
 * */
@Controller
public class ViewControllerTest {

	@GetMapping("/auth/signup")
	public String signupPage() {
		return "auth/signup";
	}
	
	@GetMapping("/auth/signin")
	public String signinPage() {
		return "auth/signin";
	}
	
	@GetMapping("/image/story")
	public String storyPage() {
		return "image/story";
	}
	
	@GetMapping("/image/popular")
	public String popularPage() {
		return "image/popular";
	}
	
	@GetMapping("/image/upload")
	public String uploadPage() {
		return "image/upload";
	}
	
	@GetMapping("/user/profile")
	public String profilePage() {
		return "user/profile";
	}

	@GetMapping("/user/update")
	public String updatePage() {
		return "user/update";
	}
}
