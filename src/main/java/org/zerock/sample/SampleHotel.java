package org.zerock.sample;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@Component
@ToString
@Getter
@AllArgsConstructor
public class SampleHotel {
	//묵시적 자동 주입 :
	// 스프링의 의존성 주입은 생성자 주입과 세터 주입을 자주 사용한다. 
	// 생성자 주입은 롬북이 알아서 파라미터를 만들어중
	// 생성자 주입의 경우, 객체 생성 시 의존성 주입이 필요하므로 좀 더 엄격하게 의존성 주입을 체크함
	// 세터 주입은 값을 저장시 자동 객체를 생성해줌
	
	@NonNull
	private Chef chef; //필드
	
	private Restaurant restaurant;
	
	private String name;
}
