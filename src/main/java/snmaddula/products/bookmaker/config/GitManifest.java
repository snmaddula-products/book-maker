package snmaddula.products.bookmaker.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import lombok.Setter;

@Setter
@Configuration
@ConfigurationProperties("gitlab")
public class GitManifest {

	private String privateToken;
	private String baseUrl;
	private String rolesUri;
	
	public UriComponents fetchRoles() {
		return UriComponentsBuilder.fromHttpUrl(baseUrl).path(rolesUri).build();
	}
	
	public HttpHeaders tokenHeaders() {
		return new HttpHeaders() {{
			add("PRIVATE-TOKEN", privateToken);
		}};
	}
}
