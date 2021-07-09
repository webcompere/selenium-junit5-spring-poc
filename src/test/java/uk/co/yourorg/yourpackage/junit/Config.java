package uk.co.yourorg.yourpackage.junit;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "uk.co.yourorg.yourpackage")
public class Config {
}
