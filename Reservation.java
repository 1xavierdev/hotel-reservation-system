/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package reservation;

import java.util.Scanner;
import java.io.*;
import java.util.Arrays;
import java.util.ArrayList;

/**
 *
 * @author xaviermckenzie
 */

/**
 *  The Reservation class represents a hotel reservation It stores the first name, last name,
 * number of nights, and daily rate for a hotel reservation.
 *
 */



public class Reservation {

    private String first;
    private String last;
    private int nights;
    private float dailyrate;
/**
     * Constructs a new Reservation object with the specified details.
     * @param f The first name of the guest.
     * @param l The last name of the guest.
     * @param n The number of nights for the reservation.
     * @param d The daily rate for the reservation.
     */
    
    public Reservation(String f, String l, int n, float d) {

        first = f;
        last = l;
        nights = n;
        dailyrate = d;

    }

   

    public void setfirst(String f) {

        first = f;

    }

    public void setlast(String l) {

        last = l;
    }

    public void setnights(int n) {

        nights = n;
    }

    public void setdailyrate(float dr) {

        dailyrate = dr;
    }

    public String getfirst() {
        return first;
    }

    public String getlast() {
        return last;
    }

    public int getnights() {
        return nights;
    }

    public float getdailyrate() {
        return dailyrate;
    }

   
     // Getter and setter methods...

    /**
     * Returns a string representation of the reservation.
     * @return A string containing the reservation information.
     */
  
    public String print() {

        String name = "Name = " + first + " " + last;
        String lengthstay = "Length of stay = " + nights;
        String rateofstay = "Daily Rate = $" + String.format("%.2f", dailyrate);
        String totalcost = "Total Cost = $" + String.format("%.2f", dailyrate * nights);
        String information = name + ", " + lengthstay + ", " + rateofstay + ", " + totalcost;
        
        return information;
    }
   

    /**
     * This method(getTotalCost) multiplies the daily rate by the number of
     * nights and returns the total price.
     *
     * @return
     */
    public double getTotalCost() {
        double totalprice;

        totalprice = (dailyrate * nights);

        return totalprice;
    }

 /**
     * Opens the stats.text file and prints its contents.
     * @throws Exception If an error occurs while reading the file.
     */
    
    public static void printStatsFile() throws Exception {

        Scanner scanner = new Scanner(new File("stats.txt"));

        while (scanner.hasNextLine()) {

            System.out.println(scanner.nextLine());

        }
        scanner.close();
    }

    /**
     * This static method is called add reservation it takes multiple arguments
     * and creates new reservations and adds it to an arrayList given as an
     * input.
     */
    public static void addReservation(String last, String first, int nights, float dailyrate, ArrayList<Reservation> reservations) {

        /**
         * this new reservation object is used to access the variables inside
         * the class a template to create new reservations.
         */
        Reservation newReservation = new Reservation(last, first, nights, dailyrate);

    }

    /**
     * This static method takes a Scanner and Array list of objects as argument
     * and prompts user for the information needed.
     */
    public static void addReservation(Scanner keyboard, ArrayList<Reservation> reservations) {

        System.out.println("Enter first name");
        String firstname = keyboard.nextLine();

        System.out.println("Enter last name");
        String lastname = keyboard.nextLine();

        System.out.println("Enter number of nights");
        int numbernights = keyboard.nextInt();

        System.out.println("Enter daily rate");
        Float dailyrate = keyboard.nextFloat();

        /**
         * the object below on line 146 is to be able to access the information
         * by the the user prompt using the object and creating new
         * Reservations.
         */
        Reservation newReservation = new Reservation(firstname, lastname, numbernights, dailyrate);

        /**
         * the reservation.add is to be able to add a new reservation to the
         * method.
         */
        reservations.add(newReservation);

    }

    /**
     * This method takes an Array list of reservations as an argument and prints
     * all the reservation using system.out.print .this method also uses the
     * print method by reservation to get the string to print.
     *
     */
    public static void viewReservations(ArrayList<Reservation> reservations) {
        /**
         * this for loop is to read the information inside reservation print
         * method to print the string information inside print information.
         *
         */

        for (int i = 0; i < reservations.size(); i++) {

            /**
             * This reservation for loop is to get reservation object and read
             * or go through whats within the object.
             */
            Reservation reservation = reservations.get(i);

            /**
             * this system print will print all the information
             *
             */
            System.out.println(reservation.print());

        }

        System.out.println();

    }

