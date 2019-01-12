package at.edu.c02.calculator.logic.operations;

import at.edu.c02.calculator.CalculatorException;
import at.edu.c02.calculator.MathOperation;

public class Sub implements MathOperation {

	@Override
	public double calculate(double a, double b) throws CalculatorException {
		
		return a - b;
	}

}
