package spring.soap.https.client.certificate.authentication.consumer;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.TrustManagerFactory;

import org.apache.cxf.configuration.jsse.TLSClientParameters;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.transport.http.HTTPConduit;

import com.example.temperatureservice.GetCelsiusRequest;
import com.example.temperatureservice.GetCelsiusResponse;
import com.example.temperatureservice.TempPort;
import com.example.temperatureservice.TempPortService;

import spring.soap.https.client.certificate.authentication.consumer.config.SpringSoapClientConfig;

public class SpringSoapClient {

	public static void main(String[] args) {
		SpringSoapClient soapClient = new SpringSoapClient();
		TempPortService tempPortService = new TempPortService();
		TempPort tempPort = tempPortService.getTempPortSoap11();
		soapClient.authenticateClient(tempPort);
		GetCelsiusRequest celsiusRequest = new GetCelsiusRequest();
		celsiusRequest.setCelcius(45);
		GetCelsiusResponse response = tempPort.getCelsius(celsiusRequest);
		System.out.println("The fahrenheit temperature " + response.getFahrenheit());
	}

	private void authenticateClient(TempPort tempPort) {
		Client client = ClientProxy.getClient(tempPort);
		HTTPConduit httpConduit = (HTTPConduit) client.getConduit();
		SpringSoapClientConfig soapClientConfig = new SpringSoapClientConfig();
		KeyManagerFactory keyManagerFactory = soapClientConfig.getKeyManagerFactory();
		TrustManagerFactory trustManagerFactory = soapClientConfig.getTrustManagerFactory();
		TLSClientParameters tslClientParameters = httpConduit.getTlsClientParameters();
		if (tslClientParameters == null) {
			tslClientParameters = new TLSClientParameters();
		}
		tslClientParameters.setTrustManagers(trustManagerFactory.getTrustManagers());
		tslClientParameters.setKeyManagers(keyManagerFactory.getKeyManagers());
		tslClientParameters.setDisableCNCheck(true);
		httpConduit.setTlsClientParameters(tslClientParameters);
	}

}
