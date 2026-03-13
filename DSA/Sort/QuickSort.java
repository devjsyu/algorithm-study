// Lomuto Partition Scheme
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {10, 80, 30, 90, 40, 50, 70};
        System.out.println("Unsorted Array: " + Arrays.toString(arr));
        quickSort(arr, 0, arr.length - 1);
        System.out.println("Sorted Array: " + Arrays.toString(arr));
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