package interviews.epam;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalLong;

public class SecondHighestSalaryTest {
    /*
     * Use Java Streams to find the second-highest distinct salary in a list
     * of 0 to 100,000 employees. Salaries are long values in [0, 1,000,000,000].
     * Return an OptionalLong, empty when fewer than two distinct salaries exist.
     * Examples: [90000, 120000, 120000, 105000] -> 105000;
     * [75000, 75000] -> empty; [50000, 0] -> 0; [] -> empty.
     */
    private record TestCase(String name, OptionalLong expected, long... salaries) {}

    public static void main(String[] args) {
        long[] maximumInput = new long[100_000];
        Arrays.fill(maximumInput, 1_000_000_000L);
        maximumInput[maximumInput.length - 1] = 1;
        TestCase[] cases = {
                new TestCase("duplicate maximum", OptionalLong.of(105_000), 90_000, 120_000, 120_000, 105_000),
                new TestCase("all equal", OptionalLong.empty(), 75_000, 75_000),
                new TestCase("empty list", OptionalLong.empty()),
                new TestCase("one employee", OptionalLong.empty(), 75_000),
                new TestCase("salary boundaries", OptionalLong.of(0), 0, 1_000_000_000),
                new TestCase("duplicate second-highest", OptionalLong.of(2), 2, 1, 2, 3),
                new TestCase("maximum input size", OptionalLong.of(1), maximumInput)
        };

        int failures = 0;
        for (TestCase test : cases) {
            List<SecondHighestSalary.Employee> employees = Arrays.stream(test.salaries())
                    .mapToObj(SecondHighestSalary.Employee::new)
                    .toList();
            try {
                OptionalLong actual = SecondHighestSalary.secondHighestSalary(employees);
                if (test.expected().equals(actual)) {
                    System.out.println("PASS " + test.name());
                } else {
                    failures++;
                    System.out.printf("FAIL %s: expected %s, got %s%n", test.name(), test.expected(), actual);
                }
            } catch (RuntimeException exception) {
                failures++;
                System.out.printf("FAIL %s: expected %s, threw %s%n", test.name(), test.expected(), exception);
            }
        }
        System.out.println((cases.length - failures) + "/" + cases.length + " passed");
        if (failures > 0) {
            throw new AssertionError(failures + " test case(s) failed");
        }
    }
}
