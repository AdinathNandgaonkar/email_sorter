import java.io.*;

public class ResetDailyCounter {
    public static void main(String[] args) throws IOException {
        FileWriter fileWriterReset = new FileWriter("DailyEmailsCount.dat");
        BufferedWriter writerReset = new BufferedWriter(fileWriterReset);
        writerReset.write("0:0:0:0:0");
        writerReset.close();
    }
}
