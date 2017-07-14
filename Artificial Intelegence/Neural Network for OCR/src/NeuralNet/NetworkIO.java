package NeuralNet;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class NetworkIO {
	
	public static void saveNetworkToFile(NeuralNetwork n, String path, String fileName){
		saveNetworkToFile(n,makePath(path,fileName));
	}

	public static void saveNetworkToFile(NeuralNetwork n, String pathAndFileName){
		try {
		
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(pathAndFileName));
			out.writeObject(n);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	private static String makePath(String path, String filename){
		if(!path.endsWith("\\"))
			path+="\\";
		return path + filename;
	}
}
