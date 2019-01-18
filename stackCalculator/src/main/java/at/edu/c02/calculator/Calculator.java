package at.edu.c02.calculator;


public interface Calculator {

	public enum Operation {
		add, sub, mul, div,mod
	};

	void push(double value);
	
	double pop() throws CalculatorException;
	
	double perform(Operation op) throws CalculatorException;
	
	void clear(); 
}
