package TeamworkProjects;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static List<Team> teams = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());


        while (n-- > 0) {
            String[] data = scanner.nextLine().split("-");

            String user = data[0]; //the creator
            String teamName = data[1]; //team name

            myBestFunction(user, teamName);
        }

        String line = scanner.nextLine();
        while (!line.equals("end of assignment")) {

            String[] tokens = line.split("->");

            String person = tokens[0];
            String goToTeam = tokens[1];

            myGreatestFunction(person, goToTeam);

            line = scanner.nextLine();
        }

        for (Team team : teams) {
            team.getMembers().sort(String::compareTo); //sorting list alphabeticaly
        }

        teams.stream()
                //.sorted((e2, e1) -> Integer.compare(e1.getMembers().size(), e2.getMembers().size()))      50/100
                .sorted(Comparator.comparingInt(Team::getMembersSize).reversed().thenComparing(Team::getName)) //s taq glupost 66/100
                .forEach(team -> {
                    {
                        if (!team.getMembers().isEmpty()) {
                            System.out.println(team.getName());

                            System.out.println("- " + team.getCreator());

                            team.getMembers()
                                   // .stream()
                                    //.sorted(String::compareTo)  //peshovcite grumnaha
                                    .forEach(e -> {
                                {
                                    System.out.println(String.format("-- %s", e));
                                }
                            });

                        }
                    }
                });
        List<String> teamsToDisband = new ArrayList<>();
        for (Team team : teams) {
            if (team.getMembers().isEmpty()) {
                teamsToDisband.add(team.getName());
            }
        }
        teamsToDisband.sort(String::compareToIgnoreCase);
        System.out.println("Teams to disband:");
        teamsToDisband.forEach(System.out::println);
    }

    private static void myGreatestFunction(String person, String goToTeam) {


        for (Team team : teams) {
            if (team.getName().equals(goToTeam) && !team.getCreator().equals(person)) { //tuk ima 2ro uslovie da
                team.getMembers().add(person);
                return;
            }
            if (!teams.get(teams.size() - 1).getName().equals(goToTeam)) {
                System.out.println(String.format("Team %s does not exist!", goToTeam));
                return;
            }
        }
        for (Team team : teams) {
            if (team.getCreator().equals(person) || team.getMembers().contains(person)) {
                System.out.println(String.format("Member %s cannot join team %s!", person, goToTeam));
                return;
            }
        }
        /*	Member of a team cannot join another team - message should be thrown:
            -	"Member {user} cannot join team {team Name}!"*/

    }

    private static void myBestFunction(String user, String teamName) {
        // try {
        for (Team team : teams) {
            if (team.getName().equals(teamName)) {
                System.out.println(String.format("Team %s was already created!", teamName));
                return;
            }
        }

        for (Team team : teams) {
            if (team.getCreator().equals(user)) {
                System.out.println(String.format("%s cannot create another team!", user));
                return;
            }
        }
        //   }catch (Exception e){}

        teams.add(new Team(user, teamName, new ArrayList<>()));
        System.out.println(String.format("Team %s has been created by %s!",
                teamName, user));
    }
}
