package sample;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import org.junit.Test;

public class CaluculatorTest {

	@Test
	public void maltiplationで5と2の乗算結果が取得できる()throws Exception{
		Calculator c = new Calculator();
		int expected = 10;
		int actual = c.maltiplication(5, 2);
		assertThat(actual, is(expected));
	}

	@Test
	public void divisionで5と8の除算結果が取得できる()throws Exception{
		Calculator c = new Calculator();
		float expected = 0.625f;
		float actual = c.division(5, 8);
		assertThat(actual, is(expected));
	}
}
