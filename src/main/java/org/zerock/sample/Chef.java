package org.zerock.sample;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component //스프링이 의존성 처리해줘
@Data
public class Chef {

	private String name;
	private int age;
}
