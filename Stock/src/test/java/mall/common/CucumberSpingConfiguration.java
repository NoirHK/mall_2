package mall.common;


import mall.StockApplication;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = { StockApplication.class })
public class CucumberSpingConfiguration {
    
}
