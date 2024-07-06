import java.io.FileWriter;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class FoodiesFaveFoodCentre {
    public static String[] cashier1 = {"x", "x"};
    public static String[] cashier2 = {"x", "x", "x"};
    public static String[] cashier3 = {"x", "x", "x", "x", "x"};

    public static int burgersInStock = 50;


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String choice= " ";



        while((!choice.equals("999") && !choice.equals("EXIT"))) {

            if (burgersInStock <= 10) {
                System.out.println("Only 10 burgers left");
            }


            System.out.println("100 or VFQ: View all Queues.");
            System.out.println("101 or VEQ: View all Empty Queues.");
            System.out.println("102 or ACQ: Add customer to a Queue.");
            System.out.println("103 or RCQ: Remove a customer from a Queue.");
            System.out.println("104 or PCQ: Remove a served customer.");
            System.out.println("105 or VCS: View Customers Sorted in alphabetical order.");
            System.out.println("106 or SPD: Store Program Data into file.");
            System.out.println("107 or LPD: Load Program Data into file.");
            System.out.println("108 or STK: View Remaining burgers Stock.");
            System.out.println("109 or AFS: Add burgers to Stock.");
            System.out.println("999 or EXT: Exit the Program.");
            System.out.println(" ");

            System.out.println("Enter your choice: ");
            choice = input.next().toUpperCase();

            switch (choice) {
                case "100", "VFQ" -> ViewAllQueues();
                case "101", "VEQ" -> ViewAllEmptyQueue();
                case "102", "ACQ" -> AddCustomerToQueue();
                case "103", "RCQ" -> RemoveCustomerFromQueue();
                case "104", "PCQ" -> RemoveServedCustomer();
                case "105", "VCS" -> ViewCustomersSortedAlphabeticalOrder();
                case "106", "SPD" -> StoreProgramDataToFile();
                case "107", "LPD" -> LoadProgramDataToFile();
                case "108", "STK" -> ViewRemainingBurgersStock();
                case "109", "AFS" -> AddBurgersToStock();
                case "999", "EXT" -> ExitProgram();
                default -> System.out.println("Error");
            }
        }
}
    public static void ViewAllQueues(){
        System.out.println("**************");
        System.out.println("*  Cashiers  *");
        System.out.println("**************");

        for (int i = 0; i < cashier3.length; i++) {
            String option1;

            if (i < cashier1.length) {
                if (cashier1[i].equals("x")) {
                    option1 = "x";
                } else {
                    option1 = "0";
                }
            }else{
                option1 = " ";
            }

            String option2;
            if (i < cashier2.length) {
                if (cashier2[i].equals("x")) {
                    option2 = "x";
                } else {
                    option2 = "0";
                }
            }else{
                option2 = " ";
            }


            String option3;
            if (i < cashier3.length) {
                if (cashier3[i].equals("x")) {
                    option3 = "x";
                } else {
                    option3 = "0";
                }
            }else{
                option3 = " ";
            }
            System.out.printf("%-2s %-2s %-2s%n", option1, option2, option3);
        }

        System.out.println("");
        System.out.println("x-Not Occupied  0-Occupied");
        System.out.println("");

    }
    public static void ViewAllEmptyQueue(){
        System.out.println("**************");
        System.out.println("*  Cashiers  *");
        System.out.println("**************");

        for (int i = 0; i < cashier3.length; i++) {
            String option1;

            if (i < cashier1.length) {
                if (cashier1[i].equals("x")) {
                    option1 = "x";
                } else {
                    option1 = " ";
                }
            }else{
                option1 = " ";
            }

            String option2;
            if (i < cashier2.length) {
                if (cashier2[i].equals("x")) {
                    option2 = "x";
                } else {
                    option2 = " ";
                }
            }else{
                option2 = " ";
            }


            String option3;
            if (i < cashier3.length) {
                if (cashier3[i].equals("x")) {
                    option3 = "x";
                } else {
                    option3 = " ";
                }
            }else{
                option3 = " ";
            }
            System.out.printf("%-2s %-2s %-2s%n", option1, option2, option3);
        }


    }
    public static void AddCustomerToQueue() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter cashier number(1,2 or 3): ");
        int cashierNumber = input.nextInt();

        System.out.println("Enter Customer name: ");
        String customerName = input.next();
        System.out.println(" ");

        String[] choosenCashier;
        if (cashierNumber == 1) {
            choosenCashier = cashier1;
        } else if (cashierNumber == 2) {
            choosenCashier = cashier2;
        } else if (cashierNumber == 3) {
            choosenCashier = cashier3;
        } else {
            System.out.println("Invalid queue number.");
            return;
        }
        boolean added = false;
        for (int i = 0; i < choosenCashier.length; i++) {
            if (choosenCashier[i].equals("x")) {
                choosenCashier[i] = "0";
                added = true;
                break;
            }
        }

        if (added) {
            System.out.println("Customer added to queue");
            System.out.println("");

            burgersInStock = burgersInStock - 5;
        } else {
            System.out.println("The queue is full. Customer cannot be add.");
            System.out.println("");
        }
    }


    public static void RemoveCustomerFromQueue(){
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the queue number (1, 2, or 3): ");
        int cashierNo = input.nextInt();

        System.out.println("Enter the place to remove (Starting from place 1): ");
        int place = input.nextInt();
        System.out.println(" ");

        if(cashierNo == 1 && place > 0 && place < 3){
            if(place == 1) {
                if (cashier1[place-1].equals("0")) {
                    cashier1[place-1] = "x";
                    System.out.println("Customer removed from queue.");
                    System.out.println("");
                } else {
                    System.out.println("Customer not found at the place you entered.");
                    System.out.println("");
                }
            } else if(place == 2){
                if (cashier1[place - 1].equals("0")) {
                    cashier1[place - 1] = "x";
                    System.out.println("Customer removed from queue.");
                    System.out.println("");
                } else {
                    System.out.println("Customer not found at the place you entered.");
                    System.out.println("");
                }
            }
            for(int i = 0; i < cashier1.length - 1; i++){
                cashier1[i] = cashier1[i + 1];
            }
            cashier1[cashier1.length-1]="x";

        } else if(cashierNo == 2 && place > 0 && place < 4) {
            if (place == 1) {
                if (cashier2[place - 1].equals("0")) {
                    cashier2[place - 1] = "x";
                    System.out.println("Customer removed from queue.");
                    System.out.println("");
                } else {
                    System.out.println("Customer not found at the place you entered.");
                    System.out.println("");
                }
            }
            if (place == 2) {
                if (cashier2[place - 1].equals("0")) {
                    cashier2[place - 1] = "x";
                    System.out.println("Customer removed from queue.");
                    System.out.println("");
                } else {
                    System.out.println("Customer not found at the place you entered.");
                    System.out.println("");
                }
            }

            if (place == 3) {
                if (cashier2[place - 1].equals("0")) {
                    cashier2[place - 1] = "x";
                    System.out.println("Customer removed from queue.");
                    System.out.println("");
                } else {
                    System.out.println("Customer not found at the place you entered.");
                    System.out.println("");
                }
            }
            for (int i = 0; i < cashier2.length - 1; i++) {
                cashier2[i] = cashier2[i + 1];
            }
            cashier2[cashier2.length - 1] = "x";

        }else if(cashierNo == 3 && place > 0 && place < 6) {
            if (place == 1) {
                if (cashier3[place - 1].equals("0")) {
                    cashier3[place - 1] = "x";
                    System.out.println("Customer removed from queue.");
                    System.out.println("");
                } else {
                    System.out.println("Customer not found at the place you entered.");
                    System.out.println("");
                }
            }
            if (place == 2) {
                if (cashier3[place - 1].equals("0")) {
                    cashier3[place - 1] = "x";
                    System.out.println("Customer removed from queue.");
                    System.out.println("");
                } else {
                    System.out.println("Customer not found at the place you entered.");
                    System.out.println("");
                }
            }

            if (place == 3) {
                if (cashier3[place - 1].equals("0")) {
                    cashier3[place - 1] = "x";
                    System.out.println("Customer removed from queue.");
                    System.out.println("");
                } else {
                    System.out.println("Customer not found at the place you entered.");
                    System.out.println("");
                }
            }
            if (place == 4) {
                if (cashier3[place - 1].equals("0")) {
                    cashier3[place - 1] = "x";
                    System.out.println("Customer removed from queue.");
                    System.out.println("");
                } else {
                    System.out.println("Customer not found at the place you entered.");
                    System.out.println("");
                }
            }
            if (place == 5) {
                if (cashier3[place - 1].equals("0")) {
                    cashier3[place - 1] = "x";
                    System.out.println("Customer removed from queue.");
                    System.out.println("");
                } else {
                    System.out.println("Customer not found at the place you entered.");
                    System.out.println("");
                }
            }
            for (int i = 0; i < cashier3.length - 1; i++) {
                cashier3[i] = cashier3[i + 1];
            }
            cashier3[cashier3.length - 1] = "x";

        }
    }
    public static void RemoveServedCustomer() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the cashier number (1, 2, or 3): ");
        int cashierNo = input.nextInt();

        if (cashierNo == 1) {
            if (cashier1[0].equals("x")) {
                System.out.println("No customer to serve.");
            } else {
                burgersInStock -= 5;
            }
            cashier1[0] = "x";
            for (int i = 0; i < (cashier1.length - 1); i++) {
                cashier1[i] = cashier1[i + 1];
            }
            cashier1[cashier1.length - 1] = "x";
        } else if (cashierNo == 2) {
            if (cashier2[0].equals("x")) {
                System.out.println("No customer to serve.");
            } else {
                burgersInStock -= 5;
            }
            cashier2[0] = "x";
            for (int i = 0; i < (cashier2.length - 1); i++) {
                cashier2[i] = cashier2[i + 1];
            }
            cashier2[cashier2.length - 1] = "x";
        } else if (cashierNo == 3) {
            if (cashier3[0].equals("x")) {
                System.out.println("No customer to serve.");
            } else {
                burgersInStock -= 5;
            }
            cashier3[0] = "x";
            for (int i = 0; i < (cashier3.length - 1); i++) {
                cashier3[i] = cashier3[i + 1];
            }
            cashier3[cashier3.length - 1] = "x";
        }
    }

     public static void ViewCustomersSortedAlphabeticalOrder(){
         System.out.println("******");
         System.out.println("* Sorted Customers *");
         System.out.println("******");

         String[] Customers = new String[15];
         int index = 0;

         for (String customer : cashier1) {
             if (!customer.equals("x")) {
                 Customers[index++] = customer;
             }
         }

         for (String customer : cashier2) {
             if (!customer.equals("x")) {
                 Customers[index++] = customer;
             }
         }

         for (String customer : cashier3) {
             if (!customer.equals("x")) {
                 Customers[index++] = customer;
             }
         }

         // Sort the customers in alphabetical order
         for (int i = 0; i < index - 1; i++) {
             for (int j = i + 1; j < index; j++) {
                 if (Customers[i].compareToIgnoreCase(Customers[j]) > 0) {
                     String temp = Customers[i];
                     Customers[i] = Customers[j];
                     Customers[j] = temp;
                 }
             }
         }

         for (int i = 0; i < index; i++) {
             System.out.println(Customers[i]);
         }

         System.out.println();
     }

    public static void StoreProgramDataToFile(){
        try {
            FileWriter myfWriter = new FileWriter("Food Center Data.txt");

            myfWriter.write("**************");
            myfWriter.write("*  Cashiers  *");
            myfWriter.write("**************\n");

            for (int i = 0; i < cashier3.length; i++) {
                String option1;

                if (i < cashier1.length) {
                    if (cashier1[i].equals("x")) {
                        option1 = "x";
                    } else {
                        option1 = "0";
                    }
                }else{
                    option1 = " ";
                }

                String option2;
                if (i < cashier2.length) {
                    if (cashier2[i].equals("x")) {
                        option2 = "x";
                    } else {
                        option2 = "0";
                    }
                }else{
                    option2 = " ";
                }


                String option3;
                if (i < cashier3.length) {
                    if (cashier3[i].equals("x")) {
                        option3 = "x";
                    } else {
                        option3 = "0";
                    }
                }else{
                    option3 = " ";
                }
                myfWriter.write(String.format("%-2s %-2s %-2s%n", option1, option2, option3));
            }

            myfWriter.write("");
            myfWriter.write("x-Not Occupied  0-Occupied");
            myfWriter.write("");

            myfWriter.close(); //Close the connection between the code & the file

        }catch(Exception e){
            System.out.println(e);
        }

    }
    public static void LoadProgramDataToFile(){
        try{
            File myFile = new File("Food Center Data.txt");
            Scanner readFile = new Scanner(myFile);
            while(readFile.hasNextLine()){
                String data = readFile.nextLine();
                System.out.println(data);
            }
            readFile.close();

        }catch(Exception e){
            System.out.println(e);
        }
    }
    public static void ViewRemainingBurgersStock(){

        System.out.println(burgersInStock);
    }
    public static void AddBurgersToStock(){
        System.out.println("****Adding burgers to the stock****");
        if(burgersInStock == 50){
            System.out.println("Burger stock is full.");
            System.out.println("");
        }
        else if(burgersInStock<50){
            Scanner input = new Scanner(System.in);
            System.out.println("How many Burgers do you want to add?");
            int newBurgers = input.nextInt();
            burgersInStock+=newBurgers;
        }

    }
    public static void ExitProgram(){
        System.out.println("Exit");
        System.exit(0);

    }
}



