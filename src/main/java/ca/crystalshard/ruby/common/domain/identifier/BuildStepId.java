package ca.crystalshard.ruby.common.domain.identifier;

public class BuildStepId extends IntegerId {

    public static BuildStepId of(String id) {
        return new BuildStepId(Integer.parseInt(id));
    }

    public static BuildStepId of(int id) {
        return new BuildStepId(id);
    }

    BuildStepId(Integer id) {
        super(id);
    }
}
