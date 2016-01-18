package _27_NoClones;

public class StackImplNoClones<Item> implements StackInterface<Item> {
    private int size = 0;
    private Item[] a = (Item[]) new Object[10];

    public boolean isEmpty() {
        return size == 0;
    }

    private Item[] resizeUp(Item[] a_old) {
        Item[] b = (Item[]) new Object[a_old.length * 2];
        for (int i = 0; i < size; i++) {
            b[i] = a_old[i];
        }
        return b;
    }

    private boolean isDuplicate(Item item) {
        for (int i = 0; i < size; i++) {
            if (a[i].equals(item))
                return true;
        }
        return false;
    }

    public void push(Item item) {
        if (isDuplicate(item)) {
            System.out.println("The stack already contains " + item);

        } else {
            if (a.length == size) {
                a = resizeUp(a);
            }
            a[size++] = item;
        }
    }

    private Item[] resizeDown(Item[] a_old) {
        Item[] b = (Item[]) new Object[a_old.length / 2];
        for (int i = 0; i < size; i++) {
            b[i] = a_old[i];
        }
        return b;
    }

    public Item pop() {
        if (isEmpty()) {
            return null;
        }
        if (size < a.length / 4) {
            a = resizeDown(a);
        }
        Item item = a[--size];
        a[size] = null;
        return item;
    }

    public int length() {
        return size;
    }

    public void clear() {
        a = (Item[]) new Object[10];
        size = 0;
    }

    public static void main(String[] args) {
        StackImplNoClones<Integer> a = new StackImplNoClones<Integer>();
        System.out.println(a.pop());
        System.out.println(a.isEmpty());
        for (int i = 0; i < 200; i++) {
            a.push(i);
        }
        System.out.println(a.length());
        System.out.println(a.isEmpty());
        a.push(1);
        a.push(2);
        a.push(3);
        a.push(4);
        for (int i = 0; i < 200; i++) {
            a.pop();
        }
        System.out.println(a.length());
        System.out.println(a.isEmpty());
    }
}
