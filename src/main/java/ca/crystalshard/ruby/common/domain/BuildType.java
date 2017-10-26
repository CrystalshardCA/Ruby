package ca.crystalshard.ruby.common.domain;

public enum BuildType {
    SHELL_SCRIPT(1);

    public static BuildType of(int id) {
        for (BuildType type : BuildType.values()) {
            if (type.id == id) {
                return type;
            }
        }
        throw new RuntimeException(String.format("A Build Type was not found with id of %s",id));
    }

    private int id;

    private BuildType(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

}
