package snmaddula.products.bookmaker.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AppResponse {

	private String errorMsg;
	private Object data;
	private Boolean error;
	
	public AppResponse(Object data) {
		this.data = data;
	}
	
}
