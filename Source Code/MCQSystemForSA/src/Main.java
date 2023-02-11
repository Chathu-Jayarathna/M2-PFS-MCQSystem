import java.util.Scanner;
import java.io.File;


public class Main {
    public static void main(String[] args) throws Exception {
        MCQ mcq = new MCQ();
        //Input  by scanner
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your name : ");
        String inputUserName = input.nextLine();

        //DISPLAY WELCOME MESSAGE + USERNAME
        System.out.println("Welcome "+inputUserName);
        System.out.println();
        System.out.println("\nChoose your MCQ Set. The Options are : ");

        // get File name
        File folder = new File("src/MCQ");
        File[] listOfFiles = folder.listFiles();
        if (listOfFiles != null) {
            crateFilesName(listOfFiles);
        }

        // Take user input to MCQ set question
        System.out.print("Type your choice- as they are written : ");
        String inputUserChoice = input.nextLine();
        boolean mcqSetsNotExist = true;

        while (mcqSetsNotExist) {
            if (listOfFiles != null) {
                for (File listOfFile : listOfFiles) {
                    String fileName = listOfFile.getName();
                    int extension = fileName.lastIndexOf(".");
                    if (extension > 0) {
                        fileName = fileName.substring(0, extension).toLowerCase();
                        if (fileName.equals(inputUserChoice.toLowerCase())) {
                            mcq.Questions(inputUserChoice, inputUserName);
                            mcqSetsNotExist = false;
                        }
                    }
                }
            }
            if (mcqSetsNotExist) {
                System.out.println("Please type valid MCQ");
                System.out.print("Type your choice- as they are written : ");
                inputUserChoice = input.nextLine();
            }
        }

    }

    private static void crateFilesName(File[] listOfFiles) {
        for (File listOfFile : listOfFiles) {
            String fileName = listOfFile.getName();
            int extension = fileName.lastIndexOf(".");
            if (extension > 0) {
                fileName = fileName.substring(0, extension);
                if (listOfFile.isFile()) {
                    System.out.println(fileName.toLowerCase());
                }
            }
        }
    }

}
