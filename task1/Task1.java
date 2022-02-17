public class Task1 {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Аргументов недостаточно! Введите 2 аргумента в коммандную строку");
            System.exit(1);
        }
        int n = Integer.parseInt(args[0]);
        int m = Integer.parseInt(args[1]);
        System.out.println(findPath(n, m));
    }

    public static String findPath(int n, int m) {
        String result = "1";
        if (m < 1 || n < 1)
            return result;
        if (n == 1)
            return result;

        int currentNumber = 1;
        int counter = 1;
        while (true) {
            int nextNumber;
            if (n >= currentNumber + m - 1) {
                nextNumber = currentNumber + m - 1;
            } else {
                nextNumber = (currentNumber + m - 1) % n;
                if (nextNumber == 0) {
                    nextNumber = currentNumber + 1;
                }
            }
            if (nextNumber == 1)
                counter++;
            if (counter > 1)
                break;
            currentNumber = nextNumber;
            result += String.valueOf(currentNumber);
        }
        return result;
    }
}