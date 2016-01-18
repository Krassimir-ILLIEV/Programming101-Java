package _28_OnTwoFronts;

public class TwoFronts<Item> implements StackInterfaceDLL<Item> {

    private int size = 0;
    private Node first, last;

    private class Node {

        Item item;
        Node previous;
        Node next;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(Item item) {
        if (first == null) {
            first = new Node();
            first.item = item;
            last = first;

        } else {
            Node oldfirst = first;
            first = new Node();
            first.item = item;
            first.next = oldfirst;
            oldfirst.previous = first;
        }
        size++;
    }

    public Item remove() {
        if (isEmpty()) {
            return null;
        }
        Item item = first.item;
        first = first.next;
        if (first != null) {
            first.previous = null;
        } else
            last = null;
        size--;
        return item;
    }

    public int size() {
        return size;
    }

    public void clear() {
        first = null;
        last = null;
        size = 0;
    }

    public Item get(int elementIndex) { // starts from 0
        if (size <= elementIndex)
            return null;
        Node currentNode = first;
        for (int i = 0; i < elementIndex; i++) {
            currentNode = currentNode.next;
        }
        return currentNode.item;
    }

    public Item getFirst() {
        if (isEmpty())
            return null;
        return first.item;
    }

    public Item getLast() {
        if (isEmpty())
            return null;
        return last.item;
    }

    public static void main(String[] args) {
        TwoFronts<Integer> a = new TwoFronts<Integer>();
        System.out.println(a.remove());
        System.out.println(a.isEmpty());
        for (int i = 0; i < 200; i++) {
            a.add(i);
        }
        System.out.println(a.getFirst());
        System.out.println(a.getLast());
        System.out.println(a.size());
        System.out.println(a.isEmpty());
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);
        for (int i = 0; i < 200; i++) {
            a.remove();
        }
        System.out.println(a.size());
        System.out.println(a.isEmpty());
    }
}
