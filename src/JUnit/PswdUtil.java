package JUnit;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Кристина on 9.03.2016.
 */
public class PswdUtil {

    private PswdUtil() {}

    public static boolean validatePassword(final String password) {
        Pattern pattern = Pattern.compile("\\w*");
        Matcher m = pattern.matcher(password);
        Pattern pattern1 = Pattern.compile(".*\\d+.*");
        Matcher n = pattern1.matcher(password);
        Pattern pattern2 = Pattern.compile(".*[a-z]+.*");
        Matcher o = pattern2.matcher(password);
        Pattern pattern3 = Pattern.compile(".*[A-Z]+.*");
        Matcher p = pattern3.matcher(password);
        Pattern pattern4 = Pattern.compile(".*(\\w)\\1\\1.*");
        Matcher r = pattern4.matcher(password);
        if (m.matches() && n.matches() && o.matches()
                && p.matches()
                 && !r.matches() && password.length()>=8) {
            return true;
        } else {
            return false;
        }
    }
}
