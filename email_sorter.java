import java.io.*;

public class email_sorter implements Serializable{  
        static int dailyEmailSorted;
        static int dailyEmailRecruitment;
        static int dailyEmailSpam;
        static int dailyEmailSales;
        static int dailyEmailReception;
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
    public static void main(String[] args) {

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
            dailyEmailSorted++;
        }

        System.out.println("total emails sorted " + totalEmailSorted);
        System.out.println("total emails recruitment " + totalEmailRecruitment);
        System.out.println("total emails spam " + totalEmailSpam);
        System.out.println("total emails sales " + totalEmailSales);
        System.out.println("total emails reception " + totalEmailReception);
        System.out.println("daily emails sorted " + dailyEmailSorted);
        System.out.println("daily emails recruitment " + dailyEmailRecruitment);
        System.out.println("daily emails spam " + dailyEmailSpam);
        System.out.println("daily emails sales " + dailyEmailSales);
        System.out.println("daily emails reception " + dailyEmailReception);
    }
}