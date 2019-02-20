package snmaddula.products.bookmaker.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import snmaddula.products.bookmaker.domain.gitlab.Project;

@Service
@RequiredArgsConstructor
public class AppService {

	private final GitlabProxyService gitProxyService;

	public void process() {
		List<Project> roles = gitProxyService.fetchRoleRepos();
		roles.forEach(System.out::println);
	}
}
