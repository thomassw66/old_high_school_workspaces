package NeuralNet;

public class GausianTransferFunction implements TransferFunction{

	public double evaluate(double x) {
		return Math.exp(-Math.pow(x,2.0));
	}
	public double evaluateDerivitive(double x) {
		return -2.0 * x * evaluate(x);
	}

}
