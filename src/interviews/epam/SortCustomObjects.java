package interviews.epam;

import java.util.Comparator;
import java.util.List;

public class SortCustomObjects {
    public record Employee(int id, String name, long salary) {}

    /*
     * Use Java Streams to return a new list of employees ordered by salary
     * descending, then name ascending. Preserve input order when both fields
     * match. Leave the input list unchanged.
     *
     * Input: a List<Employee> with 0 to 100,000 employees. Each employee has
     * a unique int id, a name of 1 to 100 lowercase English letters, and a
     * long salary between 0 and 1,000,000,000 inclusive.
     * Output: a List<Employee> containing every employee in the required order.
     * An empty input gives an empty list.
     *
     * Example, with employees written as (id, name, salary):
     * [(1, "zoe", 90000), (2, "amy", 90000), (3, "li", 110000), (4, "amy", 90000)]
     * -> [(3, "li", 110000), (2, "amy", 90000), (4, "amy", 90000), (1, "zoe", 90000)]
     * [] -> []
     */
    public static List<Employee> sortEmployees(List<Employee> employees) {
        return employees.stream().sorted(Comparator.comparingLong(Employee::salary)
                .reversed().thenComparing(Employee::name)).toList();
    }
}
