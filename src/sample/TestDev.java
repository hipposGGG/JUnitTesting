package sample;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import org.junit.Test;

public class TestDev {

	@Test
	public void Helloと言う() {
		JunitDev jd = new JunitDev();
		assertThat(jd.sayHello(), is("hello!"));
	}
}
