package at.edu.c02.calculator.logic.operations;

import at.edu.c02.calculator.CalculatorException;
import at.edu.c02.calculator.MathOperation;

public class Div implements MathOperation {

	@Override
	public double calculate(double a, double b) throws CalculatorException {
		
		double c = a/b;
		if (Double.isInfinite(c))
			throw new CalculatorException("Division by zero");
		return c;
	}

}
