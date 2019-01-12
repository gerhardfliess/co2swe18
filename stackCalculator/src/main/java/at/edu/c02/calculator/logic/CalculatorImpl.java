package at.edu.c02.calculator.logic;

import java.util.Stack;

import at.edu.c02.calculator.Calculator;
import at.edu.c02.calculator.CalculatorException;
import at.edu.c02.calculator.MathOperation;
import at.edu.c02.calculator.OperationFactory;
import at.edu.c02.calculator.logic.operations.DefaultOperationFactory;

public class CalculatorImpl implements Calculator {

	private Stack<Double> stack_ = new Stack<Double>();

	private OperationFactory factory;

	public CalculatorImpl(OperationFactory factory) {
		this.factory = factory;
	}

	@Override
	public double perform(Operation op) throws CalculatorException {

		double b = pop();
		double a = pop();

		MathOperation mathOperation = factory.getOperation(op);

		if (mathOperation == null)
			throw new CalculatorException("Invalid operation");

		return mathOperation.calculate(a, b);
	}

	@Override
	public double pop() throws CalculatorException {
		if (stack_.isEmpty())
			throw new CalculatorException();
		return stack_.pop();
	}

	@Override
	public void push(double v) {
		stack_.push(v);
	}

	@Override
	public void clear() {
		stack_.clear();
	}

}
