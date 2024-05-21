//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import javax.swing.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Main {
    public static void main(String[] args) {

        // Prompt the user to enter a username
        String username = JOptionPane.showInputDialog("Enter Username:");
        if (checkUserName(username)) {
            JOptionPane.showMessageDialog(null,"Username successfully captured");
        } else {
            JOptionPane.showMessageDialog(null, "Username is not currently formatted. Please ensure that your username contains an underscore (_) and is no more than 5 characters in length.");

            // Prompt the user to enter a password
            String password = JOptionPane.showInputDialog("Enter password");
            if (checkPasswordComplexity(password)) {
                JOptionPane.showMessageDialog(null, "Password successfully captured");
            } else {
                JOptionPane.showMessageDialog(null, "Password is not currently formatted. Please ensure that the password contains at least 8 characters, a capital letter, a number, and a special character.");
            }
        }
    }

    public static boolean checkUserName(String username) {
        return username != null && username.contains("_") && username.length() <= 5;
    }

    public static boolean checkPasswordComplexity(String password) {
        String pattern = "([A-Z].[!@?=$%.].[0-9])";
        Pattern p  = Pattern.compile(pattern);
        Matcher m = p.matcher(password);
        return m.matches();
    }

    public static boolean registerUser(String username, String password) {
        // Check if the username is incorrectly formatted
        if (!isUsernameValid(username)) {
            return false;
        }

        // Check if the password meets the complexity requirements
        if(!isPasswordComplexity(password)) {
            return false;
        }

        // The two above conditions have been met
        // Register the user successfully
        //register(username, password);
        return true;
    }

    public static boolean isUsernameValid(String username) {
        return checkUserName(username);
    }

    public static boolean isPasswordComplexity(String password) {
        return checkPasswordComplexity(password);
    }

    public static boolean loginUser(String username, String password) {
        return !username.isEmpty() && !password.isEmpty();
    }

    public String returnLoginStatus(boolean loginSuccessful) {
        if (loginSuccessful) {
            return "Login Successful.";
        } else {
            return "Login failed.";
        }
    }
}

