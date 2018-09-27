package personal.learn.aditya.operations;

import java.io.IOException;

import personal.learn.aditya.box.BoxClient;
import personal.learn.aditya.constants.DataConstants;

public class ProviderFactory {
	
	public static SupportedOperations getInstance(String providerName) throws IOException {
		if (DataConstants.BOX.equals(providerName)) {
			return new BoxClient();
		}
		return null;
	}


}
