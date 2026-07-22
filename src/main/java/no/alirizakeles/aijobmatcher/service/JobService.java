package no.alirizakeles.aijobmatcher.service;

import no.alirizakeles.aijobmatcher.repository.JobRepository;
import org.springframework.stereotype.Service;
import no.alirizakeles.aijobmatcher.entity.Job;
import no.alirizakeles.aijobmatcher.dto.CreateJobRequest;
import no.alirizakeles.aijobmatcher.exception.JobNotFoundException;
import no.alirizakeles.aijobmatcher.dto.UpdateJobRequest;

import java.util.List;

@Service
public class JobService {

    private final JobRepository jobRepository;

    public JobService(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }
    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }
    public Job createJob(CreateJobRequest request) {

        Job job = new Job();

        job.setTitle(request.getTitle());
        job.setCompanyName(request.getCompanyName());
        job.setLocation(request.getLocation());
        job.setDescription(request.getDescription());
        job.setUrl(request.getUrl());
        job.setEmploymentType(request.getEmploymentType());

        return jobRepository.save(job);
    }
    public Job getJobById(Long id) {
        return jobRepository.findById(id)
                .orElseThrow(() -> new JobNotFoundException(id));
    }
    public Job updateJob(Long id, UpdateJobRequest request) {

        Job job = jobRepository.findById(id)
                .orElseThrow(() -> new JobNotFoundException(id));

        job.setTitle(request.getTitle());
        job.setCompanyName(request.getCompanyName());
        job.setLocation(request.getLocation());
        job.setDescription(request.getDescription());
        job.setUrl(request.getUrl());
        job.setEmploymentType(request.getEmploymentType());

        return jobRepository.save(job);
    }
    public void deleteJob(Long id) {

        Job job = jobRepository.findById(id)
                .orElseThrow(() -> new JobNotFoundException(id));

        jobRepository.delete(job);
    }
    public List<Job> searchJobs(String keyword) {
        return jobRepository.findByTitleContainingIgnoreCase(keyword);
    }
    public List<Job> searchJobsByLocation(String location) {
        return jobRepository.findByLocationContainingIgnoreCase(location);
    }
}