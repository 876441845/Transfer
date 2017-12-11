package com.cnty.test;

import com.cnty.test.client.TransferClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TransferApplicationTests {

	@Test
	public void contextLoads() {
        TransferClient client = new TransferClient("localhost", 10010);
        client.init();
	}

}
