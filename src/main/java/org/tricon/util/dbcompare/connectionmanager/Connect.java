package org.tricon.util.dbcompare.connectionmanager;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.tricon.util.dbcompare.Util;;

@Service
public class Connect {

	private final Logger					_LOGGER	= LoggerFactory.getLogger(Connect.class);
	
	//@Bean
	//@Primary
	public DataSource getDataSource(String url,String db_provider,String username, String pwd) {
		_LOGGER.debug("Inside method getDataSource. Getting DadaSource for provider: {}",db_provider);
		
		String driverClassName=Util.getDriverClassName(db_provider);
		
	    return DataSourceBuilder
	        .create()
	        .username(username)
	        .password(pwd)
	        .url(url)
	        .driverClassName(driverClassName)
	        .build();
	}
	
	
}
