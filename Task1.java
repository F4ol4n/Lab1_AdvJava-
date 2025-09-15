public class Task1 {
    
    public static int sortDigitsDescending(int num) {
        // Convert number into digits
        int[] digits = new int[10]; // max 10 digits for an int
        int count = 0;

        while (num > 0) {
            digits[count] = num % 10;
            num /= 10;
            count++;
        }

        // Bubble sort in descending order
        for (int i = 0; i < count - 1; i++) {
            for (int j = 0; j < count - i - 1; j++) {
                if (digits[j] < digits[j + 1]) {
                    int temp = digits[j];
                    digits[j] = digits[j + 1];
                    digits[j + 1] = temp;
                }
            }
        }

        // Combine sorted digits back into a number
        int result = 0;
        for (int i = 0; i < count; i++) {
            result = result * 10 + digits[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int num = 42145;
        int sortedNum = sortDigitsDescending(num);
        System.out.println("Original number: " + num);
        System.out.println("Sorted number: " + sortedNum);
    }
}
