import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class PeriodOfDayFormatter {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("B");
        String periodOfDay = formatter.format(now);
        System.out.println("Current period of the day: "+periodOfDay);
    }
}