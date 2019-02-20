package snmaddula.products.bookmaker;

import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

import javax.net.ssl.SSLContext;

import org.apache.http.client.HttpClient;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustAllStrategy;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContexts;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppContext {

	@Bean
	public RestTemplate rt() throws KeyManagementException, NoSuchAlgorithmException, KeyStoreException {
		return new RestTemplate(clientHttpRequestFactory());
	}

	private static ClientHttpRequestFactory clientHttpRequestFactory()
			throws KeyManagementException, NoSuchAlgorithmException, KeyStoreException {
		final SSLContext sslContext = SSLContexts.custom().loadTrustMaterial(null, TrustAllStrategy.INSTANCE).build();
		final HttpClient httpClient = HttpClients.custom().setSSLSocketFactory(new SSLConnectionSocketFactory(sslContext)).build();
		return new HttpComponentsClientHttpRequestFactory() {{
			setHttpClient(httpClient);
		}};
	}
}
