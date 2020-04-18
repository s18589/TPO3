/**
 * @author Kępka Mateusz S18589
 */

package zad3;


import java.text.ParseException;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class Time {

    public static String passed(String from, String to) {

        String returnString = "";
        String dpatt = "d MMMM yyyy (EEEE)";
        String tpatt = "d MMMM yyyy (EEEE) 'godz.' HH:mm";
        try {
            if (from.length() > 10 && to.length() > 10) {
                LocalDateTime ldt1 = LocalDateTime.parse(from);
                LocalDateTime ldt2 = LocalDateTime.parse(to);
                ZonedDateTime zdt1 = ZonedDateTime.of(ldt1, ZoneId.of("Europe/Warsaw"));
                ZonedDateTime zdt2 = ZonedDateTime.of(ldt2, ZoneId.of("Europe/Warsaw"));

                Period p = Period.between(ldt1.toLocalDate(), ldt2.toLocalDate());
                returnString += "Od " + ldt1.format(DateTimeFormatter.ofPattern(tpatt)) + " " +
                        " do " + ldt2.format(DateTimeFormatter.ofPattern(tpatt)) + " " + "\n";

                long days = ChronoUnit.DAYS.between(ldt1, ldt2);
                double weeks = days / 7.0;
                returnString += " - mija: " + days + " dni, tygodni " + String.format("%.2f", weeks) + "\n";

                returnString += " - godzin: " + ChronoUnit.HOURS.between(zdt1, zdt2) + ", minut: " + ChronoUnit.MINUTES.between(zdt1, zdt2) + "\n";

                if (days >= 1) {
                    returnString += " - kalendarzowo: ";
                    if (p.getYears() == 1)
                        returnString += p.getYears() + " rok";
                    if(p.getYears() > 1 && p.getYears() < 5)
                        returnString += p.getYears() + " lata";
                    if(p.getYears() > 5)
                        returnString += p.getYears() + " lat";
                    if (p.getMonths() == 1)
                        returnString += ", " + p.getMonths() + " miesiac, ";
                    if (p.getMonths() > 1 && p.getMonths() < 5)
                        returnString += ", " + p.getMonths() + " miesiące, ";
                    if (p.getMonths() > 5)
                        returnString += ", " + p.getMonths() + " miesięcy, ";
                    if (p.getDays() == 1)
                        returnString += p.getDays() + " dzień ";
                    if (p.getDays() > 1)
                        returnString += p.getDays() + " dni ";
                }
            } else {
                LocalDate ld1 = LocalDate.parse(from);
                LocalDate ld2 = LocalDate.parse(to);
                Period p = Period.between(ld1, ld2);

                returnString += "Od " + ld1.format(DateTimeFormatter.ofPattern(dpatt)) + " " +
                        " do " + ld2.format(DateTimeFormatter.ofPattern(dpatt)) + " " + "\n";

                long days = ChronoUnit.DAYS.between(ld1, ld2);
                double weeks = days / 7.0;

                returnString += " - mija: " + days + " dni, tygodni " + String.format("%.2f", weeks) + "\n";
                if (days >= 1) {
                    returnString += " - kalendarzowo: ";
                    if (p.getYears() == 1)
                        returnString += p.getYears() + " rok";
                    if(p.getYears() > 1 && p.getYears() < 5)
                        returnString += p.getYears() + " lata";
                    if(p.getYears() > 5)
                        returnString += p.getYears() + " lat";
                    if (p.getMonths() == 1)
                        returnString += ", " + p.getMonths() + " miesiac, ";
                    if (p.getMonths() > 1 && p.getMonths() < 5)
                        returnString += ", " + p.getMonths() + " miesiące, ";
                    if (p.getMonths() > 5)
                        returnString += ", " + p.getMonths() + " miesięcy, ";
                    if (p.getDays() == 1)
                        returnString += p.getDays() + " dzień ";
                    if (p.getDays() > 1)
                        returnString += p.getDays() + " dni ";
                }
            }
        } catch (DateTimeParseException ex) {
            returnString = "*** " + ex.toString();
        }

        return returnString;
    }
}
