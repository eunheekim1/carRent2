package carrent.common;

import carrent.CarMgmtApplication;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = { CarMgmtApplication.class })
public class CucumberSpingConfiguration {}
