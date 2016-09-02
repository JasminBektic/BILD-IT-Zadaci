package zadaci_02_09_2016;

import java.util.ArrayList;

public class MyStack implements Cloneable {
    private ArrayList<Object> list = new ArrayList<>();
 
    public boolean isEmpty() {
        return list.isEmpty();
    }
    //metoda za velicinu
    public int getSize() {
        return list.size();
    }
    //metoda vraca top element sa liste
    public Object peek() {
        return list.get(getSize() - 1);
    }
    //metoda vraca zadnji element i brise ga
    public Object pop() {
        Object o = list.get(getSize() - 1);
        list.remove(getSize() - 1);
        return o;
    }
    //metoda koja dodaje novi element
    public void push(Object o) {
        list.add(o);
    }

    @Override 
    //metoda za ispis
    public String toString() {
        return list.toString();
    }

    @Override
    //metoda koja kopira iz liste u listu
    public Object clone() throws CloneNotSupportedException  {
        MyStack stack = (MyStack) super.clone();
        stack.list = new ArrayList<>(list);
        return stack;
    }
}