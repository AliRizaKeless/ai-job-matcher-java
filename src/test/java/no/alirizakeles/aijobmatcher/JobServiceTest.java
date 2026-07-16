package no.alirizakeles.aijobmatcher;

import no.alirizakeles.aijobmatcher.repository.JobRepository;
import no.alirizakeles.aijobmatcher.service.JobService;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import no.alirizakeles.aijobmatcher.entity.Job;
import no.alirizakeles.aijobmatcher.exception.JobNotFoundException;
import no.alirizakeles.aijobmatcher.dto.CreateJobRequest;
import no.alirizakeles.aijobmatcher.dto.UpdateJobRequest;

import static org.mockito.ArgumentMatchers.any;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;

@ExtendWith(MockitoExtension.class)
class JobServiceTest {

    @Mock
    private JobRepository jobRepository;

    @InjectMocks
    private JobService jobService;

    @Test
    void contextLoads() {
    }

    @Test
    void getAllJobs_shouldReturnListOfJobs() {
        Job job = new Job();
        job.setId(1L);
        job.setTitle("Java Developer");

        when(jobRepository.findAll()).thenReturn(List.of(job));

        List<Job> result = jobService.getAllJobs();

        assertEquals(1, result.size());
        assertEquals("Java Developer", result.get(0).getTitle());

        verify(jobRepository).findAll();
    }
    @Test
    void getJobById_shouldThrowExceptionWhenJobNotFound() {

        when(jobRepository.findById(99L)).thenReturn(Optional.empty());

        assertThrows(JobNotFoundException.class, () -> jobService.getJobById(99L));

        verify(jobRepository).findById(99L);
    }
    @Test
    void deleteJob_shouldDeleteExistingJob() {

        Job job = new Job();
        job.setId(1L);

        when(jobRepository.findById(1L)).thenReturn(Optional.of(job));

        jobService.deleteJob(1L);

        verify(jobRepository).findById(1L);
        verify(jobRepository).delete(job);
    }
    @Test
    void createJob_shouldSaveJob() {

        CreateJobRequest request = new CreateJobRequest();
        request.setTitle("Java Developer");
        request.setCompanyName("Capgemini");
        request.setLocation("Oslo");

        Job savedJob = new Job();
        savedJob.setId(1L);
        savedJob.setTitle("Java Developer");

        when(jobRepository.save(any(Job.class))).thenReturn(savedJob);

        Job result = jobService.createJob(request);

        assertEquals(1L, result.getId());
        assertEquals("Java Developer", result.getTitle());

        verify(jobRepository).save(any(Job.class));
    }
    @Test
    void getJobById_shouldReturnJobWhenExists() {

        Job job = new Job();
        job.setId(1L);
        job.setTitle("Java Developer");

        when(jobRepository.findById(1L)).thenReturn(Optional.of(job));

        Job result = jobService.getJobById(1L);

        assertEquals(1L, result.getId());
        assertEquals("Java Developer", result.getTitle());

        verify(jobRepository).findById(1L);
    }
    @Test
    void updateJob_shouldUpdateExistingJob() {

        Job existingJob = new Job();
        existingJob.setId(1L);
        existingJob.setTitle("Old Title");

        UpdateJobRequest request = new UpdateJobRequest();
        request.setTitle("New Title");
        request.setCompanyName("Capgemini");
        request.setLocation("Oslo");
        request.setDescription("Updated description");
        request.setUrl("https://example.com/job");
        request.setEmploymentType("FULL_TIME");

        when(jobRepository.findById(1L)).thenReturn(Optional.of(existingJob));
        when(jobRepository.save(any(Job.class))).thenReturn(existingJob);

        Job result = jobService.updateJob(1L, request);

        assertEquals("New Title", result.getTitle());

        verify(jobRepository).findById(1L);
        verify(jobRepository).save(existingJob);
    }
}