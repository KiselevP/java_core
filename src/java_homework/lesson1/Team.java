import java.util.ArrayList;

public class Team {
    private final String teamName;
    private Human[] listTeam = new Human[4];
    private ArrayList<Human> listSuccessParticipant = new ArrayList<>();

    public Team(String teamName, Human participant1, Human participant2, Human participant3, Human participant4) {
        this.teamName = teamName;
        listTeam = new Human[]
                {
                participant1,
                participant2,
                participant3,
                participant4
        };
    }

    public void getListTeam(){
        System.out.println("Команда " + teamName + ":");
        for (int i = 0; i < listTeam.length; i++) {
            System.out.println(
                    "    №" + (i + 1)  + " - " +
                    listTeam[i].toString() + " (" +
                    listTeam[i].getEnergy() + "%)"
            );
        }
    }

    public void setListTeam(Human[] listTeam) {
        this.listTeam = listTeam;
    }

    public Human[] getListParticipant() {
        return listTeam;
    }

    public void addListSuccessParticipant(Human human) {
        listSuccessParticipant.add(human);
    }

    public void getListSuccessParticipant() {
        System.out.println("C полосой справились:");
        for(Human human: listSuccessParticipant) {
            System.out.println(human);
        };
        System.out.println("С чем мы их и поздравляем!!!");
    }

}
