public class Task_02 {
    public static void main(String[] args) {
        // Вывод одномерного массива типа int
        public static void printArray(int[] array) {
            for (int element : array) {
                System.out.print(element + " ");
            }
            System.out.println();
        }

// Вывод одномерного массива типа String
        public static void printArray(String[] array) {
            for (String element : array) {
                System.out.print(element + " ");
            }
            System.out.println();
        }

// Вывод двухмерного массива типа int
        public static void printArray(int[][] array) {
            for (int[] row : array) {
                for (int element : row) {
                    System.out.print(element + " ");
                }
                System.out.println();
            }
        }

// Вывод двухмерного массива типа float
        public static void printArray(float[][] array) {
            for (float[] row : array) {
                for (float element : row) {
                    System.out.print(element + " ");
                }
                System.out.println();
            }
        }

        public static void main(String[] args) {
            int[] intArray = {1, 2, 3, 4, 5};
            printArray(intArray);

            String[] stringArray = {"Hello", "World"};
            printArray(stringArray);

            int[][] intMatrix = {{1, 2}, {3, 4}};
            printArray(intMatrix);

            float[][] floatMatrix = {{1.1f, 2.2f}, {3.3f, 4.4f}};
            printArray(floatMatrix);
        }

        Задание 3.
import java.util.Arrays;
import java.util.Comparator;

        public class Main {
            private String[] array;

            public Main(String[] array) {
                this.array = array;
            }

            // Вывод содержимого массива в строку через пробел
            public String arrayToString() {
                return String.join(" ", array);
            }

            // Сортировка массива в обратном порядке (без учета регистра) от z до a
            public void sortReverseOrder() {
                Arrays.sort(array, String.CASE_INSENSITIVE_ORDER.reversed());
            }

            // Сортировка массива по количеству слов в строке
            public void sortByWordCount() {
                Arrays.sort(array, Comparator.comparingInt(this::countWords));
            }

            // Метод для подсчета количества слов в строке
            private int countWords(String str) {
                return str.trim().split("\\s+").length;
            }

            public static void main(String[] args) {
                String[] array = {"Hello World", "Java is fun", "Programming is awesome"};
                Main utils = new Main(array);

                // Вывод содержимого массива в начальном порядке
                System.out.println("Исходный массив: " + utils.arrayToString());

                // Сортировка массива в обратном порядке
                utils.sortReverseOrder();
                System.out.println("Массив в обратном порядке: " + utils.arrayToString());

                // Сортировка массива по количеству слов в строке
                utils.sortByWordCount();
                System.out.println("Массив, отсортированный по количеству слов: " + utils.arrayToString());
            }
        }
            }
    }
}
