package ca.crystalshard.ruby.common.adapter.persistance.repositories;

import ca.crystalshard.ruby.common.domain.BuildStep;
import ca.crystalshard.ruby.common.domain.BuildType;
import ca.crystalshard.ruby.common.domain.identifier.BuildStepId;
import ca.crystalshard.ruby.common.domain.identifier.JobId;
import ca.crystalshard.ruby.common.domain.persistance.repositories.BuildStepRepository;
import ca.crystalshard.ruby.common.adapter.persistance.Storage;
import ca.crystalshard.ruby.common.adapter.persistance.StorageConnection;

import java.util.Optional;

public class BuildStepRepositoryBase implements BuildStepRepository {
    String retrieveQuery;
    String deleteQuery;
    String insertQuery;
    String updateQuery;

    private Storage storage;

    public BuildStepRepositoryBase(Storage storage) {
        this.storage = storage;
    }

    @Override
    public Optional<BuildStep> getBuildStep(BuildStepId buildStepId) {
        try (StorageConnection con = storage.open()) {
            BuildStepDto buildStepDto = con.createQuery(retrieveQuery)
                    .addParameter("id", buildStepId.getId())
                    .executeAndFetchFirst(BuildStepDto.class);

            return buildStepDto != null
                    ? Optional.of(toBuildStep(buildStepDto))
                    : Optional.empty();
        }
        catch (Exception e) {
            throw new RuntimeException(String.format("Failed to retrieve build step with id: %s", buildStepId.toString()), e);
        }
    }

    @Override
    public BuildStepId saveBuildStep(BuildStep buildStep) {
        try (StorageConnection con = storage.open()) {
            Integer buildStepId = con.createQuery(insertQuery, true)
                    .addParameter("name", buildStep.getName())
                    .addParameter("jobId", buildStep.getJobId().getId())
                    .addParameter("buildTypeId", buildStep.getBuildType().getId())
                    .addParameter("orderValue", buildStep.getOrderValue())
                    .addParameter("isDisabled", buildStep.isDisabled() ? 1 : 0)
                    .executeUpdateWithKey(Integer.class);

            return BuildStepId.of(buildStepId);
        }
        catch(Exception e) {
            String exceptionMessage = String.format("Unable to save build step: %s", buildStep.getName());
            throw new UnableToSaveException(exceptionMessage, e);
        }
    }

    @Override
    public void updateBuildStep(BuildStepId id, BuildStep buildStep) {
        try (StorageConnection con = storage.open()) {
            con.createQuery(updateQuery, false)
                    .addParameter("name", buildStep.getName())
                    .addParameter("jobId", buildStep.getJobId().getId())
                    .addParameter("buildTypeId", buildStep.getBuildType().getId())
                    .addParameter("orderValue", buildStep.getOrderValue())
                    .addParameter("isDisabled", buildStep.isDisabled() ? 1 : 0)
                    .addParameter("id", id.getId())
                    .executeUpdate();
        }
        catch (Exception e) {
            String exceptionMessage = String.format("Unable to update build step id: %s", id.getId());
            throw new UnableToSaveException(exceptionMessage, e);
        }
    }

    @Override
    public void deleteBuildStep(BuildStepId id) {
        try (StorageConnection con = storage.open()) {
            con.createQuery(deleteQuery)
                    .addParameter("id", id.getId())
                    .executeUpdate();
        }
    }

    private BuildStep toBuildStep(BuildStepDto buildStepDto) {
        return new BuildStep(
                BuildStepId.of(buildStepDto.id),
                buildStepDto.name,
                JobId.of(buildStepDto.jobId),
                BuildType.of(buildStepDto.buildTypeId),
                buildStepDto.orderValue,
                buildStepDto.isDisabled == 1,
                buildStepDto.createdDateUtc,
                buildStepDto.updatedDateUtc,
                buildStepDto.deletedDateUtc
        );
    }

    private class BuildStepDto {
        int id;
        String name;
        int jobId;
        int buildTypeId;
        int orderValue;
        int isDisabled;
        String createdDateUtc;
        String updatedDateUtc;
        String deletedDateUtc;
    }
}
