import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Quick Sort implemented with the Lomuto Partition Scheme
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        quickSort(arr, 0, N - 1);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(arr[i]);
            if (i < N - 1) {
                sb.append('\n');
            }
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
        int pivot = arr[high]; // temp pivot
        int checkedIndex = low - 1; // checked index initialized

        for (int i = low; i < high; i++) {
            // check if the left side of the pivot actually smaller than the pivot element
            if (arr[i] <= pivot) {
                checkedIndex++; // checked, and also sorted in broader terms

                // swap between the current one and the checked
                int temp = arr[checkedIndex];
                arr[checkedIndex] = arr[i];
                arr[i] = temp;
            }
        }
        // after checking
        // swap between the temp pivot and the checked + 1
        int temp = arr[high];
        arr[high] = arr[checkedIndex + 1];
        arr[checkedIndex + 1] = temp;

        return checkedIndex + 1;
    }
}