    /**
     * upload Reservation method ask the user for the name of a file and reads
     * the reservations from the file.
     */
    public static ArrayList<Reservation> uploadReservations(Scanner keyboard) throws Exception {

        /**
         * This prompt the user for filename.
         */
        System.out.println("Enter file name to upload");
        String filename = keyboard.nextLine();

        /**
         * The creation of the array list to store the reservation.
         */
        ArrayList<Reservation> reservations = new ArrayList<>();/// create  the array list start

        Scanner infile = new Scanner(new File(filename));

        while (infile.hasNext()) {

            /**
             * Scanner method was used to read each of the different variables
             * within the file.
             */
            String l = infile.next();
            String f = infile.next();
            int n = infile.nextInt();
            float d = infile.nextFloat();

            Reservation reservation = new Reservation(f, l, n, d);

            reservations.add(reservation);

        }

        infile.close();

        return reservations;
    }

    /**
     * This method writes all reservations from the provided array list to a
     * file named "stats.text".Uses the print method of each Reservation object
     * to format and write its details to the file.
     */
    public static void downloadReservations(ArrayList<Reservation> reservations) throws Exception {

        /**
         * create a new file called stats.text which will write the reservations
         * to that file.
         */
        FileWriter fw = new FileWriter("stats.txt");
        PrintWriter pw = new PrintWriter(fw);
        
        /**
         * Creates an array named last names to store last names of guests from reservations
         *The size of the array is set to the number of reservations.

         *
         */

        String[] lastnames = new String[reservations.size()];

        int longeststay = -1;

        double totalcost = 0.0;

        /**
         * reads through reservations using the for loop.
         */
        for (int i = 0; i < reservations.size(); i++) {

            Reservation reservation = reservations.get(i);

            /**
             * this Print writer line on 255 is to get the string to write to
             * the file.
             */
            pw.println(reservation.print());

            lastnames[i] = reservation.getlast();

            if (reservation.getnights() > longeststay) {
                longeststay = reservation.getnights();
            }

            totalcost += reservation.getTotalCost();
        }

        pw.println();

        Arrays.sort(lastnames);

        for (int i = 0; i < lastnames.length; i++) {
            pw.println(lastnames[i]);
        }

        pw.println();

        pw.println("The longest stay is " + longeststay + " nights.");
        pw.println("Total cost of reservations = $" + String.format("%.2f", totalcost));
        pw.close();
        fw.close();
    }

    public static void updateReservation(Scanner keyboard, ArrayList<Reservation> reservations) {

        boolean found = false;

        System.out.println("Enter first name and last name of reservation owner to update");
        String first = keyboard.nextLine();
        String last = keyboard.nextLine();

        while (!found) {

            for (int i = 0; i < reservations.size(); i++) {
                Reservation reservation = reservations.get(i);

                /**
                 * this string grabs first name and last name from reservation
                 * method.
                 */
                String reservationfullname = reservation.getfirst() + reservation.getlast();

                /**
                 * the if statement compares if the the full name match if
                 * statement acts as a gatekeeper. It ensures the loop continues
                 * searching until a matching reservation is found or all
                 * reservations have been checked.
                 */
                if (reservationfullname.equalsIgnoreCase(first + last)) {

                    System.out.println("Enter new first name");
                    first = keyboard.nextLine();

                    System.out.println("Enter new last name");
                    last = keyboard.nextLine();

                    System.out.println("Enter new number of nights");
                    int nights = keyboard.nextInt();

                    System.out.println("Enter new daily rate ");
                    float rate = keyboard.nextFloat();

                    found = true;

                    reservation.setfirst(first);
                    reservation.setlast(last);
                    reservation.setnights(nights);
                    reservation.setdailyrate(rate);

                    /**
                     * this updates the reservation with the new first and last
                     * name.
                     */
                    break;
                }

            }

        }

    }

