import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int total = Integer.parseInt(br.readLine());
        int[] arr = new int[total];
        for (int i = 0; i < total; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        quickSort(arr, 0, total - 1);

        StringBuilder sb = new StringBuilder();
        for (int i : arr) {
            sb.append(i).append('\n');
        }
        System.out.println(sb);
    }

    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivot = partition(arr, low, high);

            quickSort(arr, low, pivot - 1);
            quickSort(arr, pivot + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int index = low - 1;
        int pivotValue = arr[high];
        for (int i = low; i <= high - 1; i++) {
            if (arr[i] < pivotValue) {
                index++;
                int temp = arr[index];
                arr[index] = arr[i];
                arr[i] = temp;
            }
        }
        int temp = arr[index + 1];
        arr[index + 1] = pivotValue;
        arr[high] = temp;

        return index + 1;
    }
}