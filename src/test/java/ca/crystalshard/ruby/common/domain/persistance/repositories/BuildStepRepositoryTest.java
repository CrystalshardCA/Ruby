package ca.crystalshard.ruby.common.domain.persistance.repositories;

import ca.crystalshard.ruby.common.domain.BuildStep;
import ca.crystalshard.ruby.common.domain.BuildType;
import ca.crystalshard.ruby.common.domain.Job;
import ca.crystalshard.ruby.common.domain.identifier.BuildStepId;
import ca.crystalshard.ruby.common.domain.identifier.JobId;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("ConstantConditions")
public class BuildStepRepositoryTest extends AbstractRepositoryTest {

    private BuildStepRepository buildStepRepository;
    private JobRepository jobRepository;
    private JobId jobId;

    @Before
    public void setUp() {
        buildStepRepository = injector.getInstance(BuildStepRepository.class);
        jobRepository = injector.getInstance(JobRepository.class);
        Job job = new Job("TestJob");
        jobId = jobRepository.saveJob(job);
    }

    @Test
    public void save_shouldSaveBuildStep_whenDoesNotExist() {
        BuildStep buildStep = new BuildStep("BSSaveTest", jobId, BuildType.SHELL_SCRIPT, 1, false);

        BuildStepId id = buildStepRepository.saveBuildStep(buildStep);

        Optional<BuildStep> actual = buildStepRepository.getBuildStep(id);
        Assert.assertEquals(buildStep.getName(), actual.get().getName());
    }

    @Test
    public void delete_shouldDeleteBuildStep() {
        BuildStep buildStep = new BuildStep("Should Delete", jobId, BuildType.SHELL_SCRIPT, 1, false);

        BuildStepId id = buildStepRepository.saveBuildStep(buildStep);

        buildStepRepository.deleteBuildStep(id);

        Optional<BuildStep> actual = buildStepRepository.getBuildStep(id);
        Assert.assertFalse(actual.isPresent());

    }

    @Test
    public void update_shouldUpdateBuildStep() {
        BuildStep buildStep = new BuildStep("OldName", jobId, BuildType.SHELL_SCRIPT, 1, false);
        BuildStepId toUpdate = buildStepRepository.saveBuildStep(buildStep);

        BuildStep newBuildStep = new BuildStep("NewName", jobId, BuildType.SHELL_SCRIPT, 2, true);

        buildStepRepository.updateBuildStep(toUpdate, newBuildStep);

        Optional<BuildStep> actual = buildStepRepository.getBuildStep(toUpdate);
        Assert.assertEquals(newBuildStep.getName(), actual.get().getName());
        Assert.assertEquals(newBuildStep.getBuildType().getId(), actual.get().getBuildType().getId());
        Assert.assertEquals(newBuildStep.getOrderValue(), actual.get().getOrderValue());
        Assert.assertEquals(newBuildStep.isDisabled(), actual.get().isDisabled());
    }

    @Test
    public void getAllBuildStepsForJob_shouldGetAllJobs() {
        String stepName = "GetAllTest";
        BuildStep buildStep = new BuildStep(stepName, jobId, BuildType.SHELL_SCRIPT, 1, false);
        buildStepRepository.saveBuildStep(buildStep);
        String stepName2 = "GetAllTest2";
        BuildStep buildStep2 = new BuildStep(stepName2, jobId, BuildType.SHELL_SCRIPT, 1, false);
        buildStepRepository.saveBuildStep(buildStep2);

        List<BuildStep> results = buildStepRepository.getAllBuildStepsForJob(jobId);
        Assert.assertTrue(results.stream().anyMatch(e -> e.getName().equals(stepName)));
        Assert.assertTrue(results.stream().anyMatch(e -> e.getName().equals(stepName2)));
    }
}