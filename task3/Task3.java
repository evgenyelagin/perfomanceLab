import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import models.TestsModelList;
import models.ValueModelList;
import java.io.StringWriter;
import static utils.Utils.*;

public class Task3 {
    @SneakyThrows
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Аргументов недостаточно! Введите 2 файла в качестве аргумента в коммандную строку");
            System.exit(1);
        }
        String jsonValue = convertFileJSONtoString(args[1]);
        ObjectMapper mapper = new ObjectMapper();
        ValueModelList valueModelList = mapper.readValue(jsonValue, ValueModelList.class);
        String jsonTests = convertFileJSONtoString(args[0]);
        TestsModelList testsModelList = mapper.readValue(jsonTests, TestsModelList.class);
        for (int j = 0; j <= testsModelList.getTests().size() - 1; j++) {
        testsModelList.getTests().get(j).setValue(valueModelList.getValues().get(j).getValue());
        }
        StringWriter writer = new StringWriter();
        mapper.writeValue(writer, testsModelList);
        String result = writer.toString();
        writeStringToJSONFile("report.json", result);
    }
}