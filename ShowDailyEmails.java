import java.io.*;
import java.util.Arrays;

public class ShowDailyEmails{
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader("DailyEmailsCount.dat");
        BufferedReader reader = new BufferedReader(fileReader);
        String dailyEmailCount = reader.readLine();
        fileReader.close();
        int[] elements = Arrays.stream(dailyEmailCount.split(":")).mapToInt(Integer::parseInt).toArray ();
        System.err.println("");
        System.out.println("We have sorted a total of " + elements[0] + " mails today:");
        System.out.println("    " + elements[1] + " to recruitment");
        System.out.println("    " + elements[2] + " to spam");
        System.out.println("    " + elements[3] + " to sales");
        System.out.println("    " + elements[4] + " to reception");
        System.out.println("");
    }
}