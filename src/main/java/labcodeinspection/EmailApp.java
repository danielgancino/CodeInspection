package labcodeinspection;

import java.util.Scanner;
import java.util.logging.Logger;

public final class EmailApp {

    private static final Logger LOG = Logger.getLogger(EmailApp.class.getName());

    private EmailApp() {
       
    }

    
    public static void main(final String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            LOG.info("Enter your first name: ");
            final String firstName = scanner.nextLine();

            LOG.info("Enter your last name: ");
            final String lastName = scanner.nextLine();

            LOG.info("\nDEPARTMENT CODE\n1. for sales\n2. for Development\n3. for accounting\nEnter code: ");
            final int depChoice = scanner.nextInt();

            final Email email = new Email(firstName, lastName);
            email.setDepartment(depChoice);
            email.generateEmail();

            LOG.info(email.info());
        }
    }
}
