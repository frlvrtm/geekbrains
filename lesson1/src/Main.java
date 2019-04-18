import java.util.Arrays;

public class Main {

    public static int[] arr = {2, 5, 3, 8, 0, 6, 1, 4, 14, 3};
    public static int[] arr7 = {3, 5, 1, 1, 1, 2, 1, 4, 1, 3};

    /**
     * 1. Задать целочисленный массив, состоящий из элементов 0 и 1.
     * Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
     * С помощью цикла и условия заменить 0 на 1, 1 на 0;
     */
    static void changeArr() {
        int[] arr = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                arr[i] = 1;
            } else {
                arr[i] = 0;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 2. Задать пустой целочисленный массив размером 8.
     * С помощью цикла заполнить его значениями 1, 4, 7, 10, 13, 16, 19, 22.
     */
    static void createArr() {
        int[] arr = new int[8];
        int j = 1;
        for (int i = 0; i < arr.length; i++, j += 3) {
            arr[i] = j;
        }
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 3. Создать метод, которому в качестве аргумента передается целочисленный массив.
     * Метод должен элементы массива, меньшие 6, умножить на 2.
     *
     * @param arr - массив
     */
    static void createArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) {
                arr[i] *= 2;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 4. Написать метод, которому в качестве параметра передается целое число.
     * Метод должен напечатать в консоль, положительное ли число передали или отрицательное.
     * Замечание: ноль считаем положительным числом.
     *
     * @param n - целое число
     */
    static void checkNumb(int n) {
        if (n >= 0) {
            System.out.println("Число положительное!");
        } else
            System.out.println("Число отрицательное!");
    }

    /**
     * 5. Написать метод, принимающий на вход два числа и проверяющий,
     * что их сумма лежит в пределах от 10 до 20 (включительно),
     * если да – вернуть true, в противном случае – false.
     *
     * @param a - первое число
     * @param b - второе число
     */
    static boolean checkSum(int a, int b) {
        int sum = a + b;
        if (sum >= 10 && sum <= 20) {
            return true;
        } else
            return false;
    }

    /**
     * 6. Задать одномерный массив и найти в нем минимальный и максимальный элементы.
     */
    static void findMaxMin() {
        int[] arr = {2, 5, 3, 8, 0, 6, 1, 4, 14, 3};
        System.out.println(Arrays.toString(arr));
        int min = arr[0];
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        System.out.println("Минимальный элемент: " + min);
        System.out.println("Максимальный элемент: " + max);
    }

    /**
     * 7. Написать метод, в который передается не пустой одномерный целочисленный массив.
     * Метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой части массива равны.
     * Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true, checkBalance([1, 1, 1, || 2, 1]) → true,
     * граница показана символами ||, эти символы в массив не входят.
     *
     * @param arr - массив
     */
    static boolean checkBalance(int[] arr) {
        int SumLeftPart = 0;
        int SumRightPart = 0;
        for (int i = 0; i < arr.length; i++) {
            SumLeftPart = 0;
            SumRightPart = 0;
            for (int j = 0; j < i; j++) {
                SumLeftPart += arr[j];
            }
            for (int j = i; j < arr.length; j++) {
                SumRightPart += arr[j];
            }
            if (SumLeftPart == SumRightPart) {
                return true;
            }
        }
        return false;
    }

    /**
     * 8. Написать метод, которому на вход подается одномерный массив и число n (может быть положительным, или отрицательным),
     * при этом метод должен сместить все элементы массива на n позиций.
     * Для усложнения задачи нельзя пользоваться вспомогательными массивами.
     *
     * @param arr - массив
     * @param n   - число
     */
    static void changeArr(int[] arr, int n) {
        if (n >= 0) {
            for (int i = 0; i < n; i++) {
                int tmp = arr[arr.length - 1];
                for (int j = arr.length - 1; j > 0; j--) {
                    arr[j] = arr[j - 1];
                }
                arr[0] = tmp;
            }
        } else if (n < 0) {
            for (int i = 0; i < n * (-1); i++) {
                int tmp = arr[0];
                for (int j = 0; j < arr.length - 1; j++) {
                    arr[j] = arr[j + 1];
                }
                arr[arr.length - 1] = tmp;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        System.out.println("Задание №1:");
        changeArr();
        System.out.println();
        System.out.println("Задание №2:");
        createArr();
        System.out.println();
        System.out.println("Задание №3:");
        System.out.println(Arrays.toString(arr));
        createArr(arr);
        System.out.println();
        System.out.println("Задание №4:");
        checkNumb(-2);
        System.out.println();
        System.out.println("Задание №5:");
        System.out.println(checkSum(5, 2));
        System.out.println();
        System.out.println("Задание №6:");
        findMaxMin();
        System.out.println();
        System.out.println("Задание №7:");
        System.out.println(checkBalance(new int[]{2, 2, 2, 1, 2, 2, 10, 1})); // true
        System.out.println(checkBalance(new int[]{1, 1, 1, 2, 1})); // true
        System.out.println(checkBalance(arr)); // false
        System.out.println(checkBalance(arr7)); // true
        System.out.println();
        System.out.println("Задание №8:");
        System.out.println(Arrays.toString(arr));
        changeArr(arr, 1);
    }
}
