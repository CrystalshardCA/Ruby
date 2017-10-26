package ca.crystalshard.ruby.common.domain.persistance.repositories;

import ca.crystalshard.ruby.common.domain.Job;
import ca.crystalshard.ruby.common.domain.identifier.JobId;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("ConstantConditions")
public class JobRepositoryTest extends AbstractRepositoryTest {

    private JobRepository jobRepository;


    @Before
    public void setUp() {
        jobRepository = injector.getInstance(JobRepository.class);
    }

    @Test
    public void save_shouldSaveJob_whenDoesNotExist() {
        Job job = new Job("JobApiGetHandler");

        JobId newJob = jobRepository.saveJob(job);

        Optional<Job> actual = jobRepository.getJob(newJob);
        Assert.assertEquals(job.getName(), actual.get().getName());
    }

    @Test
    public void delete_shouldDeleteJob() {
        Job job = new Job("Should Delete");

        JobId newJob = jobRepository.saveJob(job);

        jobRepository.deleteJob(newJob);

        Optional<Job> actual = jobRepository.getJob(newJob);
        Assert.assertFalse(actual.isPresent());
    }

    @Test
    public void update_shouldUpdateJob() {
        Job job = new Job("OldName");
        JobId toUpdate = jobRepository.saveJob(job);

        Job newJob = new Job("NewName");

        jobRepository.updateJob(toUpdate, newJob);

        Optional<Job> actual = jobRepository.getJob(toUpdate);
        Assert.assertEquals(newJob.getName(), actual.get().getName());
    }

    @Test
    public void getAll_shouldGetAllJobs() {
        String jobName = "GetAllTest";
        Job job = new Job(jobName);
        jobRepository.saveJob(job);
        String jobName2 = "GetAllTest2";
        Job job2 = new Job(jobName2);
        jobRepository.saveJob(job2);

        List<Job> results = jobRepository.getAllJobs();
        Assert.assertTrue(results.stream().anyMatch(e -> e.getName().equals(jobName)));
        Assert.assertTrue(results.stream().anyMatch(e -> e.getName().equals(jobName2)));
    }
}

