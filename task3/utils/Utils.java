package utils;

import lombok.SneakyThrows;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class Utils {
    @SneakyThrows
    public static String convertFileJSONtoString(String filename) {
        FileReader fileReader = new FileReader(filename);
        Scanner scanner = new Scanner(fileReader);
        String json = "";
        while (scanner.hasNext()) {
            json += scanner.nextLine();
        }
        scanner.close();
        fileReader.close();
        return json;
    }

    @SneakyThrows
    public static void writeStringToJSONFile(String fileName, String resultString) {
        FileWriter fileWriter = new FileWriter(fileName);
        fileWriter.write(resultString);
        fileWriter.flush();
        fileWriter.close();
    }
}