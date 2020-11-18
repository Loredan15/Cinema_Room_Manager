package cinema;

import java.util.*;

public class Cinema {
    static Scanner scanner = new Scanner(System.in);
    static int numberOfRows;
    static int seatsInRow;
    static int allSeats;
    static int ticketPrice;
    static String[][] cinema;
    static int numberOfPurchasedTickets = 0;
    static float purchasesTicketsPercent;
    static int currentIncome;
    static int totalIncome;
    static final int TICKET_PRICE = 10;
    static final int TICKET_PRICE_WITH_DISCOUNT = 8;


    public static void main(String[] args) {

        makeCinema();
        while (true) {
            showMenu();
            int numberMenu = scanner.nextInt();
            switch (numberMenu) {
                case 1: {
                    printCinema(cinema);
                    break;
                }
                case 2: {
                    buyTicket(cinema);
                    break;
                }
                case 3:{
                 statisticCinema(cinema);
                 break;
                }
                case 0:
                    System.exit(0);
            }
        }
    }

    private static void statisticCinema(String[][] cinema) {
        allTicketPrice(numberOfRows, seatsInRow);

        System.out.println("Number of purchased tickets: " + numberOfPurchasedTickets);
        System.out.printf("Percentage:% .2f%%", purchasesTicketsPercent);
        System.out.println();
        System.out.println("Current income: $" + currentIncome);
        System.out.println("Total income: $" + totalIncome);
        System.out.println();

    }


    public static void showMenu() {
        System.out.println("1. Show the seats");
        System.out.println("2. Buy a ticket");
        System.out.println("3. Statistics");
        System.out.println("0. Exit");
    }

    public static void makeCinema() {
        System.out.println("Enter the number of rows:");
        numberOfRows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        seatsInRow = scanner.nextInt();
        cinema = new String[numberOfRows + 1][seatsInRow + 1];

        for (int i = 1; i <= numberOfRows + 1; i++) {
            for (int j = 0; j < seatsInRow + 1; j++) {
                cinema[0][0] = " ";
                cinema[0][j] = String.valueOf(j);
                cinema[i - 1][j] = "S";
            }
        }
        for (int i = 1; i < numberOfRows + 1; i++) {
            cinema[i][0] = String.valueOf(i);
        }
    }

    public static void buyTicket(String[][] cinema) {
        boolean successBuyTicket = false;
        int rowNumber = 0;
        int seatInRowNumber = 0;

        while (!successBuyTicket) {
            System.out.println("Enter a row number:");
            rowNumber = scanner.nextInt();
            System.out.println("Enter a seat number in that row:");
            seatInRowNumber = scanner.nextInt();
            if ((rowNumber <= numberOfRows) && (seatInRowNumber <= seatsInRow)) {
                if (cinema[rowNumber][seatInRowNumber].equals("B")) {
                    System.out.println("That ticket has already been purchased");
                } else {
                    cinema[rowNumber][seatInRowNumber] = "B";
                    successBuyTicket = true;
                    numberOfPurchasedTickets++;
                }
            } else {
                System.out.println("Wrong input");
            }
        }

        allSeats = numberOfRows * seatsInRow;



        if (allSeats < 60){
            ticketPrice = 10;
        }else{
            int frontHalfOfRows = numberOfRows / 2;
            if(rowNumber <= frontHalfOfRows){
                ticketPrice = 10;
            }else {
                ticketPrice = 8;
            }
        }
        currentIncome += ticketPrice;
        purchasesTicketsPercent = (float)numberOfPurchasedTickets / allSeats * 100;
        System.out.println();
        System.out.println("Ticket price: $" + ticketPrice);
        System.out.println();
    }

    private static void printCinema(String[][] mas) {

        System.out.println("Cinema:");
        for (String[] str : mas) {
            for (String str2 : str) {
                System.out.print(str2 + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static int allTicketPrice(int rows, int seatsInRow){
        totalIncome = 0;
        if( rows * seatsInRow <= 60){
            totalIncome = rows * seatsInRow * TICKET_PRICE;
        }else{
            if (rows % 2 != 0){
                totalIncome = rows / 2 * seatsInRow * TICKET_PRICE + (rows / 2 + 1) * seatsInRow * TICKET_PRICE_WITH_DISCOUNT;
            }else{
                totalIncome = rows / 2 * seatsInRow * TICKET_PRICE + rows / 2 * seatsInRow * TICKET_PRICE_WITH_DISCOUNT;
            }
        }
        return  totalIncome;
    }

}