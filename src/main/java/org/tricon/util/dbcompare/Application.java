package org.tricon.util.dbcompare;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements InitializingBean{

	private final Logger					_LOGGER	= LoggerFactory.getLogger(Application.class);

	
	
  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

@Override
public void afterPropertiesSet() throws Exception {
	_LOGGER.info("initializing beans");
	
	
}

}
