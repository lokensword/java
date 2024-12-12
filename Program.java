import java.util.Scanner;
import static org.example.Binary.binarySearch;
import static org.example.Binary.bubbleSort;

public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    System.out.print("Введите размерность массива: ");
    int size = in.nextInt();
    int[] array = new int[size];

    for (int i = 0; i < size; i++) {
        System.out.print("Введите элемент array[" + i + "]: ");
        array[i] = in.nextInt();
    }

    bubbleSort(array, size);

    System.out.println("Отсортированный массив:");
    for (int i = 0; i < size; i++) {
        System.out.println("Элемент array[" + i + "]:" + array[i] );
    }
    System.out.println("Введите искомый элемент:");
    int valueToFind = in.nextInt();

    int resultIndex = binarySearch(array, valueToFind, 0, size - 1);

    if (resultIndex == -1) {
        System.out.println("Элемент не найден");
    } else {
        System.out.println("Искомый элемент имеет индекс " + resultIndex);
    }
}
