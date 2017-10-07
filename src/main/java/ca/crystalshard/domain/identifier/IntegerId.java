package ca.crystalshard.domain.identifier;

public abstract class IntegerId extends Id<Integer> {

    IntegerId(Integer id) {
        super(id);
    }

    @Override
    public int compareTo(Id<Integer> other) { return this.getId().compareTo(other.getId());}
}
