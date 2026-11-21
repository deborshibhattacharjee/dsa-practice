package interviews.epam;

import java.util.Comparator;
import java.util.List;
import java.util.OptionalLong;

public class SecondHighestSalary {
    public record Employee(long salary) {}

    /*
     * Use the Java Stream API to find the second-highest distinct salary.
     * Employees with the same salary count as one distinct salary.
     *
     * Input: a List<Employee> with 0 to 100,000 employees. Each employee
     * has a long salary between 0 and 1,000,000,000 inclusive.
     * Output: an OptionalLong containing the second-highest distinct salary,
     * or OptionalLong.empty() if fewer than two distinct salaries exist.
     *
     * Examples (shown as salaries):
     * [90000, 120000, 120000, 105000] -> OptionalLong.of(105000)
     * [75000, 75000] -> OptionalLong.empty()
     * [50000, 0] -> OptionalLong.of(0)
     * [] -> OptionalLong.empty()
     */
    public static OptionalLong secondHighestSalary(List<Employee> employees) {
        return employees.stream()
                .map(Employee::salary)
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .mapToLong(Long::longValue)
                .findFirst();
    }
}
