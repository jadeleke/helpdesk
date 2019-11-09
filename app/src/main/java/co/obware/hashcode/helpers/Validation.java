package co.obware.hashcode.helpers;

/*import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;*/

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {

    public static boolean emailValidation(String email) {

        Pattern pattern;
        Matcher matcher;
        final String EMAIL_PATTERN = "^[_a-zA-Z0-9-]+(\\.[_a-zA-Z0-9-]+)" +
                "*@[a-zA-Z0-9]+(\\.[a-zA-Z0-9]+)*(\\.[a-zA-Z]{2,})$";
        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(email);
        return !matcher.matches();
    }

    public static boolean IndexValidation(String number){

        if (number!=null && number.length()==9){
            return false;
        }
        return true;
    }

    public static boolean nameValidation(String number){

        if (number!=null && number.length()>6){
            return false;
        }
        return true;
    }

    public static boolean numberValidation(String number){

        if (number!=null && number.length()>6){
            return false;
        }
        return true;
    }


    public static boolean passwordValidation(String pass) {

        if (pass!=null && pass.length()>6){
            return false;
        }
            return true;
    }

}
