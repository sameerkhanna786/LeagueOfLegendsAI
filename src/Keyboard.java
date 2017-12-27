import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.MouseInfo;
import java.util.Random;

public class Keyboard {

    /**
     * This program automatically runs through and visits each jungle camp, attacks it, and smites when needed.
     * The bot even goes back to base after each camp in order to not lose too much health.
     * Since everyone's screen resolutions are different, you will need to update the positions the program takes in using
     * the given Mouse_Coordinates_Getter.java
     *
     * The first coordinate for each camp is the location to walk to.
     * The second coordinate is the location needed to be clicked in order to attack.
     *
     * Reccomended champion to use with this bot is Aatrox. The champion was specifically choosen to fine tune the bot due
     * to its name being first in champion select. The bot will work fine with other champions, but the bot may die in the jungle
     * if the champion choice is not ideal. (Ex: Lulu)
     */

    Robot robot = new Robot();
    static boolean need_random = false;
    static Random rand = new Random();
    static int initial_x = MouseInfo.getPointerInfo().getLocation().x;
    static int initial_y = MouseInfo.getPointerInfo().getLocation().y;

    static boolean metCamp[] = new boolean[12];

    public static void main(String[] args) throws AWTException
    {
        new Keyboard();
    }

    public Keyboard() throws AWTException
    {
        robot.setAutoDelay(40);
        robot.setAutoWaitForIdle(true);

        for (int i = 0; i<metCamp.length; i++){
            metCamp[i] = false;
        }

        //create variable that will act as max variation for x and y and
        int var = 1000;
        int change_per_run = 50;

        robot.delay(5000);

        while (true) {
            if (need_random) {
                //robot.setAutoDelay(100);
                if(rand.nextInt(1000) == 0) {
                    talkALot();
                } else if (rand.nextInt(100)%4 == 0) {
                    useSpellRandomly();
                } else {
                    LeagueMoveRandom(var, change_per_run);
                }
            } else{
                attackBlue();
                attackGromp();
                attackWolfs();
                attackRed();
                attackBirds();
                attackRocks();
            }
        }

    }

    private void levelMoves(){
        robot.keyPress(KeyEvent.VK_CONTROL);
        type("w");
        robot.keyRelease(KeyEvent.VK_CONTROL);

        robot.keyPress(KeyEvent.VK_CONTROL);
        type("e");
        robot.keyRelease(KeyEvent.VK_CONTROL);

        robot.keyPress(KeyEvent.VK_CONTROL);
        type("q");
        robot.keyRelease(KeyEvent.VK_CONTROL);

        robot.keyPress(KeyEvent.VK_CONTROL);
        type("r");
        robot.keyRelease(KeyEvent.VK_CONTROL);
    }

    private void attackBlue(){
        if (metCamp[0] == false) {
            robot.mouseMove(881, 659);
            rightClick();
            robot.delay(25000);
            robot.mouseMove(515, 408);
            rightClick();
            robot.delay(10000);
            smite();
            robot.delay(20000);
            goB();
            //metCamp[0] = true;
        } else {
            robot.mouseMove(881, 659);
            rightClick();
            robot.delay(25000);
            robot.mouseMove(515, 408);
            rightClick();
            robot.delay(10000);
            smite();
            robot.delay(20000);
        }
    }

    private void attackGromp(){
        if (metCamp[1] == false) {
            robot.mouseMove(863, 654);
            rightClick();
            robot.delay(25000);
            robot.mouseMove(392, 383);
            rightClick();
            robot.delay(10000);
            smite();
            robot.delay(20000);
            goB();
            //metCamp[1] = true;
        } else {
            robot.mouseMove(863, 654);
            rightClick();
            robot.delay(25000);
            robot.mouseMove(392, 383);
            rightClick();
            robot.delay(10000);
            smite();
            robot.delay(20000);
        }
    }

    private void attackWolfs(){
        if (metCamp[2] == false) {
            robot.mouseMove(880, 678);
            rightClick();
            robot.delay(25000);
            robot.mouseMove(542, 417);
            rightClick();
            robot.delay(10000);
            smite();
            robot.delay(22000);
            goB();
            //metCamp[2] = true;
        } else {
            robot.mouseMove(880, 678);
            rightClick();
            robot.delay(25000);
            robot.mouseMove(542, 417);
            rightClick();
            robot.delay(10000);
            smite();
            robot.delay(22000);
        }
    }

    private void attackBirds(){
        robot.mouseMove(920, 692);
        rightClick();
        robot.delay(27000);
        robot.mouseMove(417, 335);
        rightClick();
        robot.delay(10000);
        smite();
        robot.delay(40000);
        if (metCamp[3] == false){
            goB();
            //metCamp[3] = true;
        }
    }

