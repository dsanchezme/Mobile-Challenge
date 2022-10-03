package utils;

public class SystemVariablesUtil {
    private static String email;
    private static String password;

    public static String getEmail() {
        if (email == null){
            setEmail();
        }
        return email;
    }

    private static void setEmail() {
        email = System.getenv("IMDB_EMAIL");
        isVariableNull(email, "IMDB_EMAIL");
    }

    public static String getPassword() {
        if (password == null){
            setPassword();
        }
        return password;
    }

    private static void setPassword() {
        password = System.getenv("IMDB_PASSWORD");
        isVariableNull(password, "IMDB_PASSWORD");
    }

    private static void isVariableNull(String variable, String variableName){
        if (variable == null){
            System.out.println(variableName + " was not found in the system environment variables.");
        }
    }
}
