package ca.crystalshard.ruby.common.domain;

import ca.crystalshard.ruby.common.domain.identifier.BuildStepId;
import ca.crystalshard.ruby.common.domain.identifier.JobId;

public class BuildStep {
    private BuildStepId id;
    private String name;
    private JobId jobId;
    private BuildType buildType;
    private int orderValue;
    private boolean isDisabled;
    private String createdDateUtc;
    private String updatedDateUtc;
    private String deletedDateUtc;

    public BuildStep(BuildStepId id, String name, JobId jobId, BuildType buildType, int orderValue,
                     boolean isDisabled, String createdDateUtc, String updatedDateUtc, String deletedDateUtc) {
        this.id = id;
        this.name = name;
        this.jobId = jobId;
        this.buildType = buildType;
        this.orderValue = orderValue;
        this.isDisabled = isDisabled;
        this.createdDateUtc = createdDateUtc;
        this.updatedDateUtc = updatedDateUtc;
        this.deletedDateUtc = deletedDateUtc;
    }

    public BuildStep(String name, JobId jobId, BuildType buildType, int orderValue, boolean isDisabled) {
        this.name = name;
        this.jobId = jobId;
        this.buildType = buildType;
        this.orderValue = orderValue;
        this.isDisabled = isDisabled;
    }

    public BuildStepId getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public JobId getJobId() {
        return jobId;
    }

    public BuildType getBuildType() {
        return buildType;
    }

    public int getOrderValue() {
        return orderValue;
    }

    public boolean isDisabled() {
        return isDisabled;
    }

    public String getCreatedDateUtc() {
        return createdDateUtc;
    }

    public String getUpdatedDateUtc() {
        return updatedDateUtc;
    }

    public String getDeletedDateUtc() {
        return deletedDateUtc;
    }
}
