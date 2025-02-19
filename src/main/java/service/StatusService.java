package service;

import java.util.List;
import entity.StatusEntity;
import repository.StatusRepository;

public class StatusService {
	private StatusRepository statusRepository = new StatusRepository();

	public List<StatusEntity> getAllStatus() {
		return statusRepository.findAll();
	}
}
