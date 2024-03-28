import java.util.Scanner;
import java.util.regex.Pattern;

class InvalidPANException extends Exception {
    public InvalidPANException(String str) {
        super(str);
    }
}

public class main {
    public static int whitespace(String str) {
        int i = 0;
        for (i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                return i;
            }
        }
        return i;
    }

    static void validate_PAN(String PAN, String a, String b, String c, String d) throws InvalidPANException {
        String fifth_word = PAN.substring(4, 5);
        if (!(PAN.length() == 10)) {
            throw new InvalidPANException("Entered PAN number has more/less than ten-digit unique alphanumeric number.");
        } else if (!(Pattern.matches("[A-Z]{3}", PAN.substring(0, 3)))) {
            throw new InvalidPANException("The first three characters are not representing the alphabetic series running from AAA to ZZZ");
        } else if (!(Pattern.matches("[ABCEGHIKNQ]{1}", PAN.charAt(3) + ""))) {
            throw new InvalidPANException("The fourth character is not representing Status of the PAN Holder\nand it will contain any one of the character like A,B,C,E,G,H,I,K,N,Q.");
        } else if (!(fifth_word.equals(a.toUpperCase()) || fifth_word.equals(b.toUpperCase()) || fifth_word.equals(c.toUpperCase()) || fifth_word.equals(d.toUpperCase()))) {
            throw new InvalidPANException("The fifth character is not representing either\nfather's firstname/lastname's first character (Individual) (or) person's firstname/lastname's last character (Non-Individual).");
        } else {
            System.out.println("This might be a valid PAN number.");
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the person's PAN Number to Validate: ");
        String PAN = sc.nextLine();
        System.out.println("Enter the person Name: ");
        String person = sc.nextLine();
        System.out.println("Enter the Father Name: ");
        String father = sc.nextLine();
        try {
            String father_firstname_firstchar = "" + father.charAt(0);
            String father_lastname_firstchar = "" + father.charAt(whitespace(father) + 1);
            String person_firstname_lastchar = "" + person.charAt(whitespace(person) - 1);
            String person_lastname_lastchar = "" + person.charAt(person.length() - 1);

            validate_PAN(PAN, father_firstname_firstchar, father_lastname_firstchar, person_firstname_lastchar, person_lastname_lastchar);
        } catch (InvalidPANException e) {
            System.out.println("\nCaught the exception.");
            System.out.println("Exception occured: " + e);
            System.out.println("");
        } finally {
            sc.close();
        }
    }
}

