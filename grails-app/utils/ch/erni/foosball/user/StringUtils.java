package ch.erni.foosball.user;

import java.text.Normalizer;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

/**
 * Created by cepe on 13.02.2015.
 */
public class StringUtils {
    private static final SimpleDateFormat sdfDateAndTime = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
    private static final SimpleDateFormat sdfDate = new SimpleDateFormat("dd.MM.yyyy");

    public static String deAccent(String str) {
        if (str == null) return null;

        String nfdNormalizedString = Normalizer.normalize(str, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(nfdNormalizedString).replaceAll("");
    }

    public static String formatAsDateAndTime(Date date) {
        if (date != null) {
            return sdfDateAndTime.format(date);
        }
        return null;
    }

    public static String formatAsDate(Date date) {
        if (date != null) {
            return sdfDate.format(date);
        }
        return null;
    }
}
