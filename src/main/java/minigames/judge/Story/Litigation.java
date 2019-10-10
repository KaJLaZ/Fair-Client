package Story;

import lombok.NonNull;

public class Litigation {
    private String personDescription;
    public String getPersonDescription() {
        return personDescription;
    }

    private String faultDesc;
    public String getFaultDesc() {
        return faultDesc;
    }

    private String descPosChoice;
    public String getDescPosChoice() {
        return descPosChoice;
    }

    private String descNegChoice;
    public String getDescNegChoice() {
        return descNegChoice;
    }

    public Litigation(@NonNull String personDescription, @NonNull String faultDesc,
                      @NonNull String descPosChoice,     @NonNull String descNegChoice) {

        this.personDescription = personDescription;
        this.faultDesc = faultDesc;
        this.descPosChoice = descPosChoice;
        this.descNegChoice = descNegChoice;

    }
}
