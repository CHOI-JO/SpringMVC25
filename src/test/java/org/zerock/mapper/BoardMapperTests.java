package org.zerock.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.zerock.domain.BoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j2
public class BoardMapperTests {
	
	@Setter(onMethod_ = @Autowired)
	private BoardMapper mapper;  
	
	@Test 
	public void testGetList() {
		mapper.getList().forEach(board -> log.info(board) );
	}
	
	@Test 
	public void testGetListXML() {
		mapper.getList2().forEach(board -> log.info(board) );
	}
	
	
	@Test
	public void testInsert() {
		BoardVO board = new BoardVO(); 
		board.setTitle("새로 작성하는 글");
		board.setContent("새로 작성하는 내용");
		board.setWriter("최장옥");
		mapper.insert(board);
		log.info(board);
	}

	
	@Test
	public void testInsertSelectKey() {
		BoardVO board = new BoardVO();
		board.setTitle("새로 작성하는 글 select key");
		board.setContent("새로 작성하는 내용 select key");
		board.setWriter("최장옥");
		
		mapper.insertSelectKey(board);
		
		log.info(board);
	}
	
	@Test
	public void testRead() {
		BoardVO board = mapper.read(5L); 
		log.info(board);
	}
	
	@Test
	public void testDelete() {
		int count = mapper.delete(3L);
		log.info("삭제된 갯수 출력 : " + count + "건");
	}
	
	
	@Test
	public void testUpdate() {
		BoardVO board = new BoardVO();
		board.setBno(5L);
		board.setTitle("수정된 제목");
		board.setContent("수정된 내용");
		board.setWriter("최장옥");
		
		int count = mapper.update(board);
		log.info("UPDATE COUNT: " + count);
		log.info("수정된 객체 출력 :" + board);
		
	}
}
