package snmaddula.products.bookmaker.service;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.RequiredArgsConstructor;
import snmaddula.products.bookmaker.config.GitManifest;
import snmaddula.products.bookmaker.domain.gitlab.Project;

@Service
@RequiredArgsConstructor
public class GitlabProxyService {

	private final GitManifest gitManifest;
	private final RestTemplate rt;
	
	public List<Project> fetchRoleRepos() {
		return rt.exchange(gitManifest.fetchRoles().toUri(), HttpMethod.GET, new HttpEntity(gitManifest.tokenHeaders()), 
				new ParameterizedTypeReference<List<Project>>() {}).getBody();
	}
}
