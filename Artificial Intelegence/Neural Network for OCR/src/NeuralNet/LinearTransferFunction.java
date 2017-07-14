package NeuralNet;

public class LinearTransferFunction implements TransferFunction{

	public double evaluate(double x) {
		return x;
	}

	public double evaluateDerivitive(double x) {
		return 1.0;
	}

	
}
