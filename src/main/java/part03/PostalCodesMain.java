package part03;

import java.util.Map;
import java.util.Scanner;

public class PostalCodesMain {

    /**
     * Implement your logic in this method. You can also add your own methods and
     * classes if needed.
     *
     * Your program should handle displaying postal codes and postal district names
     * in both directions. For example, if the user enters "00100", the program
     * should print "Helsinki". If the user enters "Helsinki" as their input, the
     * program should print "00100" along with all other postal codes for
     * Helsinki.
     *
     * The program should not handle partial matches. For example, if the user
     * enters "001", the program should not display any results. However, the
     * program should be case-insensitive. For example, the program should display
     * "00100" whether the user enters "helsinki" or "HELSINKI".
     */
    public static void main(String[] args) {
        /*
         * This map contains data that is read from the JSON file. You don't need to
         * inspect the file handling in this exercise, but you can if you want to.
         *
         * The keys in the map are postal codes and the values are postal district names.
         */
        Map<String, String> postalCodes = PostalCodes.readPostalCodes();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Mitä etsitään (esim. 00100 tai Helsinki)? ");
        String answer = scanner.nextLine(); // answer may be a postal code or a postal district name

        // Try direct match (postal code)
        if (postalCodes.containsKey(answer)) {
            System.out.println(postalCodes.get(answer));
        } else {
            // Normalize input to lowercase for case-insensitive comparison
            String normalizedInput = answer.toLowerCase();
            boolean found = false;

            for (Map.Entry<String, String> entry : postalCodes.entrySet()) {
                if (entry.getValue().equalsIgnoreCase(normalizedInput)) {
                    System.out.println(entry.getKey());
                    found = true;
                }
            }

            if (!found) {
                System.out.println("Ei tuloksia.");
            }
        }

        scanner.close();
    }
}