package board.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = {"board.dao", "board.service"})
@Import({DBConfig.class})
public class ApplicationConfig {

}
