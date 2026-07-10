package no.alirizakeles.aijobmatcher;

import no.alirizakeles.aijobmatcher.repository.JobRepository;
import no.alirizakeles.aijobmatcher.service.JobService;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import no.alirizakeles.aijobmatcher.entity.Job;

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
        assertEquals("Java Developer", result.getFirst().getTitle());

        verify(jobRepository).findAll();
    }
}