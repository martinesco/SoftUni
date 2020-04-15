package TeamworkProjects;

import java.util.List;

public class Team {

    private String creator;
    private String name;
    private List<String> members;

    public Team(String creator, String name, List<String> members) {
        this.creator = creator;
        this.name = name;
        this.members = members;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public List<String> getMembers() {
        return members;
    }
    public int getMembersSize(){
        return members.size();
    }

    public void setMembers(List<String> members) {
        this.members = members;
    }
}
