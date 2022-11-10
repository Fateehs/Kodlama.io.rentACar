package Kodlama.io.Devs.business.abstracts;

import java.util.List;

import Kodlama.io.Devs.business.requests.programmingLanguage.CreateProgrammingLanguageRequest;
import Kodlama.io.Devs.business.requests.programmingLanguage.DeleteProgrammingLanguageRequest;
import Kodlama.io.Devs.business.requests.programmingLanguage.UpdateProgrammingLanguageRequest;
import Kodlama.io.Devs.business.responses.programmingLanguage.GetAllProgrammingLanguagesResponse;
import Kodlama.io.Devs.business.responses.programmingLanguage.GetByIdProgrammingLanguageResponse;
import Kodlama.io.Devs.business.responses.programmingLanguage.GetByNameProgrammingLanguageResponse;

public interface ProgrammingLanguageService {
	
	// * * * CURD OPERATIONS * * *
	
	void add(CreateProgrammingLanguageRequest createProgrammingLanguageRequest) throws Exception;
	void update(UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest) throws Exception;
	void delete(DeleteProgrammingLanguageRequest deleteProgrammingLanguageRequest);
	
	// * * * GET METHODS * * *
	
	List<GetAllProgrammingLanguagesResponse> getAll();
	GetByIdProgrammingLanguageResponse getById(int id);
	GetByNameProgrammingLanguageResponse getByName(String name);
}
