package interviews.epam;

import java.util.ArrayList;
import java.util.List;

import interviews.epam.SortCustomObjects.Employee;

public class SortCustomObjectsTest {
    /*
     * Use Streams to return a new list ordered by descending salary, then
     * ascending name, preserving ties and leaving the input list unchanged.
     * Input: 0 to 100,000 employees with unique int IDs, names of 1 to 100
     * lowercase English letters, and long salaries from 0 to 1,000,000,000.
     * Output: a List<Employee> containing every employee in the required order.
     * Example: [(1, "amy", 0), (2, "zoe", 1)] -> [(2, "zoe", 1), (1, "amy", 0)].
     * An empty list returns an empty list.
     */
    private record TestCase(String name, List<Employee> input, List<Employee> expected) {}

    public static void main(String[] args) {
        Employee zoe = new Employee(1, "zoe", 90_000);
        Employee firstAmy = new Employee(4, "amy", 90_000);
        Employee li = new Employee(3, "li", 110_000);
        Employee secondAmy = new Employee(2, "amy", 90_000);
        Employee minimum = new Employee(5, "amy", 0);
        Employee maximum = new Employee(6, "zoe", 1_000_000_000);
        TestCase[] cases = {
                new TestCase("salary, name, and stable ties",
                        new ArrayList<>(List.of(zoe, firstAmy, li, secondAmy)),
                        List.of(li, firstAmy, secondAmy, zoe)),
                new TestCase("salary boundaries", new ArrayList<>(List.of(minimum, maximum)),
                        List.of(maximum, minimum)),
                new TestCase("name ascending", new ArrayList<>(List.of(zoe, firstAmy)),
                        List.of(firstAmy, zoe)),
                new TestCase("stable ties independent of ID", new ArrayList<>(List.of(firstAmy, secondAmy)),
                        List.of(firstAmy, secondAmy)),
                new TestCase("unmodifiable input", List.of(zoe, li), List.of(li, zoe)),
                new TestCase("empty input", new ArrayList<>(), List.of())
        };

        int failures = 0;
        for (TestCase test : cases) {
            List<Employee> original = List.copyOf(test.input());
            try {
                List<Employee> actual = SortCustomObjects.sortEmployees(test.input());
                boolean correctOrder = test.expected().equals(actual);
                boolean unchangedInput = original.equals(test.input());
                boolean newList = actual != test.input();
                if (correctOrder && unchangedInput && newList) {
                    System.out.println("PASS " + test.name());
                } else {
                    failures++;
                    System.out.printf("FAIL %s: correct order=%b, input unchanged=%b, new list=%b%n",
                            test.name(), correctOrder, unchangedInput, newList);
                }
            } catch (RuntimeException exception) {
                failures++;
                System.out.println("FAIL " + test.name() + ": threw " + exception);
            }
        }
        System.out.println((cases.length - failures) + "/" + cases.length + " passed");
        if (failures > 0) {
            throw new AssertionError(failures + " test case(s) failed");
        }
    }
}
