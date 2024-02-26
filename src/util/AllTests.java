package util;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@SelectClasses({ TestExample.class })

public class AllTests {
	public void testCases() {
		TestExample obj = new TestExample();
		obj.test();
	}
}
