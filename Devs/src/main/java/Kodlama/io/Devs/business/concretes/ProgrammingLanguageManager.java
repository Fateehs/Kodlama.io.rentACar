package Kodlama.io.Devs.business.concretes;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Kodlama.io.Devs.business.abstracts.ProgrammingLanguageService;
import Kodlama.io.Devs.business.constants.Messages;
import Kodlama.io.Devs.business.requests.programmingLanguage.CreateProgrammingLanguageRequest;
import Kodlama.io.Devs.business.responses.programmingLanguage.CreateProgrammingLanguageResponse;
import Kodlama.io.Devs.business.responses.programmingLanguage.GetAllProgrammingLanguagesResponse;
import Kodlama.io.Devs.business.responses.programmingLanguage.GetByIdProgrammingLanguageResponse;
import Kodlama.io.Devs.business.responses.programmingLanguage.GetByNameProgrammingLanguageResponse;
import Kodlama.io.Devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

@Service
public class ProgrammingLanguageManager implements ProgrammingLanguageService {
	
	private ProgrammingLanguageRepository programmingLanguageRepository;
	private ModelMapper modelMapper;
	
	@Autowired
	public ProgrammingLanguageManager(ProgrammingLanguageRepository programmingLanguageRepository, ModelMapper modelMapper) {
		this.programmingLanguageRepository = programmingLanguageRepository;
		this.modelMapper = modelMapper;
	}

	// * * * CRUD OPERATIONS * * *
	
	public CreateProgrammingLanguageResponse create(CreateProgrammingLanguageRequest createProgrammingLanguageRequest) throws Exception{
		nameCannotBeSame(createProgrammingLanguageRequest.getName());
		
		ProgrammingLanguage programmingLanguage = modelMapper.map(createProgrammingLanguageRequest, ProgrammingLanguage.class);
		ProgrammingLanguage saveProgrammingLanguageResult = programmingLanguageRepository.save(programmingLanguage);
		
		CreateProgrammingLanguageResponse createProgrammingLanguageResponse = modelMapper.map(saveProgrammingLanguageResult, CreateProgrammingLanguageResponse.class);
		return createProgrammingLanguageResponse;		
	}

	// * * * GET METHODS * * *
	
	@Override
	public List<GetAllProgrammingLanguagesResponse> getAll() {
		return programmingLanguageRepository.findAll();
	}

	@Override
	public GetByIdProgrammingLanguageResponse getById(int id) {
		return programmingLanguageRepository.getById(id);
	}
	
	public GetByNameProgrammingLanguageResponse getByName(String name) {
		return programmingLanguageRepository.getByName(name);
	}

	// * * * BUSINESS RULES * * *
	private void nameCannotBeSame(String name) throws Exception {

		ProgrammingLanguage getByNameProgrammingLanguageResult = programmingLanguageRepository.getByName(name);

		var result = getByNameProgrammingLanguageResult;

		if (result != null) {
			throw new Exception(Messages.PLAN_NAME_ALREADY_EXISTS);
		}
	}
}
