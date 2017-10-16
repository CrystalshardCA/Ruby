package ca.crystalshard.adapter.web.viewmodels.mappers;

import ca.crystalshard.adapter.web.viewmodels.JobPostView;
import ca.crystalshard.domain.Job;

public class JobPostViewMapper {
    public Job toDomain(JobPostView view) {
        return new Job(view.name);
    }
}
