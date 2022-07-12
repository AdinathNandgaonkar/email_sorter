import java.io.*;
import java.util.Arrays;

public class email_sorter implements Serializable{  
        // static int dailyEmailSorted;
        // static int dailyEmailRecruitment;
        // static int dailyEmailSpam;
        // static int dailyEmailSales;
        // static int dailyEmailReception;
        static String emailCV = "this is an example text containing cv";
        static String emailPromo = "this is an example text containing promo";
        static String emailAdvertising = "this is an example text containing advertising";
        static String emailProposal = "this is an example text containing proposal";
        static String emailEmpty = "this is an example text containing nothing";
        static String[] listOfEmails = {emailCV, emailPromo, emailAdvertising, emailProposal, 
            emailEmpty, emailAdvertising, emailCV, emailPromo};
        static int logicalSize = 8;
        static int totalEmailSorted = 0;
        static int totalEmailRecruitment = 0;
        static int totalEmailSpam = 0;
        static int totalEmailSales = 0;
        static int totalEmailReception = 0;
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        // Email sampleEmail = new Email();
        // sampleEmail.sender = "Michael";
        // sampleEmail.text = "this is an example text";
        // Email sampleEmail2 = new Email();
        // sampleEmail2.sender = "James";
        // sampleEmail2.text = "this is also an example text";
        // Email[] listOfSampleEmails = {sampleEmail, sampleEmail2};
        // int sampleEmailsSorted = 0;
        // int sampleAlsoEmails = 0;

        for (int i = 0; i < logicalSize; i=i){
            if (listOfEmails[0].contains("cv")){
                totalEmailRecruitment++;
                for (int n = 0; n < logicalSize - 1; n++){
                    listOfEmails[n] = listOfEmails[n+1];
                }
                listOfEmails[logicalSize - 1] = "";
                logicalSize--;
            } else if (listOfEmails[0].contains("promo") || listOfEmails[0].contains("advertising")){
                totalEmailSpam++;
                for (int d = 0; d < logicalSize - 1; d++){
                    listOfEmails[d] = listOfEmails[d+1];
                }
                listOfEmails[logicalSize - 1] = "";
                logicalSize--;
            } else if (listOfEmails[0].contains("proposal")){
                totalEmailSales++;
                for (int e = 0; e < logicalSize - 1; e++){
                    listOfEmails[e] = listOfEmails[e+1];
                }
                listOfEmails[logicalSize - 1] = "";
                logicalSize--;
            } else {
                totalEmailReception++;
                for (int x = 0; x < logicalSize - 1; x++){
                    listOfEmails[x] = listOfEmails[x+1];
                }
                listOfEmails[logicalSize - 1] = "";
                logicalSize--;
            }
            totalEmailSorted++;
        }


        FileReader fileReader = new FileReader("DailyEmailsCount.dat");
        BufferedReader reader = new BufferedReader(fileReader);
        String dailyEmailCount = reader.readLine();
        fileReader.close();
        
        String memory = dailyEmailCount;
        int[] oldElements = Arrays.stream(memory.split(":")).mapToInt(Integer::parseInt).toArray ();
        int[] newElements = Arrays.stream(memory.split(":")).mapToInt(Integer::parseInt).toArray ();
        String updatedElements = "";
        
        newElements[0] = totalEmailSorted;
        newElements[1] = totalEmailRecruitment;
        newElements[2] = totalEmailSpam;
        newElements[3] = totalEmailSales;
        newElements[4] = totalEmailReception;
        
        int[] dailyTotal = new int[5];
        dailyTotal[0] = oldElements[0] + newElements[0];
        dailyTotal[1] = oldElements[1] + newElements[1];
        dailyTotal[2] = oldElements[2] + newElements[2];
        dailyTotal[3] = oldElements[3] + newElements[3];
        dailyTotal[4] = oldElements[4] + newElements[4];
        
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
        
        
        System.out.println("total emails sorted " + totalEmailSorted);
        System.out.println("total emails recruitment " + totalEmailRecruitment);
        System.out.println("total emails spam " + totalEmailSpam);
        System.out.println("total emails sales " + totalEmailSales);
        System.out.println("total emails reception " + totalEmailReception);
        System.out.println("daily emails sorted " + dailyTotal[0]);
        System.out.println("daily emails recruitment " + dailyTotal[1]);
        System.out.println("daily emails spam " + dailyTotal[2]);
        System.out.println("daily emails sales " + dailyTotal[3]);
        System.out.println("daily emails reception " + dailyTotal[4]);
    }
}