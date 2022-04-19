package Common;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FakeData {
    public static String RandomNumber(){

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("ddMMyyHHmmss");
        LocalDateTime present = LocalDateTime.now();
        return dateTimeFormatter.format(present);
    }

    public static String createRandomEmail(String email){

        String[] parts = email.split("@");
        String part1 = parts[0];
        String part2 = parts[1];
        return part1 + RandomNumber() + "@" + part2;
    }
}