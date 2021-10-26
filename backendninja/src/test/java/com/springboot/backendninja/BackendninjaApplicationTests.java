package com.springboot.backendninja;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.springboot.backendninja.repository.QueryDSLExampleRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BackendninjaApplicationTests {
    
	@Resource
	private QueryDSLExampleRepository queryDsl;
	
	@Test
	public void contextLoads() {
		
		queryDsl.queryLan();
	}

	
}
