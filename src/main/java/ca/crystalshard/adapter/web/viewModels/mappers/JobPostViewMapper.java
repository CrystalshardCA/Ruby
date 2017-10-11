package ca.crystalshard.adapter.web.viewModels.mappers;

import ca.crystalshard.adapter.web.viewModels.JobPostView;
import ca.crystalshard.domain.Job;

public class JobPostViewMapper {
    public Job toDomain(JobPostView view) {
        return new Job(view.name);
    }
}
