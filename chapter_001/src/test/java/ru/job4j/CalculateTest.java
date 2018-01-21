package ru.job4j;

import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test for class Calculate
 * @author Vitaly Zamylin
 * @version 1
 * @since 22.01.2018
*/
public class CalculateTest {
	
	/**
	 * Test echo
	*/
	@Test
	public void whenTakeNameThenThreeEchoPlusName() {
		String input = "Vitaly Zamylin";
		String expect = "Echo, echo, echo : Vitaly Zamylin";
		Calculate calc = new Calculate();
		String result = calc.echo(input);
		assertThat(result, is(expect));
	}
}