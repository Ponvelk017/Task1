package util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import inputcheck.InvalidInputException;
import task.StringTask;

class TestExample {

	@Test
	public void test() {
		StringTask obj = new StringTask();
		try {
			Assertions.assertEquals(2, obj.findLength("hi"));
		} catch (InvalidInputException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
