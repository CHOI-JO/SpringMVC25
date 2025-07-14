package org.zerock.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.zerock.domain.BoardVO;
import org.zerock.mapper.BoardMapperTests;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j2
public class BoardServiceTests {

	@Setter(onMethod_ = @Autowired)
	private BoardService service; 
	
	@Test
	public void testExist() {
		log.info("==================");
		log.info(service); 
		assertNotNull(service); 
		log.info("=================="); 
	}
	
	@Test
	public void testRegister() {
		BoardVO board = new BoardVO();
		board.setTitle("서비스에서 새로 작성하는 글");
		board.setContent("서비스에서 새로 작성하는 내용");
		board.setWriter("최장옥");
		
		service.register(board);
		
		log.info("======================");
		log.info("생성된 게시물의 번호 : " + board.getBno());
		log.info("======================");
	}
	
	@Test
	public void testGetList() {
		log.info("======================");
		service.getList().forEach(board -> log.info(board));
		log.info("======================");
	}
	
	@Test
	public void testGet() {
		log.info(service.get(1L));
	}
	
	@Test
	public void testDelete() {
		log.info("REMOVE RESULT : " + service.remove(1L));
	}
	
	@Test
	public void testUpdate() {
		BoardVO board = service.get(1L);
		
		if(board == null) {
			return;
		}
		
		board.setTitle("서비스에서 제목을 수정합니다.");
		log.info("MODIFY RESULT: " + service.modify(board));
	}
}


