
public class Sorter {

    public static void simple(int[] array) {

        int smallestIndex;
        boolean anomalyPresent;
        int cycleCounter = 0;       //счётчик итераций сортировки

        //Повторение цикла пока что-то меняется в массиве (как в пузырьке)
        //Это нужно на случай если в массиве два или больше элементов подряд
        //не на своём месте, и они идут по возрастанию
        do {
            anomalyPresent = false;

            //Поиск аномилии по всему массиву (текущий элемент больше следующего)
            for (int i = 0; i < array.length - 1; i++) {
                /*anomaly search*/

                //если i-тый элемент больше чем i+1-тый, то это аномалия (i-тый элемент)
                if (array[i] > array[i + 1]) {
                    /*anomaly found*/

                    //поиск наименьшего элемента в оставшейся (правой) части массива сразу после аномалии.
                    //Найденый наименьший и будет правильным элементом вместо аномального (i-того).
                    //оперирование происходит индексами, чтобы не создавать лишнюю переменную для наименьшего
                    smallestIndex = i + 1;

                    for (int j = smallestIndex; j < array.length - 1; j++) {
                        if (array[smallestIndex] > array[j + 1]) {
                            smallestIndex = j + 1;
                            cycleCounter++;
                        }
                    }

                    //ставим найденный наименьший на место аномалии,
                    //а аномалию на место найденного наименьшего
                    int tmp = array[i];
                    array[i] = array[smallestIndex];
                    array[smallestIndex] = tmp;

                    //аномалия была найдена, т.е. массив менялся
                    anomalyPresent = true;

                }
            }
        } while (anomalyPresent);   //повтор цикла поиска пока массив меняется

        //общее количество циклов по массиву
        System.out.println("cycleCounter: " + cycleCounter);
    }
}
