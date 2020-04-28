package footballTeamGenerator;

public class Validator {



    public static void validateName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("A name should not be empty.");
        }
    }

    public static void validateStat(int stat, String statName) {
        if (stat < 0 || stat > 100) {
            throw new IllegalArgumentException(statName + " should be between 0 and 100.");
        }
    }


}
