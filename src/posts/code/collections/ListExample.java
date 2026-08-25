import java.util.ArrayList;
import java.util.List;

class ListExample {
    public static void main(String[] args){
        int n = 5;
        List<Integer> arrli = new ArrayList<Integer>(n);
        for (int i = 1; i <= n; i++){
            arrli.add(i);
        }
        IO.println(arrli);
        arrli.remove(3);
        IO.println(arrli);
        arrli.set(1, 10);
        IO.println(arrli);
        for (Integer integer : arrli.subList(1, 3)) {
            IO.print(integer + " ");
        }

    }
}