package serverCore;

import lombok.NonNull;

public class Litigation {
    private String personDescription;
    private String faultDesc;
    private String descPosChoice;
    private String descNegChoice;

    public Litigation(@NonNull String personDescription, @NonNull String faultDesc,
                      @NonNull String descPosChoice, @NonNull String descNegChoice) {

        this.personDescription = personDescription;
        this.faultDesc = faultDesc;
        this.descPosChoice = descPosChoice;
        this.descNegChoice = descNegChoice;

    }

    public Litigation() {

    }

    public String getPersonDescription() {
        return personDescription;
    }

    public String getFaultDesc() {
        return faultDesc;
    }

    public String getDescPosChoice() {
        return descPosChoice;
    }

    public String getDescNegChoice() {
        return descNegChoice;
    }
}