    /**
     * This method on line 344 takes the array list of reservations objects as
     * an argument calls getTotalCost on each person and adds all of them up.
     *
     * @param reservations
     */
    public static void getTotalCost(ArrayList<Reservation> reservations) {

        double totalCost = 0.0;

        for (int i = 0; i < reservations.size(); i++) {
            Reservation reservation = reservations.get(i);

            double reservationcost = reservation.getTotalCost();

            totalCost += reservationcost;
        }

    }
    
    /**
     * Main method to run the hotel reservation system.
     * This method presents a menu to the user, allowing them to perform various operations such as
     * uploading reservations from a file, adding new reservations, updating existing reservations,
     * viewing all reservations, downloading reservation statistics to a file, and printing reservation statistics.
     * @param args The command line arguments (not used in this program).
     * @throws Exception If an error occurs during program execution, such as file I/O errors.
     */

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {

        Scanner keyboard = new Scanner(System.in);
        
        /**
         * Create the Array List to store reservations.
         */
        ArrayList<Reservation> reservations = new ArrayList<>();

        /**
         * The Print writer file code was given by the professor its so that we
         * are able to test the information on hacker rank.
         */
        PrintWriter createFile = new PrintWriter("input.txt");
        createFile.println("Bob Mike 3 140.23");
        createFile.println("Matt Benjamin 4 90");
        createFile.println("Keller Helen 8 98.15");
        createFile.println("Tim Mary 4 23.1");
        createFile.println("James Alan 3 47.77");
        createFile.println("William Carla 6 94.92");
        createFile.println("Mathew Robin 7 53.7");
        createFile.println("Jacob Tom 6 79.98");
        createFile.println("Nathan Norman 9 230.1");
        createFile.println("Nick Nate 8 537");
        createFile.println("Ethan Mary 6 87.9");
        createFile.println("Kate Helen 2 20.8");
        createFile.println("Benjamin Alan 4 90.44");
        createFile.println("John Jamie 2 89.88");
        createFile.println("Bob Annie 3 100");
        createFile.close();

        PrintWriter createFile2 = new PrintWriter("input2.txt");
        createFile2.println("Mouse Mickey 8 140.23");
        createFile2.println("Mouse Minnie 7 92");
        createFile2.println("Man Iron 5 68.15");
        createFile2.println("White Snow 14 33.1");
        createFile2.close();

        int option;
        /**
         * this loop displays user display menu and user input.
         */
        
        
        do {
            String displayMenu = "Welcome to Manchester's Hotel Reservation System.  Please choose from one of the following options.";
            System.out.println(displayMenu);
            System.out.println("1. Upload reservations\n2. New reservation\n3. Update reservation\n4. View all existing reservations\n5. Download statistics\n6. Print statistics\n7. Exit the program\n");

            /**
             * The switch statement stores the chosen option for whatever
             * choice is chosen by user.
             */
            option = keyboard.nextInt();
            
            /**
             * Prompt user to choose an option.
             */

            switch (option) {
                /**
                 * Process user choice.
                 */

                case 1:

                    if (option == 1) {
                        /**
                         * Upload reservations from a file.
                         */

                        keyboard.nextLine();

                        reservations = Reservation.uploadReservations(keyboard);

                    }

                    break;

                case 2:

                    if (option == 2) {
                        
                        /**
                         * Add a new reservation.
                         */

                        keyboard.nextLine();

                        Reservation.addReservation(keyboard, reservations);

                    }

                    break;

                case 3:

                    if (option == 3) {
                        
                        /**
                         * Updates an existing reservation.
                         */

                        keyboard.nextLine();

                        Reservation.updateReservation(keyboard, reservations);

                    }

                    break;

                case 4:

                    if (option == 4) {
                        
                    /**
                     * View all existing reservations.
                     */
                        keyboard.nextLine();

                        Reservation.viewReservations(reservations);

                    }

                    break;

                case 5:

                    if (option == 5) {
                        
                        /**
                         * Download reservation statistics to file.
                         */

                        keyboard.nextLine();

                        Reservation.downloadReservations(reservations);

                    }

                    break;

                case 6:
                    
                    /**
                     * Print reservation statistics from the file.
                     */

                    if (option == 6) {
                        Reservation.printStatsFile();
                    }

                    break;

                case 7:
                    
                    /**
                     * Exit the Program.
                     */

                    if (option == 7) {
                        break;
                    }

            }

        } while (option != 7);

    }

}
