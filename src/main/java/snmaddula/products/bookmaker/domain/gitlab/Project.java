package snmaddula.products.bookmaker.domain.gitlab;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(value = Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Project {

	private Long id;// 10302957,
	private String description;
	private String name; // "ValidateWinFeature",
	@JsonProperty("default_branch")
	private String branch; // "default_branch": "master",
	@JsonProperty("http_url_to_repo")
	private String httpUrl; // "https://gitlab.com/Pod1Todo/validatewinfeature.git",
	@JsonProperty("ssh_url_to_repo")
	private String sshUrl; // "git@gitlab.com:Pod1Todo/validatewinfeature.git",
}
