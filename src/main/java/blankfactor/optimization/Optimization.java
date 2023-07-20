package blankfactor.optimization;

import java.util.*;

public class Optimization {
    public static void main(String[] args) {
        Random rand = new Random();
        int numN = 50000;

        List<Integer> list = new ArrayList<>(numN);

        StringBuilder sb = new StringBuilder(); //"1 2 1 2 1 2 4 2 6 3 2 1 4"
        for (int i = 0; i < numN; i++) {
            sb.append(rand.nextInt(numN)).append(" ");
        }

        String inputString = sb.toString();
        System.out.println("Input: " + inputString);

        List<Integer> resultSlow;
        List<Integer> resultFast;

        resultSlow = slow(inputString);
        long startTime = System.currentTimeMillis();
        resultFast = fast(inputString);
        long endTime = System.currentTimeMillis();

        if (!resultSlow.equals(resultFast)) {
            System.out.println("Error!!! Not Equal results!");
        }

        System.out.println("Max Jumps: " + resultSlow.stream().mapToInt(i -> i).max().orElse(0));
        System.out.println("Jumps: " + resultSlow.subList(0, Math.min(50, resultSlow.size())));

        System.out.println("Execution Time: " + (endTime - startTime) + " ms");
    }

    static List<Integer> fast(String inputNumbers) {
        String[] numberStrings = inputNumbers.trim().split(" ");
        int numN = numberStrings.length;
        int[] numbers = new int[numN];

        for (int i = 0; i < numN; i++) {
            numbers[i] = Integer.parseInt(numberStrings[i]);
        }

        int[] maxJumps = new int[numN];
        maxJumps[numN - 1] = 0;

        Stack<Integer> stack = new Stack<>();
        stack.push(numN - 1);

        for (int i = numN - 2; i >= 0; i--) {
            while (!stack.isEmpty() && numbers[i] >= numbers[stack.peek()]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                maxJumps[i] = 0;
            } else {
                maxJumps[i] = maxJumps[stack.peek()] + 1;
            }

            stack.push(i);
        }

        List<Integer> result = new ArrayList<>();
        for (int jumps : maxJumps) {
            result.add(jumps);
        }

        return result;
    }

    static List<Integer> slow(String inputNumbers) {
        String[] numberStrings = inputNumbers.trim().split(" ");
        int numN = numberStrings.length;

        int[] numbers = new int[numN];
        for (int i = 0; i < numN; i++) {
            numbers[i] = Integer.parseInt(numberStrings[i]);
        }

        int initialJump = 0;
        int next = 0;

        List<Integer> list = new ArrayList<>(numN);

        int counter = 0, max = Arrays.stream(numbers).max().orElse(0);
        for (int i = 0; i < numN; i++) {
            initialJump = numbers[i];
            // partial optimization
            if (initialJump == max) {
                list.add(0);
                continue;
            }
            for (int j = i + 1; j < numN; j++) {
                next = numbers[j];
                if (initialJump < next) {
                    counter++;
                    initialJump = next;
                }
            }
            list.add(counter);
            counter = 0;
        }

        return list;
    }
}