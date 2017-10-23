package ca.crystalshard.ruby.web.adapter.views.mappers;

import ca.crystalshard.ruby.common.domain.Job;
import ca.crystalshard.ruby.web.adapter.views.JobView;

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

