
public class GenericsTest {
    public static void main(String args[]) {
    // String type test
        Test<String> test1 = new Test<String>("Test String.");
        test1.showItemDetails();

        // Integer type test
        Test<Integer> test2 = new Test<Integer>(100);
        test2.showItemDetails();
    }
}

class Test<T> {
    private T item;

    public Test(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }

    public void showItemDetails() {
        System.out.println("Value of the item: " + item);
        System.out.println("Type of the item: " + item.getClass().getName());
    }
}
