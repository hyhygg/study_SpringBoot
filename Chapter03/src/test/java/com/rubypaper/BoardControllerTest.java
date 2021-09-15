package com.rubypaper;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.rubypaper.domain.BoardVO;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class BoardControllerTest {
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	public void testHello() throws Exception {
		String result = restTemplate.getForObject("/hello?name=둘리", String.class);
		assertEquals("Hello : 둘리", result);
	}
	
	@Test
	public void testGetBoard() throws Exception {
		BoardVO board = restTemplate.getForObject("/getBoard", BoardVO.class);
		assertEquals("테스터", board.getWriter());
	}
}
