package NeuralNet;

public class SigmoidTransferFunction implements TransferFunction{

	public double evaluate(double x) {
		return 1.0/(1 + Math.exp(-x));
	}

	public double evaluateDerivitive(double x) {
		double out = evaluate(x);
		return out*(1-out);
	}

}
