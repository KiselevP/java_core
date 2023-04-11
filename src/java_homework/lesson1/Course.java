public class Course {

    private final Obstacle[] obstacle;

    public Course(Obstacle obstacleOne,
                  Obstacle obstacleTwo,
                  Obstacle obstacleTree,
                  Obstacle obstacleFour)
    {
        obstacle = new Obstacle[]{
                                    obstacleOne,
                                    obstacleTwo,
                                    obstacleTree,
                                    obstacleFour
                                };
    }

    public void doIt(Team team) {

        Human[] listParticipant = team.getListParticipant();

        for (Human human : listParticipant) {
            int countPoints = 0;
            for (Obstacle value : obstacle) {
                if (human.getEnergy() >= value.getEnergyCost()) {
                    human.setEnergy(human.getEnergy() - value.getEnergyCost());
                    countPoints++;
                } else {
                    continue;
                }
            }
            if (countPoints == obstacle.length) team.addListSuccessParticipant(human);
        }

        team.setListTeam(listParticipant);
    }

    public void showObstacle(){
        for (Obstacle value : obstacle) {
            value.getInformObstacle();
        }
    }

}
