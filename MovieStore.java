import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.AbstractMap.SimpleEntry;
import java.util.Collections;
import java.util.Comparator;

public class MovieStore{
    private static String currentAccount;
    static ArrayList<SimpleEntry<String, String>> accounts = new ArrayList<>(Arrays.asList(
            new SimpleEntry<>("Shakif", "1234")
    ));
    static ArrayList<SimpleEntry<String, Integer>> inventory = new ArrayList<>();
    static ArrayList<SimpleEntry<String, Integer>> action = new ArrayList<>(Arrays.asList(
            new SimpleEntry<>("Superman", 500),
            new SimpleEntry<>("Fantastic 4", 500),
            new SimpleEntry<>("The Batman", 300),
            new SimpleEntry<>("The Fast and Furious", 250),
            new SimpleEntry<>("Twisters", 200)
    ));
    static ArrayList<SimpleEntry<String, Integer>> comedy = new ArrayList<>(Arrays.asList(
            new SimpleEntry<>("The Nice Guys", 500),
            new SimpleEntry<>("The Big Lebowski", 500),
            new SimpleEntry<>("Groundhog Day", 300),
            new SimpleEntry<>("Meet the Parents", 250),
            new SimpleEntry<>("Click", 200)
            ));
    static ArrayList<SimpleEntry<String, Integer>> romance = new ArrayList<>(Arrays.asList(
            new SimpleEntry<>("The Notebook", 500),
            new SimpleEntry<>("Love Actually", 450),
            new SimpleEntry<>("Crazy, Stupid, Love", 400),
            new SimpleEntry<>(" After", 150),
            new SimpleEntry<>("Twilight", 100)
            ));
    static ArrayList<SimpleEntry<String, Integer>> horror = new ArrayList<>(Arrays.asList(
            new SimpleEntry<>("IT", 500),
            new SimpleEntry<>("The Conjuring", 500),
            new SimpleEntry<>("Texas Chainsaw Massacre", 300),
            new SimpleEntry<>("Five Night at Freddy's", 250),
            new SimpleEntry<>("Birdemic", 200)
    ));
    static ArrayList<SimpleEntry<String, Integer>> thriller = new ArrayList<>(Arrays.asList(
            new SimpleEntry<>("Who Killed Captain Alex", 1000),
            new SimpleEntry<>("Psycho", 500),
            new SimpleEntry<>("The Silence of the Lambs", 500),
            new SimpleEntry<>("Pulp Fiction", 350),
            new SimpleEntry<>("Doom", 200)

    ));

