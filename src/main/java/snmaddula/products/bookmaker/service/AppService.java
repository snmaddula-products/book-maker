package snmaddula.products.bookmaker.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import snmaddula.products.bookmaker.domain.gitlab.Project;
import snmaddula.products.bookmaker.dto.AppResponse;

@Service
@RequiredArgsConstructor
public class AppService {

	private final GitlabProxyService gitProxyService;

	private static final String ROLE_STRING = " - name: _ROLE_NAME_\n   src: _ROLE_SRC_\n   scm: git\n\n";
	
	private Map<String, String> roleMap;
	
	@PostConstruct
	public void init() {
		roleMap = new HashMap<>();
	}
	
	public void process() {
		List<Project> roles = gitProxyService.fetchRoleRepos();
		roles.forEach(role -> {
			roleMap.putIfAbsent(role.getName(), role.getHttpUrl());
		});
		
		roles.forEach(System.out::println);
	}

	public AppResponse getAllRoleNames() {
		List<String> roleNames = gitProxyService.fetchRoleRepos()
				.stream().map(Project::getName).sorted().collect(Collectors.toList());
		return new AppResponse(roleNames);
	}
	
	public String generateRequirementsYml(List<String> roles) {
		StringBuilder b = new StringBuilder("---\n");
		roles.forEach(role -> {
			b.append(ROLE_STRING.replace("_ROLE_NAME_", role).replace("_ROLE_SRC_", roleMap.get(role)));
		});
		return b.toString();
	}
}
