public class Main {
    public static void main(String[] args) {
        Team team = new Team("Frog",
                new Man("Bob"),
                new Man("Ben"),
                new Woman("Lin"),
                new Woman("Lun"));
        team.getListTeam();

        System.out.println();

        Course course = new Course(
                new Obstacle("1", 15),
                new Obstacle("2", 40),
                new Obstacle("3",14),
                new Obstacle("4",27)
        );
        course.showObstacle();

        System.out.println();

        course.doIt(team);

        team.getListTeam();

        System.out.println();

        team.getListSuccessParticipant();
    }
}
