package Kodlama.io.Devs.business.requests.subTechnology;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateSubTechnologyRequest {
	private int programmingLanguageId;
	private String name;
}
