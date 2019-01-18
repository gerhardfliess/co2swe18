package at.edu.c02.calculator.parser;

import java.io.File;
import java.io.FileNotFoundException;
import static org.mockito.Mockito.*;
import org.mockito.Mockito;
import org.junit.Test;

import at.edu.c02.calculator.ICalculator;
import at.edu.c02.calculator.ICalculator.Operation;

public class ParserTest {

	@Test(expected = IllegalArgumentException.class)
	public void testNullParser() {
		new Parser(null);
	}

	@Test(expected = FileNotFoundException.class)
	public void testParserInvalidFile() throws Exception {

		ICalculator cal = Mockito.mock(ICalculator.class);

		Parser parser = new Parser(cal);
		parser.parse(new File("invalid"));
	}

	@Test
	public void testParserTest01Xml() throws Exception {

		ICalculator cal = mock(ICalculator.class);

		Parser parser = new Parser(cal);
		parser.parse(new File("src/test/resources/test01.xml"));

		Mockito.verify(cal).push(1.0);
		verify(cal).push(2.0);
		verify(cal).calc(Operation.add);

		verifyNoMoreInteractions(cal);
	}

	@Test
	public void testParserTest02Xml() throws Exception {

		ICalculator cal = mock(ICalculator.class);

		Parser parser = new Parser(cal);
		parser.parse(new File("src/test/resources/test01.xml"));

		Mockito.verify(cal).push(1.0);
		verify(cal).push(2.0);
		verify(cal).calc(Operation.add);

		verifyNoMoreInteractions(cal);
	}

	@Test
	public void testParserTest04Xml() throws Exception {

		ICalculator cal = mock(ICalculator.class);

		Parser parser = new Parser(cal);
		parser.parse(new File("src/test/resources/test04.xml"));

		Mockito.verify(cal).push(11.0);
		verify(cal).push(5.0);
		verify(cal).calc(Operation.mod);

		verifyNoMoreInteractions(cal);
	}

}
