package com.springrecipes.toy.starcraft.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.Resource;

import com.springrecipes.toy.starcraft.BannerLoader;
import com.springrecipes.toy.starcraft.Marine;
import com.springrecipes.toy.starcraft.SCV;
import com.springrecipes.toy.starcraft.Tank;

@Configuration
// Properties 파일을 로드하기 위한 파일명 선언
@PropertySource("classpath:starcraft.properties")
@ComponentScan(	// 현재 Configuration 클래스 뿐만아니라 아래 includeFilter에 설정해둔 클래스도 스캔
	includeFilters = {
		@ComponentScan.Filter (
			type = FilterType.REGEX,
			pattern = {"com.springrecipes.toy.starcraft.*DaoImpl",
					   "com.springrecipes.toy.starcraft.*Dao",
					   "com.springrecipes.toy.starcraft.*Service",
					   "com.springrecipes.toy.starcraft"
			}
		)
	}
)
public class StarcraftConfiguration {
	
	// Properties 파일의 값을 사용하기 위한 변수 선언 및 값이 없는 경우를 대비한 Default 값 선언
	@Value("${unit.scv.generationTime:10}")
	private int scvGenerationTime;
	
	@Value("${unit.marine.generationTime:10}")
	private int marineGenerationTime;
	
	@Value("${unit.tank.generationTime:10}")
	private int tankGenerationTime;
	
	// banner 텍스트를 출력하기 위한 필드 선언 및 클래스패스 셋팅
	@Value("classpath:banner.txt")
	private Resource banner;
	
	// Properties 파일을 사용하기 위한 Bean 생성
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceHolderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}
	
	// banner를 콘솔에 출력하기 위한 banner 출력용 클래스를 빈으로 생성 
	@Bean
	public BannerLoader bannerloader() {
		BannerLoader bl = new BannerLoader();
		bl.setBanner(banner);
		return bl;
	}
	
	// 별도로 Scope를 지정하지 않으면 스프링 빈은 기본 Scope를 Singleton로 설정  
	@Bean
	public SCV scv() {
		SCV scv = new SCV(scvGenerationTime);
		return scv;
	}
	
	// Scope를 prototype으로 지정할 경우, Bean 생성 시 매번 새로 생성
	@Bean
	@Scope("prototype")
	public Marine marine() {
		Marine marine = new Marine(marineGenerationTime);
		return marine;
	}
	
	// Scope를 prototype으로 지정할 경우, Bean 생성 시 매번 새로 생성
	@Bean
	@Scope("prototype")
	public Tank tank() {
		Tank tank = new Tank(tankGenerationTime);
		return tank;
	}
	
}
