import lombok.SneakyThrows;

import java.io.FileReader;
import java.util.*;

public class Task4 {
    @SneakyThrows
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Аргументов недостаточно! Введите имя файла (пример: test16.txt) в качестве аргумента в коммандную строку");
            System.exit(1);
        }
        List<Integer> list = new ArrayList<>();
        try (FileReader fileReader = new FileReader(args[0])) {
            Scanner scanner = new Scanner(fileReader);
            while (scanner.hasNextLine()) {
                String[] s = scanner.nextLine().split(" ");
                list.add(Integer.parseInt(s[0]));
            }
        }
        System.out.println(findPath(list));
    }

    static int findPath(List<Integer> list) {
        int[] array = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = 0;
            for (int j = 0; j < list.size(); j++) {
                array[i] += Math.abs(list.get(i) - list.get(j));
            }
        }
        Integer min = Arrays.stream(array).min().getAsInt();
        return min;
    }
}