    private void attackRed(){
        robot.mouseMove(929, 706);
        rightClick();
        robot.delay(27000);
        robot.mouseMove(466, 442);
        rightClick();
        robot.delay(10000);
        smite();
        robot.delay(30000);
        if (metCamp[4] == false){
            goB();
            //metCamp[4] = true;
        }
    }

    private void attackRocks(){
        robot.mouseMove(937, 729);
        rightClick();
        robot.delay(27000);
        robot.mouseMove(539, 329);
        rightClick();
        robot.delay(10000);
        smite();
        robot.delay(40000);
        if (metCamp[5] == false){
            goB();
            //metCamp[5] = true;
        }
    }

    private void smite(){
        type("d");
    }

    private void goB(){
        type("b");
        robot.delay(15000);
    }

    private void LeagueMoveRandom(int var, int change_per_run){
        robot.delay(rand.nextInt(500));
        int change_x = rand.nextInt(change_per_run) - change_per_run/2;
        int change_y = rand.nextInt(change_per_run) - change_per_run/2;

        int curr_x = MouseInfo.getPointerInfo().getLocation().x;
        int curr_y = MouseInfo.getPointerInfo().getLocation().y;
        robot.mouseMove(curr_x + change_x, curr_y + change_y);
        rightClick();
    }

    private void leftClick()
    {
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.delay(rand.nextInt(200));
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
        robot.delay(rand.nextInt(200));
    }

    private void useSpellRandomly()
    {
        int spell = rand.nextInt(3);
        if (spell == 0){
            type("q");
        }
        if (spell == 1){
            //type("w");
        }
        if (spell == 2){
            type("e");
        }
        if (spell == 3){
            type("r");
        }
    }

    private void talkALot()
    {
        String[] strings = new String[15];
        for(int i = 0; i < strings.length; i++){
            strings[i] = ".";
        }
        strings[1] = "Bro, I swear something is up with my mouse rn.";
        strings[2] = "I think my mouse is acting up.";
        strings[3] = "It's very difficult to be great. Losers prove this point continuously.";
        strings[4] = "You will never have anything you don't respect, including lot's of money";
        strings[5] = "It's difficult to appreciate the value of others when your own self assessment is over valued.";
        strings[6] = "Don't cry because it's over, smile because it happened. - Dr. Seuss";
        strings[7] = "I'm selfish, impatient and a little insecure. I make mistakes, But if you can't handle me at my worst, then you sure as hell don't deserve me at my best.";
        strings[8] = "Be yourself; everyone else is already taken.― Oscar Wilde";
        strings[9] = "Two things are infinite: the universe and human stupidity; and I'm not sure about the universe.” \n" +
                "― Albert Einstein";
        strings[10] = "Be who you are and say what you feel, because those who mind don't matter, and those who matter don't mind.” \n" +
                "― Bernard M. Baruch";
        strings[11] = "You've gotta dance like there's nobody watching,\n" +
                "Love like you'll never be hurt,\n" +
                "Sing like there's nobody listening,\n" +
                "And live like it's heaven on earth.” \n" +
                "― William W. Purkey";
        strings[12] = "You only live once, but if you do it right, once is enough.” \n" +
                "― Mae West";
        strings[13] = "Be the change that you wish to see in the world.” \n" +
                "― Mahatma Gandhi";
        strings[14] = "In three words I can sum up everything I've learned about life: it goes on.” \n" +
                "― Robert Frost";




        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        type(strings[rand.nextInt(9)]);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);


    }

    private void rightClick()
    {
        robot.mousePress(InputEvent.BUTTON3_MASK);
        robot.delay(rand.nextInt(200));
        robot.mouseRelease(InputEvent.BUTTON3_MASK);
        robot.delay(rand.nextInt(200));
    }

    private void middleClick()
    {
        robot.mousePress(InputEvent.BUTTON2_MASK);
        robot.delay(rand.nextInt(200));
        robot.mouseRelease(InputEvent.BUTTON2_MASK);
        robot.delay(rand.nextInt(200));
    }

    private void type(int i)
    {
        robot.delay(rand.nextInt(20));
        robot.keyPress(i);
        robot.keyRelease(i);
    }

    private void type(String s)
    {
        byte[] bytes = s.getBytes();
        for (byte b : bytes)
        {
            int code = b;
            if (code > 96 && code < 123) code = code - 32;
            robot.delay(20);
            robot.keyPress(code);
            robot.keyRelease(code);
        }
    }
}
