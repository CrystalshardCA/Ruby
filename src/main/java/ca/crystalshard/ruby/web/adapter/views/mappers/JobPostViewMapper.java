package ca.crystalshard.ruby.web.adapter.views.mappers;

import ca.crystalshard.ruby.common.domain.Job;
import ca.crystalshard.ruby.web.adapter.views.JobPostView;

public class JobPostViewMapper {
    public Job toDomain(JobPostView view) {
        return new Job(view.name);
    }
}
