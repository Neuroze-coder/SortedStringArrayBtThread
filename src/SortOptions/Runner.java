package SortOptions;

/**
 * . Сортировка массива строк в нескольких потоках различными алгоритмами
 * (алгоритмы сортировки: сортировка вставками; сортировка выбором; сортировка пузырьком).
 * Определить время выполнения сортировки для разных алгоритмов.
 */

public class Runner {

    public static void main(String[] args) {

        String[] arrayOfStringsForSelectionSort = {"Cat", "Dog", "Frog", "Elephant", "Array", "Thread", "Java"};
        String[] arrayOfStringsForInsertionSort = {"Cat", "Dog", "Frog", "Elephant", "Array", "Thread", "Java"};
        String[] arrayOfStringsForBubbleSort = {"Cat", "Dog", "Frog", "Elephant", "Array", "Thread", "Java"};

        SelectionSort linkToTheCurrentStreamForSelectionSort = new SelectionSort(arrayOfStringsForSelectionSort, "SelectionSort");
        InsertionSort linkToTheCurrentStreamForInsertionSort = new InsertionSort(arrayOfStringsForInsertionSort, "InsertionSort");
        BubbleSort linkToTheCurrentStreamForBubbleSort = new BubbleSort(arrayOfStringsForBubbleSort, "BubbleSort");

        linkToTheCurrentStreamForSelectionSort.start();
        linkToTheCurrentStreamForInsertionSort.start();
        linkToTheCurrentStreamForBubbleSort.start();

        try {
            linkToTheCurrentStreamForSelectionSort.getThread().join();
            linkToTheCurrentStreamForInsertionSort.getThread().join();
            linkToTheCurrentStreamForBubbleSort.getThread().join();
        } catch (InterruptedException e) {
            System.out.println("Ошибка: " + e.getMessage());
            return;
        }

        linkToTheCurrentStreamForSelectionSort.outputOfResults();
        linkToTheCurrentStreamForInsertionSort.outputOfResults();
        linkToTheCurrentStreamForBubbleSort.outputOfResults();
    }
}
