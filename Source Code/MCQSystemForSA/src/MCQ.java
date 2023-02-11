import java.util.Scanner;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;


public class MCQ {

    public void Questions(String CSV, String userName) throws Exception {
        int userScore = 0;
        int Justified = 0;
        Scanner sc = new Scanner(System.in);
        String line;
        FileReader fr = new FileReader("src/MCQ/" + CSV + ".csv");
        BufferedReader br = new BufferedReader(fr);
        while ((line = br.readLine()) != null) {
            String[] mcqStr = line.split(",");
            List<String> listMcqStr = Arrays.asList(mcqStr);

            System.out.println(listMcqStr.get(0));

            for (int i = 1; i < 5; i++) {
                System.out.println(listMcqStr.get(i));
            }

            // Display User Answer
            System.out.print("Your Answer is : ");
            String userAnswer = sc.nextLine().toUpperCase();

            boolean validAnswer = false;

            while (!validAnswer) {
                if (userAnswer.equals("A") || userAnswer.equals("B") || userAnswer.equals("C") || userAnswer.equals("D")) {
                    validAnswer = true;
                } else {
                    System.out.println("Please select the appropriate Option.");
                    System.out.print("Your Answer : ");
                    userAnswer = sc.nextLine().toUpperCase();
                }
            }


            // Checking if the user answer is correct or wrong

            System.out.println("\nYour Answer is : " + userAnswer);
            String correctAnswer = listMcqStr.get(5);

            if (userAnswer.equals(correctAnswer.substring(0, 1))) {
                System.out.println("You have answered correct!");
                userScore++;
            } else {
                System.out.println("Wrong Answer. The Correct Answer is " + correctAnswer);
                Justified++;
            }
            System.out.println();
        }

        System.out.println(userName + ", you have answered " + userScore + " MCQ Right, " + Justified
                + " MCQ Wrong for a Total of 10 MCQ. You have scored " + (userScore * 10) + "%");
    }

}