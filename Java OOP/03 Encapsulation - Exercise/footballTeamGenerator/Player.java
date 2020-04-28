package footballTeamGenerator;

public class Player {

    private String name;
    private int endurance;
    private int sprint;
    private int dribble;
    private int passing;
    private int shooting;

    public Player(String name, int endurance, int sprint, int dribble, int passing, int shooting) {
        this.setName(name);
        this.setEndurance(endurance);
        this.setSprint(sprint);
        this.setDribble(dribble);
        this.setPassing(passing);
        this.setShooting(shooting);
    }

    private void setName(String name) {
        Validator.validateName(name);
        this.name = name;
    }

    private void setEndurance(int endurance) {
        Validator.validateStat(endurance, "Endurance");
        this.endurance = endurance;
    }

    private void setSprint(int sprint) {
        Validator.validateStat(sprint, "Sprint");
        this.sprint = sprint;
    }

    private void setDribble(int dribble) {
        Validator.validateStat(dribble, "Dribble");
        this.dribble = dribble;
    }

    private void setPassing(int passing) {
        Validator.validateStat(passing, "Passing");
        this.passing = passing;
    }

    private void setShooting(int shooting) {
        Validator.validateStat(shooting, "Shooting");
        this.shooting = shooting;
    }

    public String getName() {
        return this.name;
    }


    public double overallSkillLevel() {
        double overall = (this.endurance + this.sprint + this.dribble + this.passing + this.shooting) / 5.0;
        return Math.round(overall);
    }
}
