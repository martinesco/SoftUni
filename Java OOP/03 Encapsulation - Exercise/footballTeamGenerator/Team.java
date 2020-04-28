package footballTeamGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Team {

    private String name;
    private List<Player> players;

    public Team(String name) {
        this.setName(name);
        this.players = new ArrayList<>();
    }

    private void setName(String name) {
        Validator.validateName(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addPlayer(Player player) {

        this.players.add(player);
    }

    public void removePlayer(String name) {
        if (players.size() == 0) {
            throw new IllegalArgumentException("Player " + name + " is not in " + this.getName() + " team.");
        }
        this.players.removeIf(player -> player.getName().equals(name));
    }

    public double getRating() {

        double rating = 0.0;

        for (Player player : players) {
            rating += player.overallSkillLevel();
        }
        rating = rating / this.players.size();

        return Math.round(rating);
    }

    public List<Player> getPlayers() {
        return Collections.unmodifiableList(this.players);
    }

    public boolean hasPlayer(String name) {
        boolean result = false;
        for (Player player : this.players) {
            if (player.getName().equals(name)) {
                result = true;
                break;
            }
        }
        return result;
    }
}
