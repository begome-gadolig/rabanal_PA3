import java.security.SecureRandom;
import java.util.Scanner;

public class CAIArithmeticApp {
    public static final int questionsPerSession = 10;
    public static Scanner in;
    public static SecureRandom secureRandom;

    public static void main(String[] args) {
        in = new Scanner(System.in);
        secureRandom = new SecureRandom();

        while (true) {
            int difficultyLevel = determineDifficultyLevel();
            int problemType = determineProblemType();

            int answersCorrect = 0;
            for (int j = 0; j < questionsPerSession; j++) {
                if (generateQuestion(difficultyLevel, problemType) == true) {
                    answersCorrect++;
                }
            }
            System.out.println("Correct: " + answersCorrect + " Incorrect: " + (questionsPerSession - answersCorrect));
            if (answersCorrect / (double)questionsPerSession >= 0.75) {
                System.out.println("Congratulations, you are ready to go to the next level!");
            }
            else {
                System.out.println("Please ask your teacher for extra help.");
            }

            System.out.println("Do you wish to begin a new session? (Y/N):");
            if (in.next().toUpperCase().charAt(0) == 'N') {
                break;
            }
        }
    }

    public static int determineDifficultyLevel() {
        System.out.println("Please choose a difficulty level from 1 to 4 (inclusive):");
        return in.nextInt();
    }

    public static int determineProblemType() {
        System.out.println("Please choose a a type of arithmetic problem to study. 1=addition, 2=multiplication, 3=subtraction, 4=division, 5=random mixture of all four:");
        return in.nextInt();
    }

    public static boolean generateQuestion(int difficultyLevel, int problemType) {
        int x = secureRandom.nextInt((int)Math.pow(10, difficultyLevel) - 1) + 1;
        int y = secureRandom.nextInt((int)Math.pow(10, difficultyLevel) - 1) + 1;

        if (problemType == 5) {
            problemType = secureRandom.nextInt(4) + 1;
        }

        double solution = 0;
        switch (problemType) {
            case 1:
                System.out.println("How much is " + x + " plus " + y + "?");
                solution = x + y;
                break;
            case 2:
                System.out.println("How much is " + x + " times " + y + "?");
                solution = x * y;
                break;
            case 3:
                System.out.println("How much is " + x + " minus " + y + "?");
                solution = x - y;
                break;
            case 4:
                System.out.println("How much is " + x + " divided by " + y + "?");
                solution = x / (double)y;
                break;
        }
        double answer = in.nextDouble();
        boolean answerIsCorrect = Math.abs(solution - answer) < 0.00000001;
        generateResponse(answerIsCorrect);
        return answerIsCorrect;
    }

    public static void generateResponse(boolean answerIsCorrect) {
        if (answerIsCorrect) {
            switch (secureRandom.nextInt(4) + 1) {
                case 1:
                    System.out.println("Very good!");
                    break;
                case 2:
                    System.out.println("Excellent!");
                    break;
                case 3:
                    System.out.println("Nice work!");
                    break;
                case 4:
                    System.out.println("Keep up the good work!");
                    break;
            }
        }
        else {
            switch (secureRandom.nextInt(4) + 1) {
                case 1:
                    System.out.println("No. Please try again.");
                    break;
                case 2:
                    System.out.println("Wrong. Try once more.");
                    break;
                case 3:
                    System.out.println("Don’t give up!");
                    break;
                case 4:
                    System.out.println("No. Keep trying.");
                    break;
            }
        }
    }
}
