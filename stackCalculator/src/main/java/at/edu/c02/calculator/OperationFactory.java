package at.edu.c02.calculator;

public interface OperationFactory {
	public MathOperation getOperation(Calculator.Operation op);
}