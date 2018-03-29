package com.beiyan.validate;

import com.beiyan.validate.service.PersonService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MethodValidtorTest {

	@Autowired
	private PersonService personService;
	@Test
	public void testMethodValidtor() {
		personService.createPerson(null,18);
	}

}
