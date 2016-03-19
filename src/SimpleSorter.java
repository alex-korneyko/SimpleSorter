
public class SimpleSorter {

    public static final int ARRAY_SIZE = 200;       //Array size
    public static final int SWAP_COUNT = 5;        //Количество поменяных местами пар элементов

    public static void main(String[] args) {

        int[] mainArray = new int[ARRAY_SIZE];

        //Просто сортированный массив {0...ARRAY_SIZE-1}
        for (int i = 1; i < mainArray.length; i++) {
            mainArray[i] = mainArray[i - 1] + 1;
        }

        //обмен местами пар элементов массива
        for (int i = 1; i <= SWAP_COUNT; i++) {
            int firstIndex = (int) (Math.random() * ARRAY_SIZE);
            int secondIndex = (int) (Math.random() * ARRAY_SIZE);

            //swap
            int tmp = mainArray[firstIndex];
            mainArray[firstIndex] = mainArray[secondIndex];
            mainArray[secondIndex] = tmp;

            //what swapped
            //System.out.println("Swapped: " + firstIndex + " and " + secondIndex);
        }

        //Массив заданный вручную (раскомментировать), предыдущие 17 строк нужно закомментировать
//        int[] mainArray = {0, 1, 2, 3, 4, 5, 6, 7, 8, 16, 10, 11, 12, 13, 14, 15};

        //Вывод несортированного массива
        for (int element : mainArray) {
            System.out.print(element + " ");
        }
        System.out.println();

        //Сортировка
        Sorter.simple(mainArray);

        //Вывод сортированного массива
        for (int element : mainArray) {
            System.out.print(element + " ");
        }

        //проверка, что массив действительно отсортирован по возрастанию
        //чтобы глазами не искать
        for (int i = 0; i < mainArray.length - 1; i++) {
            if (mainArray[i] > mainArray[i + 1]) {
                System.out.println("\nArray is not sorted!");
                break;
            }
        }
    }
}
