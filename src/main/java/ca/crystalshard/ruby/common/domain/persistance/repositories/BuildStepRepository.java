package ca.crystalshard.ruby.common.domain.persistance.repositories;

import ca.crystalshard.ruby.common.domain.BuildStep;
import ca.crystalshard.ruby.common.domain.identifier.BuildStepId;
import ca.crystalshard.ruby.common.domain.identifier.JobId;

import java.util.List;
import java.util.Optional;

public interface BuildStepRepository {
    Optional<BuildStep> getBuildStep(BuildStepId buildStepId);

    BuildStepId saveBuildStep(BuildStep buildStep);

    void updateBuildStep(BuildStepId id, BuildStep buildStep);

    void deleteBuildStep(BuildStepId id);

    List<BuildStep> getAllBuildStepsForJob(JobId jobId);
}