package ca.crystalshard.domain;

import ca.crystalshard.domain.identifier.JobId;

public class Job {
    private JobId id;
    private String name;
    private String createdDateUtc;
    private String updatedDateUtc;
    private String deletedDateUtc;

    public Job(String name) {
        this.name = name;
    }

    public Job(JobId id, String name, String createdDateUtc, String updatedDateUtc, String deletedDateUtc) {
        this.id = id;
        this.name = name;
        this.createdDateUtc = createdDateUtc;
        this.updatedDateUtc = updatedDateUtc;
        this.deletedDateUtc = deletedDateUtc;
    }

    public JobId getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
