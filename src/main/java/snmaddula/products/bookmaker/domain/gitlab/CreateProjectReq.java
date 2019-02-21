package snmaddula.products.bookmaker.domain.gitlab;

import java.util.List;

import lombok.Data;

@Data
public class CreateProjectReq {

	private String projectName;
	private List<String> roles;
	private String gitUri;
}
