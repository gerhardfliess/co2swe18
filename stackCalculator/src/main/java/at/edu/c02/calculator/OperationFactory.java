package at.edu.c02.calculator;

public interface OperationFactory {
	public MathOperation getOperation(ICalculator.Operation op);
}