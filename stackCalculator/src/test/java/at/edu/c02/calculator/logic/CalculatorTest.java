package at.edu.c02.calculator.logic;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import at.edu.c02.calculator.ICalculator;
import at.edu.c02.calculator.CalculatorException;
import at.edu.c02.calculator.OperationFactory;
import at.edu.c02.calculator.ICalculator.Operation;
import at.edu.c02.calculator.logic.CalculatorImpl;
import at.edu.c02.calculator.logic.operations.Add;
import at.edu.c02.calculator.logic.operations.DefaultOperationFactory;

public class CalculatorTest {

	@Test
	public void testSimpleAddOperation() throws Exception {

		// setup
		ICalculator calc = new CalculatorImpl(new DefaultOperationFactory());

		// execute
		calc.push(2.0);
		calc.push(3);
		double result = calc.calc(Operation.add);

		// verify
		assertEquals(5, result, 0);

	}

	@Test
	public void testSimpleMulOperation() throws Exception {

		ICalculator calc = new CalculatorImpl(new DefaultOperationFactory());
		calc.push(2.0);
		calc.push(3);
		double result = calc.calc(Operation.mul);

		assertEquals(6, result, 0);

	}

	@Test
	public void testSimpleDivOperation() throws Exception {

		ICalculator calc = new CalculatorImpl(new DefaultOperationFactory());
		calc.push(6.0);
		calc.push(2);
		double result = calc.calc(Operation.div);

		assertEquals(3, result, 0);

	}

	//
	@Test(expected = CalculatorException.class)
	public void testPopOnEmptyStack() throws Exception {

		ICalculator calc = new CalculatorImpl(new DefaultOperationFactory());
		calc.pop();

	}

	@Test
	public void testDivisionByZero() throws Exception {

		// Setup
		ICalculator calc = new CalculatorImpl(new DefaultOperationFactory());
		try {
			calc.push(2);
			calc.push(0);
			calc.calc(Operation.div);

			fail("Exception expected");

		} catch (CalculatorException e) {
			assertEquals("Division by zero", e.getMessage());
			// e.getCause()
		}
	}

	@Test
	public void testMockFactory() throws CalculatorException {
		
		// Setup
		OperationFactory operationFactory = Mockito.mock(OperationFactory.class);

		//Factory simulieren
		Mockito.when(operationFactory.getOperation(Operation.add)).thenReturn(new Add());

		ICalculator calc = new CalculatorImpl(operationFactory);

		// execute
		calc.push(2.0);
		calc.push(3);
		double result = calc.calc(Operation.add);

		// verify
		assertEquals(5, result, 0);

	}

}
