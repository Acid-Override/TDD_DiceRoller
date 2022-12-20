import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class Roller
{
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();

    int total = 0;
    int roll;

    public static final int WINNING_SCORE = 3;
    public static final int DEATH_ROLL = 6;
    public static final int SCORE_ROLL = 4;
    public static final int DEATH_SCORE = -1;

    public static final String QUIT = "q";
    public static final String ROLL = "r";

    public static final String BEGINNING_PROMPT = "Hit any key to roll or 'q' to quit";
    public static final String ROLLED = "You rolled a ";
    public static final String YOU_WON = "You won!";
    public static final String YOU_LOST = "You lost!";
    public static final String SEE_YOU_LATER = "See you later!";
    public static final String CURRENT_SCORE = "Current score: ";


    String message = "";

    public String getUserInput()
    {
        return (scanner.next()).toLowerCase(Locale.ROOT);
    }

    public int rollDie(int dieSize)
    {
        return random.nextInt(dieSize) + 1;
    }

    public int rollD6()
    {
        return rollDie(6);
    }

    public boolean rollLogic(int roll)
    {
        if(roll == DEATH_ROLL)
        {
            setTotal(-1);
            return false;
        }
        else if (roll == SCORE_ROLL)
        {
            setTotal(getTotal() + 1);
            if(total >= 3)
            {
                return false;
            }
        }

        return true;
    }

    public void output(String message)
    {
        System.out.println(message);
    }

    public boolean gameLogic(String letter)
    {
        if(letter.equals(QUIT))
        {
            return false;
        }

        return true;
    }

    public void didIWin()
    {
        if(getTotal() == DEATH_SCORE)
        {
            output(YOU_LOST);
        }
        else if(getTotal() == WINNING_SCORE)
        {
            output(YOU_WON);
        }
        else
        {
            output(SEE_YOU_LATER);
        }
    }

    public int getTotal()
    {
        return total;
    }

    public void setTotal(int total)
    {
        this.total = total;
    }

    public void gameLoop()
    {
        output(BEGINNING_PROMPT);
        boolean shouldContinue = true;

        do
        {
            shouldContinue = gameLogic(getUserInput());
            roll = rollD6();
            output(ROLLED + roll);
            shouldContinue = rollLogic(roll);
            output(CURRENT_SCORE + getTotal());

        }while(shouldContinue);

        didIWin();
    }

    public static void main(String[] args)
    {
        Roller roller = new Roller();
        roller.gameLoop();
    }
}
