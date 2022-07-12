import java.io.*;
import java.util.Arrays;
import java.util.stream.IntStream;

public class email_sorter{  

        static String emailCV = "this is an example email containing cv";
        static String emailPromo = "this is an example email containing promo";
        static String emailAdvertising = "this is an example email containing advertising";
        static String emailProposal = "this is an example email containing proposal";
        static String emailEmpty = "this is an example email containing something else";

        static int length = 100;
        static int min = 0;
        static int max = 4;
        static int[] randomArray = IntStream.range(0, length)
            .map(i -> (int) (min + Math.random() * (max - min + 1)))
            .toArray();
        
        static String[] listOfEmails = new String[100];
        static int logicalSize = 100;
        static int totalEmailSorted = 0;
        static int totalEmailRecruitment = 0;
        static int totalEmailSpam = 0;
        static int totalEmailSales = 0;
        static int totalEmailReception = 0;
    public static void main(String[] args) throws IOException {

        
        for (int i = 0; i < randomArray.length; i++){
            if (randomArray[i] == 0){
                listOfEmails[i] = emailCV;
            } else if (randomArray[i] == 1){
                listOfEmails[i] = emailAdvertising;
            } else if (randomArray[i] == 2){
                listOfEmails[i] = emailPromo;
            } else if (randomArray[i] == 3){
                listOfEmails[i] = emailProposal;
            } else if (randomArray[i] == 4){
                listOfEmails[i] = emailEmpty;
            } else {
                System.out.println("error with random list");
            }
        }
        

        for (int i = 0; i < logicalSize; i=i){
            if (listOfEmails[0].contains("cv")){
                //FORWARD Email to “recruitment@parkshark.com”
                totalEmailRecruitment++;
            } else if (listOfEmails[0].contains("promo") || listOfEmails[0].contains("advertising")){
                //FORWARD Email to “spam@parkshark.com”
                totalEmailSpam++;
            } else if (listOfEmails[0].contains("proposal")){
                //FORWARD Email to “sales@parkshark.com”
                totalEmailSales++;
            } else {
                //FORWARD Email to “reception@parkshark.com”
                totalEmailReception++;
            }
            for (int n = 0; n < logicalSize - 1; n++){
                listOfEmails[n] = listOfEmails[n+1];
            }
            listOfEmails[logicalSize - 1] = "";
            logicalSize--;
            totalEmailSorted++;
        }


        FileReader fileReader = new FileReader("DailyEmailsCount.dat");
        BufferedReader reader = new BufferedReader(fileReader);
        String dailyEmailCount = reader.readLine();
        fileReader.close();
        
        String memory = dailyEmailCount;
        int[] oldElements = Arrays.stream(memory.split(":")).mapToInt(Integer::parseInt).toArray ();
        String updatedElements = "";
        int[] dailyTotal = new int[5];
        dailyTotal[0] = oldElements[0] + totalEmailSorted;
        dailyTotal[1] = oldElements[1] + totalEmailRecruitment;
        dailyTotal[2] = oldElements[2] + totalEmailSpam;
        dailyTotal[3] = oldElements[3] + totalEmailSales;
        dailyTotal[4] = oldElements[4] + totalEmailReception;
        
        StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < dailyTotal.length; i++) {
            stringBuilder.append(dailyTotal[i]);
                if (i == dailyTotal.length - 1){
                } else {
                stringBuilder.append(":");
                }
            }
        updatedElements = stringBuilder.toString();

        FileWriter fileWriter = new FileWriter("DailyEmailsCount.dat");
        BufferedWriter writer = new BufferedWriter(fileWriter);
        writer.write(updatedElements);
        writer.close();
        
        System.out.println("");
        System.out.println("We have sorted " + totalEmailSorted + " mails:");
        System.out.println("    " + totalEmailRecruitment + " to recruitment");
        System.out.println("    " + totalEmailSpam + " to spam");
        System.out.println("    " + totalEmailSales + " to sales");
        System.out.println("    " + totalEmailReception + " to reception");
        System.out.println("");
        // System.out.println("daily emails sorted " + dailyTotal[0]);
        // System.out.println("daily emails recruitment " + dailyTotal[1]);
        // System.out.println("daily emails spam " + dailyTotal[2]);
        // System.out.println("daily emails sales " + dailyTotal[3]);
        // System.out.println("daily emails reception " + dailyTotal[4]);
        // System.out.println("");
        
    }
}