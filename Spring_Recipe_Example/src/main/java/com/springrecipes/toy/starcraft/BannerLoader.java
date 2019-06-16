package com.springrecipes.toy.starcraft;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.annotation.PostConstruct;

import org.springframework.core.io.Resource;

public class BannerLoader {
	
	// Banner 필드를 스프링 Resource형으로 선언, 빈 인스턴스 생성 시 아래 세터 주입에 사용
	private Resource banner;
	
	public void setBanner(Resource banner) {
		this.banner = banner;
	}
	
	// @PostConsturct : IoC 컨테이너 구성 시점에 빈 생성 후 자동 실행
	@PostConstruct
	// 파일의 내용을 차례로 콘솔에 한줄씩 출력
	public void showBanner() throws IOException {
		Files.lines(Paths.get(banner.getURI()), Charset.forName("UTF-8")).forEachOrdered(System.out::println);
	}

}
