//Yeela Granot  209133107   group 111-14

import java.util.ArrayList;
import java.util.List;

/**
 * main class run the game.
 */
public class Arkanoid {

    /**
     * start game.
     * @param args user parameters - not used.
     */
    public static void main(String[] args) {
        List<LevelInformation> levels = new ArrayList<>(); //make list with 4 levels for game flow to control
        for (int i = 0; i < args.length; i++) {

            char ch = args[i].charAt(0);
            int numOfLevel = ch - '0';

            switch (numOfLevel) {
                case 1:
                    levels.add(new DirectHit(new BackGroundDirectHit()));
                    break;
                case 2:
                    levels.add(new WideEasy(new WideEasyBackGround()));
                    break;
                case 3:
                    levels.add(new Green3(new Green3BackGround(new Point(50, 50), 50, 50)));
                    break;
                case 4:
                    levels.add(new FinalFour(new FinalFourBackGround()));
                    break;
                default:
                    break;
            }
        }
       if (levels.isEmpty()) {
           levels.add(new DirectHit(new BackGroundDirectHit()));
           levels.add(new WideEasy(new WideEasyBackGround()));
           levels.add(new Green3(new Green3BackGround(new Point(50, 50), 50, 50)));
           levels.add(new FinalFour(new FinalFourBackGround()));
       }
        AnimationRunner gameRunner = new AnimationRunner(); //create animation logic runner
        GameFlow gameFlow = new GameFlow(gameRunner, gameRunner.getKeyboard());
        gameFlow.runLevels(levels); //start the game flow
        gameRunner.getGui().close();
    }
}
