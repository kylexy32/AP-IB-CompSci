
import java.util.Random;
/**
 * Write a description of class TurtleRace here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TurtleRace
{

    private class TurtleStat {
        public int position = 0;
        public String color = "";
        //constructor
        public TurtleStat(int a, String b) {
            position = a;
            color = b;
        }

        public void sayStats() {
            System.out.println("The " + color + " turtle made it " + position + " steps!");
        }
    }

    // instance variables - replace the example below with your own
    Turtle[] turtleArray = { new Turtle() , new Turtle() , new Turtle() , new Turtle() , new Turtle()};
    String[] colorArray = { "Red" , "Blue" , "Green" , "Orange" , "Purple" };
    int[] finalPositions = { 0, 0, 0, 0, 0 };
    TurtleStat[] finalStatArray = {new TurtleStat(0, "Red"), new TurtleStat(0, "Red"), new TurtleStat(0, "Red"), new TurtleStat(0, "Red"), new TurtleStat(0, "Red")};
    boolean winner = false;
    int turtleToMove = 0;

    /**
     * Constructor for objects of class TurtleRace
     */
    public TurtleRace()
    {
        setupRace();
        //intro();
        clear();
        executeRace();
        evaluateFinalResults();
    }

    public void evaluateFinalResults() {
        //Load FinalStatArray with final stats 
        for (int i =0; i<finalStatArray.length; i++) {
            Double position = turtleArray[i].getX();
            int thisPosition = (int) Math.round(position);
            String thisColor = colorArray[i];
            finalStatArray[i] = new TurtleStat(thisPosition, thisColor);
        }
        sort();
        for (int i =0; i<finalStatArray.length; i++) {
            System.out.println("The " + finalStatArray[i].color + " turtle made it " + finalStatArray[i].position + " steps.");
        }
    }

    public void sort() {
        for (int x=0; x<finalStatArray.length; x++) {
            for (int i =0; i<finalStatArray.length; i++) {
                String colorValueOne = finalStatArray[i].color;
                int valueOne = finalStatArray[i].position;
                TurtleStat newTurtOne = new TurtleStat(valueOne, colorValueOne);
                if (i == finalStatArray.length - 1) {
                    break;
                } else {
                    int valueTwo = finalStatArray[i+1].position;
                    String colorValueTwo = finalStatArray[i+1].color;
                    TurtleStat newTurtTwo = new TurtleStat(valueTwo, colorValueTwo);
                    if (!(valueOne > valueTwo)) {
                        finalStatArray[i] = newTurtTwo;
                        finalStatArray[i+1] = newTurtOne;
                    }
                }
            }
        }
    }

    public void executeRace() {
        while(!winner) {
            int turtleNumber = randomTurtle();
            turtleArray[turtleNumber].forward(5);
            checkForWinner();
        }
    }

    public void checkForWinner() {

        for (int i =0; i<turtleArray.length; i++) {
            if (turtleArray[i].getX() == 100 || turtleArray[i].getX() > 100) {
                winner = true;
                break;
            }
        }
    }

    public int randomTurtle() {
        return new Random().nextInt(5) + 0;
    }

    public void setupRace() {
        drawStartAndFinish();
        for (int i =0; i<turtleArray.length; i++) {
            turtleArray[i].up();
            turtleArray[i].fillColor(colorArray[i]);
            int positionX = -100;
            int positionY = -50 + (50*i);
            turtleArray[i].setPosition(positionX, positionY);
            turtleArray[i].setDirection(0);
        }
    }

    public void drawStartAndFinish() {
        turtleArray[0].up();
        turtleArray[0].setPosition(-100, 200);
        turtleArray[0].down();
        turtleArray[0].setDirection(-90);
        turtleArray[0].forward(300);
        turtleArray[0].up();

        turtleArray[0].setPosition(100, 200);
        turtleArray[0].down();
        turtleArray[0].setDirection(-90);
        turtleArray[0].forward(300);
        turtleArray[0].up();
    }

    public void intro() {
        say("Welcome to the turtle race!!!");
        waitAndClear(3000);
        say("We will begin the race in...");
        waitAndClear(1000);
        say("3");
        waitAndClear(1000);
        say("2");
        waitAndClear(1000);
        say("1");
    }

    public void say(String message) {
        System.out.println(message);
    }

    public void clear() {
        System.out.println("\f");
    }

    public void waitAndClear(int time) {
        try {
            Thread.sleep(time);
            clear();
        } catch (InterruptedException e) {
            // Interrupted exception will occur if
            // the Worker object's interrupt() method
            // is called. interrupt() is inherited
            // from the Thread class.
        }
    }
}