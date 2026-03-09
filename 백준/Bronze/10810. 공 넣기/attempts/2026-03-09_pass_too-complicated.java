import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
        READING
         */

        // Construct a Reader object
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Take the first input
        String firstInput = br.readLine();
        String[] parts = firstInput.split(" ");

        // Assign variables from the first input
        int n = Integer.parseInt(parts[0].trim()); // array length
        int m = Integer.parseInt(parts[1].trim()); // number of overwriting

        // Instantiate MyArray class
        MyArray myArray = new MyArray(n);

        int[] parametersParsed = new int[3];

        // for-loop
        for (int i = 0; i < m; i++) {
            // Take the looped input and parse them
            String[] parameters = br.readLine().split(" ");
            for (int j = 0; j < 3; j++) {
                parametersParsed[j] = Integer.parseInt(parameters[j].trim());
            }

            // Call the method with the given parameters
            myArray.overwriteElements(parametersParsed[0], parametersParsed[1], parametersParsed[2]);
        }

        /*
        WRITING
         */
        // Print the result
        String result = Arrays.stream(myArray.array)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" "));
        System.out.println(result);

        // Manual close for resource management
        br.close();
    }

    private static class MyArray {
        private final int[] array;

        public MyArray(int n) {
            // Construct an array with the given variables
            this.array = new int[n]; // all elements are already initialized with 0 by default
        }

        /*
        FUNCTION
         */
        private void overwriteElements(int first, int last, int item) {
            for (int i = first - 1; i <= last - 1; i++) {
                array[i] = item;
            }
        }
    }
}
