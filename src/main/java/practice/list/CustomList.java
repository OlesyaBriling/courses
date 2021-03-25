package practice.list;


import java.util.Iterator;

public class CustomList<Element> implements Iterable<Element> {
    private Node<Element> first;
    private Node<Element> last;

    private int size;

    public void add (Element element) {
        if (first == null) {
            Node<Element> node = new Node<>(element, null,null);
            first = node;
            last = node;
            size++;
        } else {
            Node<Element> node = new Node<>(element,null, last);
            last.next = node;
            last = node;
            size++;
        }
    }

    public int size() {
        return size;
    }

    public Element first() {
        return first.item;
    }

    public Element last() {
        return last.item;
    }

    public void addFirst(Element element) {
          Node<Element> newFirstElement = new Node<>(element, first, null);
          Node<Element> tmpFirst = first;
          tmpFirst.prev = newFirstElement;
          first = newFirstElement;
          size++;
    }

    public Element get(int index) {
           return getIndex(index).item;
    }

    private Node<Element> getIndex(int index) {
        Node<Element> result = first;
        for (int i=0; i<index; i++) {
            result = result.next;
        }
        return result;
    }

    public void delete(int index) {
        Node<Element> deleteNode  = getIndex(index);
        Node<Element> elementBefore = deleteNode.prev;
        Node<Element> elementAfter = deleteNode.next;
        elementBefore.next = elementAfter;
        elementAfter.prev = elementBefore;
        size--;
    }

    @Override
    public Iterator<Element> iterator() {
        return new Iterator<Element>() {

            private Node<Element> current = first;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public Element next() {
               Node<Element> tmp = current;
               current = current.next;
               return tmp.item;
            }
        };
    }


    private static class Node<Element> {
       Node<Element> next;
       Node<Element> prev;
       Element item;

        public Node(Element item, Node<Element> next, Node<Element> prev) {
            this.next = next;
            this.prev = prev;
            this.item = item;
        }
    }
}
