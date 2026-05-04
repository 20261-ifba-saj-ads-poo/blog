import java.util.ArrayList;
import java.util.List;

class Item {
    int id;
    String name;

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Item item = (Item) obj;
        return id == item.id;
    }

    public static void main(String [] args){
        Item i1 = new Item();
        i1.id = 1;
        //i1.name = "Item 1";
        Item i2 = new Item();
        i2.id = 1;
        //i2.name = "Item 1 de novo";
        List<Item> itens = new ArrayList<>();
        itens.add(i1);    
        if(!itens.contains(i2) ){
            itens.add(i2); 
        }


       
        
    }

    
}