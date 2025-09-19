
import java.util.Scanner;

public class MovieTicketGenerator
 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] movies = {"Jawan", "Leo", "Pushpa", "Salaar"};
        int[] prices = {200, 180, 250, 220};
        String[] timings = {"10:00 AM", "2:00 PM", "6:00 PM", "9:00 PM"};

        while (true) {
            System.out.println("\n Welcome to Java Cinema App ");
            System.out.println("---------------------------------------");
            for (int i = 0; i < movies.length; i++) {
                System.out.println((i + 1) + ". " + movies[i] + " - ₹" + prices[i]);
            }

            // Movie choice
            System.out.print("\nEnter movie choice (1-" + movies.length + "): ");
            int choice = sc.nextInt();

            if (choice < 1 || choice > movies.length) {
                System.out.println("Invalid choice! Try again.");
                continue;
            }

            // Show timing choice
            System.out.println("\nAvailable Timings:");
            for (int i = 0; i < timings.length; i++) {
                System.out.println((i + 1) + ". " + timings[i]);
            }
            System.out.print("Enter show timing choice: ");
            int timeChoice = sc.nextInt();
            if (timeChoice < 1 || timeChoice > timings.length) {
                System.out.println("Invalid timing! Try again.");
                continue;
            }

            // Tickets
            System.out.print("Enter number of tickets: ");
            int tickets = sc.nextInt();

            // Seat selection
            String[] seats = new String[tickets];
            System.out.println("Choose seat numbers (like A1, B2, C3):");
            sc.nextLine(); // consume newline
            for (int i = 0; i < tickets; i++) {
                System.out.print("Seat " + (i + 1) + ": ");
                seats[i] = sc.nextLine();
            }

            // Price calculation
            int ticketPrice = prices[choice - 1];
            int totalPrice = ticketPrice * tickets;
            double discount = 0;

            if (tickets >= 10) {
                discount = totalPrice * 0.20;
            } else if (tickets >= 5) {
                discount = totalPrice * 0.10;
            }

            double finalAmount = totalPrice - discount;

            // Payment
            System.out.println("\nPayment Methods: 1. UPI  2. Card  3. Cash");
            System.out.print("Choose payment method: ");
            int payChoice = sc.nextInt();
            String payment = (payChoice == 1) ? "UPI" :
                             (payChoice == 2) ? "Card" : "Cash";

            // Print Ticket
            System.out.println("\n===== Movie Ticket =====");
            System.out.println("Movie: " + movies[choice - 1]);
            System.out.println("Show Time: " + timings[timeChoice - 1]);
            System.out.print("Seats: ");
            for (String s : seats) {
                System.out.print(s + " ");
            }
            System.out.println("\nTicket Price: ₹" + ticketPrice);
            System.out.println("Total Price: ₹" + totalPrice);
            if (discount > 0) {
                System.out.println("Discount: ₹" + (int)discount);
            }
            System.out.println("Final Amount: ₹" + (int)finalAmount);
            System.out.println("Payment Mode: " + payment);
            System.out.println("Enjoy the Movie! 🍿");
            System.out.println("===========================");

            // Book again?
            System.out.print("\nDo you want to book again? (yes/no): ");
            String again = sc.next();
            if (!again.equalsIgnoreCase("yes")) {
                System.out.println("Thank you for using Java Cinema App!");
                break;
            }
        }

        sc.close();
    }
}


