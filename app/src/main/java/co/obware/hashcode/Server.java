package co.obware.hashcode;

public class Server {

    private final static String IP_ADDRESS = "172.16.4.202"; // Add ip address
    private final static String URL = "http://" + IP_ADDRESS + "/pharmanode/";
    private final static String LOGIN_PATH = "login.php";
    private final static String REGISTER_PATH = "register.php";
    private final static String PROFILE_PATH = "editprofile.php";

    Server(){

    }

    public static String getLoginUrl() {

        return URL + LOGIN_PATH;
    }

    public static String getRegisterUrl() {

        return URL + REGISTER_PATH;
    }

    public static String getProfileUrl() {

        return URL + PROFILE_PATH;
    }
}







