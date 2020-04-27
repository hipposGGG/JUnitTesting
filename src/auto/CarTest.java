package auto;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

public class CarTest {
	private final ByteArrayOutputStream outCon = new ByteArrayOutputStream();

	@Before
	public void setUpStreams() {
		System.setOut(new PrintStream(outCon));
	}

	@After
	public void cleanUpStreams() {
		System.setOut(System.out);
	}

	@BeforeEach
	public void 前処理() {
		Car c = new Car();
	}

	@Test
	public void oilingtest01() {
		Car c = new Car();

		//　値をセット
		c.carName = "テスト車";

		//　oiling()メソッドを実行
		c.oiling();

		//　期待値を設定
		final String expected = "テスト車は、ガソリンスタンドで給油した"+ System.lineSeparator();

		//　実際の値を取得
		final String actual = outCon.toString();

		//assertEqualsで判定
		assertEquals(expected, actual);

	}

	@Test
	public void distanceTest01() {

		Car c = new Car();
		StringBuilder sb = new StringBuilder();
		//　改行
		String ln = System.lineSeparator();

		//　値をセット
		int km = 100;
		c.fuel = 60;
		//　distance()メソッドを実行
		c.distance(km);

		//　期待値を設定
		sb.append("100km走って10Lのガソリンを消費した");
		sb.append(ln);
		sb.append("残りの燃料は50Lです。");
		sb.append(ln);
		final String expected = sb.toString();

		//　実際の値を取得
		final String actual = outCon.toString();

		//　assertThatで判定
		assertThat(actual, is(expected));


	}

	@Test
	public void 料金計算01() {
		Car c = new Car();

		int km = 10;
		int result = c.calc(km);

		assertEquals(2,result);

	}

	@Test
	public void 料金計算02() {
		Car c = new Car();

		int km = 18;
		int result = c.calc(km);

		assertEquals(3,result);

		final String actual = outCon.toString();
		String aa = "かなりの距離を走行してます";
		assertThat(actual, is(aa));

	}

	@Test
	public void 料金計算03() {
		Car c = new Car();

		int km = 18;
		c.distanceHigh(km);


		final String actual = outCon.toString();
		String aa = "かなりの距離を走行してます\r\n";
		assertThat(actual, is(aa));

	}



}
