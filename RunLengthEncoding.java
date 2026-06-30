import java.util.Scanner;

public class RunLengthEncoding {

    public static String compress(String input) {
        StringBuilder compressed = new StringBuilder();
        int i = 0;

        while (i < input.length()) {
            char current = input.charAt(i);
            int count = 1;

            while (i + count < input.length() && input.charAt(i + count) == current) {
                count++;
            }

            compressed.append(count);
            compressed.append(current);
            i += count;
        }

        return compressed.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the string to be compressed: ");
        String input = scanner.nextLine();
        scanner.close();

        String compressed = compress(input);
        System.out.println("Compressed as: " + compressed);

        double ratio = ((double) compressed.length() / input.length()) * 100;
        System.out.printf("%.1f%%", ratio);

        if (ratio > 100) {
            System.out.printf(" (because the 'compressed' version is actually %.1f%% longer than the original!)\n", ratio - 100);
        } else if (ratio < 100) {
            System.out.printf(" (the compressed version is %.1f%% shorter than the original)\n", 100 - ratio);
        } else {
            System.out.println(" (same length as the original)");
        }
    }
}
