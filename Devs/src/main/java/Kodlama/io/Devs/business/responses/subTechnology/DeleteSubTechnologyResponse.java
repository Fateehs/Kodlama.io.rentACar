package Kodlama.io.Devs.business.responses.subTechnology;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeleteSubTechnologyResponse {
	private int id;
	private int programmingLanguageId;
	private String name;
}
