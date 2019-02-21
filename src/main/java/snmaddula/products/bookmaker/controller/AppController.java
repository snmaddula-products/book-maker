package snmaddula.products.bookmaker.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import snmaddula.products.bookmaker.domain.gitlab.CreateProjectReq;
import snmaddula.products.bookmaker.dto.AppResponse;
import snmaddula.products.bookmaker.service.AppService;

@RestController
@RequiredArgsConstructor
public class AppController {

	private final AppService appService;
	
	@GetMapping("/roles")
	public AppResponse getAllRoleNames() {
		return appService.getAllRoleNames();
	}
	
	@PostMapping(value = "/create", produces = MediaType.TEXT_PLAIN_VALUE)
	public String getRequirementsYml(@RequestBody CreateProjectReq createProjectReq) {
		System.out.println("Project Name: " + createProjectReq.getProjectName());
		System.out.println("Git Uri: " + createProjectReq.getGitUri());
		System.out.println(appService.generateRequirementsYml(createProjectReq.getRoles()));
		return "";
	}
}
