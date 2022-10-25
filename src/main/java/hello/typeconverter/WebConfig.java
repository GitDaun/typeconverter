package hello.typeconverter;

import hello.typeconverter.converter.IpPortToStringConverter;
import hello.typeconverter.converter.StringToIntegerConverter;
import hello.typeconverter.converter.StringToIpPortConverter;
import hello.typeconverter.formatter.MyNumberFormatter;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

  @Override
  public void addFormatters(FormatterRegistry registry) {
    /**MyNumberFormatter는 문자 <-> 숫자로 바꿔주는 역할인데 위 두 컨버터도 같은 역할
     * 우선순위와 중복 이슈로 주석 처리함.*/
/*    registry.addConverter(new StringToIntegerConverter());
    registry.addConverter(new StringToIntegerConverter());*/
    registry.addConverter(new StringToIpPortConverter());
    registry.addConverter(new IpPortToStringConverter());

    registry.addFormatter(new MyNumberFormatter());
  }
}
