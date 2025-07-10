package org.zerock.controller;

import java.util.ArrayList;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zerock.domain.SampleDTO;
import org.zerock.domain.SampleDTOList;
import org.zerock.domain.TodoDTO;

import lombok.extern.log4j.Log4j2;

@Controller
@RequestMapping("/sample/*")
@Log4j2 //resources 폴더에 log4j2.xml 필수
public class SampleController {

	@RequestMapping("")
	public void bassic() {
		
		log.info("SampleController.basic() 메서드 실행................");
		log.info("리턴이 void이기 때문에 basic.jsp 파일을 찾습니다.");
		log.info("현재 /web-inf/view/basic.jsp가 없음으로 크롬에는 오류가 납니다.");
	}
	
	@RequestMapping(value = "/basic", method= {RequestMethod.GET,RequestMethod.POST})
	public void basicGet() {
		log.info("SampleController.basicGet() 메서드 실행................");
		log.info("get방식과 post방식 둘 다 반응한다");
	}
	
	@GetMapping("/basicOnlyGet")
	public void basicGet2() {
		log.info("SampleController.basicGet2() 메서드 실행................");
		log.info("get방식에 반응한다");
	}
	
	@PostMapping("/basicOnlyPost")
	public void basicPoat2() {
		log.info("SampleController.basicPoat2() 메서드 실행................");
		log.info("post방식에 반응한다");
	}
	
	public String ex01(SampleDTO dto) {
		log.info("SampleController.ex01() 메서드 실행................");
		log.info("get방식에 반응한다");
		log.info("입력 dto 확인: " +dto);

		return "ex01";
	}
	
	@GetMapping("/ex02")
	public String ex02(@RequestParam("name") String name, @RequestParam("age") int age) {
		log.info("name:" + name);
		log.info("age:" +age);
		
		return "ex02";
	}
	
	@GetMapping("/ex02List")
	public String ex02List(@RequestParam("ids") ArrayList<String> ids) {
		log.info("리스트로 넘어온 데이터 처리:" + ids);
		log.info("리스트 2번째 값 확인:" + ids.get(1));
		
		return "ex02List";
	}
	
	@GetMapping("/ex02Bean")
	public String ex02Bean(SampleDTOList list) {
		log.info("list sampleDTOs:" + list);
		
		return "ex02Bean";
	}
	
	@GetMapping("/ex03")
	public String ex03(TodoDTO todo) {
		log.info("todo:" + todo);
		
		return "ex03";
	}
	
	@GetMapping("/ex04")
	public String ex04(SampleDTO dto, @ModelAttribute("page") int page) {
		log.info("dto:" + dto);
		log.info("page:" + page);

		return "/sample/ex04";
	}
	
	@GetMapping("/ex05")
	public String ex05() {
		log.info("/ex05.........................:");
		return "ex05";
	}
	
	@GetMapping("/ex06")
	public @ResponseBody SampleDTO ex06() {
		log.info("/ex06.........................:");
		SampleDTO dto = new SampleDTO();
		dto.setAge(10);
		dto.setName("홍길동");
		return dto;
	}
	
	@GetMapping("/ex07")
	public ResponseEntity<String> ex07() {
		log.info("/ex07.........................:");
		String msg="{\"name\":\"홍길동\"}";
		
		HttpHeaders header = new HttpHeaders();
		header.add("Content-Type", "application/json;charset=UTF-8");
		return new ResponseEntity<>(msg, header, HttpStatus.OK);
	}
}
