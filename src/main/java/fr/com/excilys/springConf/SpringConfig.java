package fr.com.excilys.springConf;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(value= {"fr.com.excilys.dto","fr.com.excilys.modele","fr.com.excilys.service","fr.com.excilys.sevlet","fr.com.excilys.validator","fr.com.excilys.persistence"})
public class SpringConfig {
	
}