    public static void sortArray(ArrayList<SimpleEntry<String, Integer>> list){
        Collections.sort(action, new Comparator<SimpleEntry<String, Integer>>() {
            @Override
            public int compare(SimpleEntry<String, Integer> o1, SimpleEntry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
    }

    public static void addAction(String name, int price){
        action.add(new SimpleEntry<>(name, price));
        System.out.println("New Movie added successfully.");
        System.out.println();
        sortArray(action);
        firstScreen();
    }

    public static void addComedy(String name, int price){
        comedy.add(new SimpleEntry<>(name, price));
        System.out.println("New Movie added successfully.");
        System.out.println();
        sortArray(comedy);
        firstScreen();
    }

    public static void addRomance(String name, int price){
        romance.add(new SimpleEntry<>(name, price));
        System.out.println("New Movie added successfully.");
        System.out.println();
        sortArray(romance);
        firstScreen();
    }

    public static void addHorror(String name, int price){
        horror.add(new SimpleEntry<>(name, price));
        System.out.println("New Movie added successfully.");
        System.out.println();
        sortArray(horror);
        firstScreen();
    }

    public static void addThriller(String name, int price){
        thriller.add(new SimpleEntry<>(name, price));
        System.out.println("New Movie added successfully.");
        System.out.println();
        sortArray(thriller);
        firstScreen();
    }

    public static void updateMovies(ArrayList<SimpleEntry<String, Integer>> list, int option, int price){
        int number = 1;
        for (int i = 0; i < list.size(); i++) {
            SimpleEntry<String, Integer> entry = list.get(i);
            if (option == number) {
                list.set(i, new SimpleEntry<>(entry.getKey(), price));
                System.out.println("Price updated successfully.");
                sortArray(list);
                firstScreen();
            }
            number++;
        }
    }

    public static void deleteMovies(ArrayList<SimpleEntry<String, Integer>> list, int option){
        int number = 1;
        for (int i = 0; i < list.size(); i++) {
            SimpleEntry<String, Integer> entry = list.get(i);
            if (option == number) {
                list.remove(i);
                System.out.println("Movie Removed successfully.");
                System.out.println();
                changeMovies();
            }
            number++;
        }
    }

    public static void printArrayList(ArrayList<SimpleEntry<String, Integer>> list) {
        int number = 1;
        for (SimpleEntry<String, Integer> entry : list) {
            System.out.println(number + ". " + entry.getKey() + ", Price: " + entry.getValue());
            number++;
        }
    }

    public static void printGenre(){
        int number = 1;
        for (Genre genre : Genre.values()){
            System.out.println(number+". "+genre);
            number++;
        }
    }

    public static void buyMovie(ArrayList<SimpleEntry<String, Integer>> list, int option){
        Scanner input = new Scanner(System.in);
        int number = 1;
        for (SimpleEntry<String, Integer> entry : list) {
            if(option == number) {
                System.out.println("Buying Movie:" + entry.getKey() + ", For price: " + entry.getValue());
                System.out.println("Enter Bkash Number (Type CANCEL to cancel): ");
                String bkash = input.nextLine();
                if (bkash.equals("CANCEL")) {
                    genre();
                }
                else if (bkash.length() == 11) {
                    System.out.print("Enter bkash PIN number: ");
                    String pin = input.nextLine();
                    if (pin.length() == 5){
                        inventory.add(new SimpleEntry<>(entry.getKey(), entry.getValue()));
                        System.out.println("Movie "+ entry.getKey() +" Successfully Bought for "
                                +entry.getValue()+" Taka.");
                        System.out.println();
                        firstScreen();
                    }
                    else{
                        System.out.println("Invalid PIN.");
                        System.out.println();
                        buyMovie(list, option);
                    }
                }
                else {
                    System.out.println("Invalid Number.");
                    System.out.println();
                    buyMovie(list, option);
                }
            }
            number++;
        }
    }

    public static void updateAccountName(String name){
        for (int i = 0; i < accounts.size(); i++) {
            SimpleEntry<String, String> entry = accounts.get(i);
            if (entry.getKey().equals(currentAccount)) {
                accounts.set(i, new SimpleEntry<>(name, entry.getValue()));
                System.out.println("Username updated successfully.");
                firstScreen();
            }
        }
    }

    public static void updatePassword(String pass){
        for (int i = 0; i < accounts.size(); i++) {
            SimpleEntry<String, String> entry = accounts.get(i);
            if (entry.getKey().equals(currentAccount)) {
                accounts.set(i, new SimpleEntry<>(entry.getKey(), pass));
                System.out.println("Password updated successfully.");
                firstScreen();
            }
        }
    }

    public static void accountInfo(){
        System.out.println("Username: "+currentAccount);
        System.out.println("Movies bought: ");
        int number = 1;
        for (SimpleEntry<String, Integer> entry : inventory) {
            System.out.println(number + ". " + entry.getKey());
            number++;
        }
        int total = 0;

        for (SimpleEntry<String, Integer> entry : inventory) {
            total += entry.getValue();
        }
        System.out.println("Total money spent: "+total+" Taka");
        System.out.println();
        firstScreen();
    }

    public static void deleteAccount(){
        for (int i = 0; i < accounts.size(); i++) {
            SimpleEntry<String, String> entry = accounts.get(i);
            if (entry.getKey().equals(currentAccount)) {
                accounts.remove(i);
                System.out.println("Account deleted successfully.");
                System.out.println();
                loginScreen();
                break;
            }
        }
    }

    public static void firstScreen(){
        Scanner input = new Scanner(System.in);
        System.out.printf("1. Select Movie %n2. Add/Update Movies %n3. Change Username %n4. Change Password " +
                " %n5. Account Info %n6. Logout %n7. Delete Account %nEnter number(1-6): ");
        int option = input.nextInt();
        System.out.println();
        if(option == 1) genre();
        else if(option == 2){
            System.out.println("Only employees can add or update movies.");
            System.out.println("Enter Employee Key: ");
            String trash = input.nextLine();
            String employeeKey = input.nextLine();
            if(employeeKey.equals("Movie1234")) changeMovies();
            else{
                System.out.println("Incorrect Employee Key");
                System.out.println();
                firstScreen();
            }
        }
        else if(option == 3){
            System.out.print("Enter New Username: ");
            String trash = input.nextLine();
            String name = input.nextLine();
            updateAccountName(name);
        }
        else if(option == 4){
            System.out.print("Enter New Password: ");
            input.nextLine();
            String pass = input.nextLine();
            updatePassword(pass);
        }
        else if(option == 5) accountInfo();
        else if(option == 6) loginScreen();
        else if(option == 7) {
            System.out.print("Warning! Your account will be deleted and you will be logged out."+
                    "\n1. Delete Account \n2.Cancel \nEnter number(1-2): ");
            int option2 = input.nextInt();
            if(option2 == 1) deleteAccount();
            else firstScreen();
        }
        else{
            System.out.println("Invalid Input.");
            System.out.println();
            firstScreen();
        }
    }

    public static void changeMovies(){
        Scanner input = new Scanner(System.in);
        System.out.printf("1. Add Movies %n2. Update Movie Price %n3. Remove Movie" +
                " %n4. Back %nEnter number(1-4): ");
        int option = input.nextInt();
        if(option == 1){
            System.out.print("Enter movie name: ");
            String trash = input.nextLine();
            String name = input.nextLine();
            System.out.print("Enter movie price: ");
            int price = input.nextInt();
            System.out.println("Select Genre: ");
            printGenre();
            System.out.print("Enter number(1-6): ");
            int option2 = input.nextInt();
            System.out.println();
            if(option2 == 1) addAction(name, price);
            else if(option2 == 2) addComedy(name, price);
            else if(option2 == 3) addRomance(name, price);
            else if(option2 == 4) addHorror(name, price);
            else if(option2 == 5) addThriller(name, price);
            else if(option2 == 6) changeMovies();
            else{
                System.out.println("Invalid Input.");
                changeMovies();
            }
        }
        else if(option == 2){
            System.out.println("Select Genre: ");
            printGenre();
            System.out.print("Enter number(1-6): ");
            int option2 = input.nextInt();
            if(option2 == 1) {
                printArrayList(action);
                System.out.print("Enter number: ");
                int option3 = input.nextInt();
                System.out.print("Enter new price: ");
                int price = input.nextInt();
                updateMovies(action, option3, price);
            }
            else if(option2 == 2) {
                printArrayList(comedy);
                System.out.print("Enter number: ");
                int option3 = input.nextInt();
                System.out.print("Enter new price: ");
                int price = input.nextInt();
                updateMovies(comedy, option3, price);
            }
            else if (option2 == 3) {
                printArrayList(romance);
                System.out.print("Enter number: ");
                int option3 = input.nextInt();
                System.out.print("Enter new price: ");
                int price = input.nextInt();
                updateMovies(romance, option3, price);
            }
            else if(option2 == 4) {
                printArrayList(horror);
                System.out.print("Enter number: ");
                int option3 = input.nextInt();
                System.out.print("Enter new price: ");
                int price = input.nextInt();
                updateMovies(horror, option3, price);
            }
            else if(option2 == 5) {
                printArrayList(thriller);
                System.out.print("Enter number: ");
                int option3 = input.nextInt();
                System.out.print("Enter new price: ");
                int price = input.nextInt();
                updateMovies(thriller, option3, price);
            }
            else if(option2 == 6) {
                changeMovies();
            }
            else{
                System.out.println("Invalid Input.");
                changeMovies();
            }
        }
        else if(option == 3){
            System.out.println("Select Genre: ");
            printGenre();
            System.out.print("Enter number(1-6): ");
            int option2 = input.nextInt();
            if(option2 == 1) {
                printArrayList(action);
                System.out.print("Enter number: ");
                int option3 = input.nextInt();
                deleteMovies(action, option3);
            }
            else if(option2 == 2) {
                printArrayList(comedy);
                System.out.print("Enter number: ");
                int option3 = input.nextInt();
                deleteMovies(comedy, option3);
            }
            else if (option2 == 3) {
                printArrayList(romance);
                System.out.print("Enter number: ");
                int option3 = input.nextInt();
                deleteMovies(romance, option3);
            }
            else if(option2 == 4) {
                printArrayList(horror);
                System.out.print("Enter number: ");
                int option3 = input.nextInt();
                deleteMovies(horror, option3);
            }
            else if(option2 == 5) {
                printArrayList(thriller);
                System.out.print("Enter number: ");
                int option3 = input.nextInt();
                deleteMovies(thriller, option3);
            }
            else if(option2 == 6) {
                changeMovies();
            }
            else{
                System.out.println("Invalid Input.");
                changeMovies();
            }
        }
        else if(option == 4){
            firstScreen();
        }
        else{
            System.out.println("Invalid Input.");
            changeMovies();
        }
    }

    public static void genre(){
        Scanner input = new Scanner(System.in);
        System.out.println("Select Genre: ");
        printGenre();
        System.out.print("Enter number(1-6): ");
        int option = input.nextInt();
        System.out.println();
        if(option == 1) {
            printArrayList(action);
            System.out.print("Enter number: ");
            int option2 = input.nextInt();
            buyMovie(action, option2);
        }
        if(option == 2){
            printArrayList(comedy);
            System.out.print("Enter number: ");
            int option2 = input.nextInt();
            buyMovie(comedy, option2);
        }
        if(option == 3){
            printArrayList(romance);
            System.out.print("Enter number: ");
            int option2 = input.nextInt();
            buyMovie(romance, option2);
        }
        if(option == 4){
            printArrayList(horror);
            System.out.print("Enter number: ");
            int option2 = input.nextInt();
            buyMovie(horror, option2);
        }
        if(option == 5){
            printArrayList(thriller);
            System.out.print("Enter number: ");
            int option2 = input.nextInt();
            buyMovie(thriller, option2);
        }
        if(option == 6) firstScreen();
    }

    public static void login(){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Username: ");
        String name = input.nextLine();
        System.out.print("Enter Password: ");
        String pass = input.nextLine();
        boolean accfound = false;
        for (SimpleEntry<String, String> i : accounts) {
            if (i.getKey().equals(name) && i.getValue().equals(pass)) {
                accfound = true;
                break;
            }
        }
        if(accfound){
            currentAccount = name;
            firstScreen();
        }
        else{
            System.out.println("Incorrect Username or Password.");
            loginScreen();
        }
    }

    public static void createAccount(){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Username: ");
        String name = input.nextLine();
        System.out.print("\nEnter Password: ");
        String pass = input.nextLine();
        accounts.add(new SimpleEntry<>(name, pass));
        loginScreen();
    }

    public static void loginScreen(){
        Scanner input = new Scanner(System.in);
        System.out.printf("Select Option: %n1. Login %n2. Create Account %n3. Exit " +
                "%nEnter number(1-3): ");
        int option = input.nextInt();
        if(option==1){
            login();
        }
        else if (option==2) {
            createAccount();
        }
        else if (option==3) {
            return;
        }
        else {
            System.out.println("Invalid Input.");
            loginScreen();
        }
    }



    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        loginScreen();
    }
}