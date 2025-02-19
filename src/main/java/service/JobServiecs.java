package service;

import java.util.Date;
import java.util.List;
import entity.JobEntity;
import repository.JobRepository;

public class JobServiecs {
	private JobRepository jobRepository = new JobRepository();

	public List<JobEntity> getAllJobs() {
		return jobRepository.findAllJobs();
	}

	public boolean insertJob(String name, Date start_date, Date end_date) {
		return jobRepository.insertJob(name, start_date, end_date) > 0;
	}

	public boolean updateJob(int id, String name, Date start_date, Date end_date) {
		return jobRepository.updateJob(id, name, start_date, end_date) > 0;
	}

	public boolean deleteJob(int id) {
		return jobRepository.deleteJob(id) > 0;
	}

	public JobEntity getJobById(int id) {
		return jobRepository.findJobById(id);
	}

}
