package gr.teic.ie.oop2.paint.logger;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class FileTextLogger implements MyLogger{

    private File logFile = new File("info.log");
    private BufferedWriter bufferedWriter = null;
    private FileWriter fileWriter = null;

    @Override
    public void writeLog(String text) {
        try {
            String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
            String textLine = timestamp + ": " + text;

            if (!logFile.exists()) {
                logFile.createNewFile();
            }
            fileWriter = new FileWriter(logFile.getAbsoluteFile(), true);
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(textLine);
            bufferedWriter.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedWriter != null) {
                    bufferedWriter.close();
                }
                if (fileWriter != null) {
                    fileWriter.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

}
