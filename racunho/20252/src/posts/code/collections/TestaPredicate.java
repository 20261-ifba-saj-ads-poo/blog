import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;
import java.util.function.Predicate;

public class TestaPredicate {
    public static void main(String[] args) {
        Predicate<String> isNull = Objects::isNull;
        Predicate<String> isEmpty = String::isEmpty;
        Predicate<String> isNullOrEmpty = isNull.or(isEmpty);

        Collection<String> strings = new ArrayList<>();
        strings.add(null);
        strings.add("");
        strings.add("one");
        strings.add("two");
        strings.add("");
        strings.add("three");
        strings.add(null);

        System.out.println("strings = " + strings);
        strings.removeIf(isNullOrEmpty);
        System.out.println("filtered strings = " + strings);
    }
}