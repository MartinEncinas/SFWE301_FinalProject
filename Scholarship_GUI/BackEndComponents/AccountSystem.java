import java.util.Scanner; 

public class AccountSystem {
    private static final int MAX_ACCOUNTS = 100;
    private String[][] accounts;
    private int accountCount;

    public AccountSystem() {
        accounts = new String[MAX_ACCOUNTS][5]; // 5 columns for each piece of information
        accountCount = 0;
    }

    public void createNewAccount() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter username:");
        String name = scanner.nextLine();

        System.out.println("Enter Email:");
        String contactEmails = scanner.nextLine();

        System.out.println("Enter Password:");
        String contactPassword = scanner.nextLine();

        System.out.println("Enter Phone Number:");
        String contactDetails = scanner.nextLine();

        System.out.println("Enter school name:");
        String academicHistory = scanner.nextLine();

        accounts[accountCount][0] = name; // Username in the first column
        accounts[accountCount][1] = contactEmails; // Email in the second column
        accounts[accountCount][2] = contactPassword; // Password in the third column
        accounts[accountCount][3] = contactDetails; // Phone number in the fourth column
        accounts[accountCount][4] = academicHistory; // School name in the fifth column

        accountCount++;

        System.out.println("New account created successfully.");
    }

    public void displayAccounts() {
        for (int i = 0; i < accountCount; i++) {
            System.out.println("Account " + (i + 1) + ": " +
                               "Username: " + accounts[i][0] +
                               ", Email: " + accounts[i][1] +
                               ", Password: " + accounts[i][2] +
                               ", Phone: " + accounts[i][3] +
                               ", School: " + accounts[i][4]);
        }
    }

    public static void main(String[] args) {
        AccountSystem system = new AccountSystem();
        system.createNewAccount();
        system.displayAccounts();
    }
}
