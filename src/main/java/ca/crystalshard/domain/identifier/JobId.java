package ca.crystalshard.domain.identifier;

public class JobId extends IntegerId {

    public static JobId of(String id) {
        return new JobId(Integer.parseInt(id));
    }

    public static JobId of(int id) {
        return new JobId(id);
    }

    private JobId(Integer id) {
        super(id);
    }
}
