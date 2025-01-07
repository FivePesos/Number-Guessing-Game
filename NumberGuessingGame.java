import java.util.*;

public class NumberGuessingGame{
    
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        boolean mainMenu = gameMainMenuInterface(scan);

        if(mainMenu){
            mainGame();
        }else{
            System.out.println("Exiting random guessing game.");
        }
    }

    public static boolean gameMainMenuInterface(Scanner scan){
        int response;
        System.out.print("\033[H\033[2J");
        System.out.println("============================================================");
        System.out.println("                WELCOME TO THE GUESSING GAME                ");
        System.out.println("                  By: John Paul B. Singco                   ");
        System.out.println("                A Computer Science Student                  ");
        System.out.println("============================================================");
        System.out.println("                         1. Play                            ");
        System.out.println("                         2. Exit                            ");
        System.out.println("            *Note: Enter 1 to play or 2 to Exit*            ");

        System.out.print("Select Choice: ");
        
        while(!scan.hasNextInt()){
            
            System.out.print("\033[H\033[2J");
            System.out.println("============================================================");
            System.out.println("                WELCOME TO THE GUESSING GAME                ");
            System.out.println("                  By: John Paul B. Singco                   ");
            System.out.println("                A Computer Science Student                  ");
            System.out.println("============================================================");
            System.out.println("                         1. Play                            ");
            System.out.println("                         2. Exit                            ");
            System.out.println("            *Note: Enter 1 to play or 2 to Exit*            ");

            System.out.print("Select Choice: ");
            scan.next();
        }
        
        response = scan.nextInt();

        while(response > 2 || response < 1){
            System.out.print("\033[H\033[2J");
            System.out.println("============================================================");
            System.out.println("                WELCOME TO THE GUESSING GAME                ");
            System.out.println("                  By: John Paul B. Singco                   ");
            System.out.println("                A Computer Science Student                  ");
            System.out.println("============================================================");
            System.out.println("                         1. Play                            ");
            System.out.println("                         2. Exit                            ");
            System.out.println("            *Note: Enter 1 to play or 2 to Exit*            ");

            System.out.print("Select Choice: ");
            response = scan.nextInt();
        }
        scan.nextLine();
        
        if(response == 1){
            return true;
        }
        return false;
    }
    
    static void  mainGame(){
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();

        int response = 0, max = 100, min = 1, randomNum = rand.nextInt(max - min + 1) + min;
        
        System.out.print("\033[H\033[2J");
        System.out.println("Please select the difficulty level: ");
        System.out.println("1. Easy (10 chances)");
        System.out.println("2. Medium (5 chances)");
        System.out.println("3. Hard (3 chances)");

        System.out.print("Enter your choice: ");

        while(!scan.hasNextInt()){
            System.out.print("\033[H\033[2J");
            System.out.println("Please select the difficulty level: ");
            System.out.println("1. Easy (10 chances)");
            System.out.println("2. Medium (5 chances)");
            System.out.println("3. Hard (3 chances)");

            System.out.println("Enter your choice: ");
            scan.next();
        }
        response = scan.nextInt();

        switch (response) {
            case 1:
                randomGame(response, randomNum);
                break;
            case 2:
                randomGame(response, randomNum);
                break;

            case 3:
                randomGame(response, randomNum);
                break;
        }
    }

    static void randomGame(int dif, int randomNum){

        Scanner scan = new Scanner(System.in);

        final int easyMode = 10;
        final int medMode = 5;
        final int hardMode = 3;
        int numOfAttempts = 0, response = 0, mode = 0;

        System.out.print("\033[H\033[2J");

        if(dif == 1){
            System.out.println("Great! You have selected the Easy difficulty level.");
            System.out.println("I'm thinking of a number between 1 and 100.");
            System.out.println("You have " + easyMode + " chances to guess the correct number.");
            System.out.println("Let's start the game!");
            mode = easyMode;
        }else if(dif == 2){
            System.out.println("Great! You have selected the Medium difficulty level.");
            System.out.println("I'm thinking of a number between 1 and 100.");
            System.out.println("You have " + medMode + " chances to guess the correct number.");
            System.out.println("Let's start the game!");
            mode = medMode;
        }else if(dif == 3){
            System.out.println("Great! You have selected the Hard difficulty level.");
            System.out.println("I'm thinking of a number between 1 and 100.");
            System.out.println("You have " + hardMode + " chances to guess the correct number.");
            System.out.println("Let's start the game!");
            mode = hardMode;
        }

        do{
            System.out.print("Enter your guess: ");

            while(!scan.hasNextInt()){
                System.out.print("Enter a number: ");
                scan.next();
            }

            response = scan.nextInt();

            if(response > randomNum){
                System.out.println("Incorrect! The number is less than " + response);
                numOfAttempts++;
            }else if(response < randomNum){
                System.out.println("Incorrect! The number is more than " + response);
                numOfAttempts++;
            }

            if(numOfAttempts == mode){
                System.out.println("Game Over! You have attempted " + mode + " times");
                break;
            }

        }while(response != randomNum);

        if(response == randomNum){
            System.out.println("Congratulations! You guessed the correct number in " + numOfAttempts + " attempts.");  
        }
        
        System.out.println("Would you like to continue");
        System.out.println("1. Yes");
        System.out.println("2. No");
        System.out.print("Select choice: ");

        while(!scan.hasNextInt()){
            System.out.print("Please enter number: ");
            scan.next();
        }
        response = scan.nextInt();

        while(response < 1 || response > 2){
            System.out.println("Would you like to continue");
            System.out.println("1. Yes");
            System.out.println("2. No");
            System.out.print("Select choice: ");
            response = scan.nextInt();
        }

        if(response == 1){
            mainGame();
        }else{
            System.out.println("Exiting random guessing game.");
        }
    }
}