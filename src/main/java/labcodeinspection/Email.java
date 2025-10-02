package labcodeinspection;

import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Logger;

public class Email {

    private static final Logger LOG = Logger.getLogger(Email.class.getName());

    private final String firstName;

    private final String lastName;

    private String password;

    private String department;

    private static final int DEFAULT_PWD_LEN = 8;

    private String emailAddress;

 
    public Email(final String firstName, final String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }


    public String info() {
        return "\nFIRST NAME= " + firstName
                + "\nLAST NAME= " + lastName
                + "\nDEPARTMENT= " + department
                + "\nEMAIL= " + emailAddress
                + "\nPASSWORD= " + password;
    }

   
    public void setDepartment(final int depChoice) {
        switch (depChoice) {
            case 1:
                this.department = "sales";
                break;
            case 2:
                this.department = "dev";
                break;
            case 3:
                this.department = "acct";
                break;
            default:
                this.department = "general";
                break;
        }
    }

   
    private String randomPassword(final int length) {
        final String set = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890#$&@*";
        final char[] pwd = new char[length];
        for (int i = 0; i < length; i++) {
            final int idx = ThreadLocalRandom.current().nextInt(set.length());
            pwd[i] = set.charAt(idx);
        }
        return new String(pwd);
    }

  
    public void generateEmail() {
        this.password = this.randomPassword(DEFAULT_PWD_LEN);
        this.emailAddress = this.firstName.toLowerCase(Locale.ROOT)
                + this.lastName.toLowerCase(Locale.ROOT)
                + "@"
                + this.department
                + ".espol.edu.ec";
        LOG.fine("Email generado para " + firstName + " " + lastName);
    }
}
