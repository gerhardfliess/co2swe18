package at.edu.c02.calculator;


public interface ICalculator {

	public enum Operation {
		add, sub, mul, div,mod
	};

	void push(double value);
	
	double pop() throws CalculatorException;
	
	double calc(Operation op) throws CalculatorException;
	
	void clear(); 
}
