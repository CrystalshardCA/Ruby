package ca.crystalshard.adapter.web.viewmodels.mappers;

import ca.crystalshard.adapter.web.viewmodels.JobView;
import ca.crystalshard.domain.Job;

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

