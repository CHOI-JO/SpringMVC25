package org.zero.sample;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.sample.Restaurant;

import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@RunWith(SpringJUnit4ClassRunner.class) // 메서드 단위로 테스트용 코드
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j2 // log4j가 취약해서 log4j2로 교체
public class SampleTests {

		@Setter(onMethod_ = @Autowired)
		private Restaurant restaurant; //필드선언
		
		@Test //메서드별로 테스트가 가능하다.
		public void testExist() {
			//테스트용 메서드
			
			assertNotNull(restaurant); // 객체가 null인지를 판단. null이 아니어야만 테스트가 성공
			
			log.info(restaurant); //toString가능
			log.info("-----------------------------");
			log.info(restaurant.getChef()); //레스토랑 객체에서 쉐프를 요청함
		}
}
