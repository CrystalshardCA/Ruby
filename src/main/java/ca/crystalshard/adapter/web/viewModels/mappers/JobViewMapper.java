package ca.crystalshard.adapter.web.viewModels.mappers;

import ca.crystalshard.adapter.web.viewModels.JobPostView;
import ca.crystalshard.adapter.web.viewModels.JobView;
import ca.crystalshard.domain.Job;
import ca.crystalshard.domain.identifier.JobId;

public class JobViewMapper {
    public JobView toView(Job job) {
        JobView view = new JobView();

        view.id = job.getId().getId();
        view.name = job.getName();
        view.createdDateUtc = job.getCreatedDateUtc();
        view.updatedDateUtc = job.getUpdatedDateUtc();
        view.deletedDateUtc = job.getDeletedDateUtc();

        return view;
    }
}

