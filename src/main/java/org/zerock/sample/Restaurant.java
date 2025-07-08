package org.zerock.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Setter;

@Component //스프링이 의존성 처리해줘
@Data
public class Restaurant {
	@Setter(onMethod_ = @Autowired)
	private Chef chef;
}
