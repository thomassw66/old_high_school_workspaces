package NeuralNet;

public class RationalTransferFunction implements TransferFunction{

	public double evaluate(double x) {
		return x / (1 + Math.sqrt(1 + x * x));
	}

	public double evaluateDerivitive(double x) {
		double d = 1.0 + Math.sqrt(1 + x * x);
		return 1.0 / (d * (1 + d)) ;
	}
}
