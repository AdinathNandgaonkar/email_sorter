public class email_sorter {
    public static void main(String[] args) {
        
        String emailCV = "this is an example text containing cv";
        String emailPromo = "this is an example text containing promo";
        String emailAdvertising = "this is an example text containing advertising";
        String emailProposal = "this is an example text containing proposal";
        String emailEmpty = "this is an example text containing nothing";

        String[] listOfEmails = {emailCV, emailPromo, emailAdvertising, emailProposal, 
            emailEmpty, emailAdvertising, emailCV, emailPromo};
        int logicalSize = 8;
      
        int totalEmailSorted = 0;
        int totalEmailRecruitment = 0;
        int totalEmailSpam = 0;
        int totalEmailSales = 0;
        int totalEmailReception = 0;
        int dailyEmailSorted = 0;
        int dailyEmailRecruitment = 0;
        int dailyEmailSpam = 0;
        int dailyEmailSales = 0;
        int dailyEmailReception = 0;

        for (int i = 0; i < logicalSize; i=i){
            if (listOfEmails[0].contains("cv")){
                totalEmailSorted++;
                dailyEmailSorted++;
                totalEmailRecruitment++;
                for (int n = 0; n < logicalSize - 1; n++){
                    listOfEmails[n] = listOfEmails[n+1];
                }
                listOfEmails[logicalSize - 1] = "";
                logicalSize--;
            } else if (listOfEmails[0].contains("promo") || listOfEmails[0].contains("advertising")){
                totalEmailSorted++;
                dailyEmailSorted++;
                totalEmailSpam++;
                for (int d = 0; d < logicalSize - 1; d++){
                    listOfEmails[d] = listOfEmails[d+1];
                }
                listOfEmails[logicalSize - 1] = "";
                logicalSize--;
            } else if (listOfEmails[0].contains("proposal")){
                totalEmailSorted++;
                dailyEmailSorted++;
                totalEmailSales++;
                for (int e = 0; e < logicalSize - 1; e++){
                    listOfEmails[e] = listOfEmails[e+1];
                }
                listOfEmails[logicalSize - 1] = "";
                logicalSize--;
            } else {
                totalEmailSorted++;
                dailyEmailSorted++;
                totalEmailReception++;
                for (int x = 0; x < logicalSize - 1; x++){
                    listOfEmails[x] = listOfEmails[x+1];
                }
                listOfEmails[logicalSize - 1] = "";
                logicalSize--;
            }
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