package code.homework2;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 15 тугриков
 * Реализовать все методы односвязного списка.
 */
public class CustomLinkedList implements Iterable<Integer> {
    private static final String DELIMITER = " -> ";
    private static final String NULL_ELEMENT = "null";

    private Node head;
    private Node tail;
    private int size;
    private int counterOfModifications;

    /**
     * 1 тугрик
     * Возвращает количество элементов в списке
     *
     * @return size
     */
    public int size() {
        return size;
    }

    /**
     * 2 тугрика
     * Реализовать метод:
     * Добавляет элемент в односвязный список.
     *
     * @param value - data for create Node.
     */
    public void add(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
        } else {
            tail.setNext(newNode);
        }
        tail = newNode;
        size++;
        counterOfModifications++;
    }

    /**
     * 2 тугрика
     * Метод должен вернуть число на соответствующем индексе.
     *
     * @param index
     */
    public int get(int index) {
        checkIndex(index);
        return getNode(index).value;
    }

    /**
     * 2 тугрика
     * Реализовать метод:
     * Добавляет элемент в односвязный список на заданную позицию.
     * Если был передан невалидный index - надо выкинуть исключение IndexOutOfBoundsException.
     * throw new IndexOutOfBoundsException(i);
     *
     * @param i     - index
     * @param value - data for create Node.
     */
    public void add(int i, int value) {
        if (i < 0 || i > size) {
            throw new IndexOutOfBoundsException();
        }
        Node newNode = new Node(value);
        if (i == 0) {
            newNode.setNext(head);
            head = newNode;
        } else if (i == size) {
            add(value);
            return;
        } else {
            Node previousNode = getNode(i - 1);
            newNode.setNext(previousNode.next);
            previousNode.setNext(newNode);
        }
        counterOfModifications++;
        size++;
    }

    /**
     * 2 тугрика
     * Реализовать метод:
     * Удаляет элемент в указанной позиции, при это связывая его соседние элементы друг с другом.
     * Если был передан невалидный index - надо выкинуть исключение IndexOutOfBoundsException.
     * throw new IndexOutOfBoundsException(i);
     *
     * @param index - position what element need remove.
     */
    public void removeElement(int index) {
        checkIndex(index);
        if (index == 0) {
            head = head.next;
        } else {
            Node previousNode = getNode(index - 1);
            previousNode.setNext(previousNode.next.next);
            if (size == index + 1) {
                tail = previousNode;
            }
        }
        counterOfModifications++;
        size--;
    }

    /**
     * 2 тугрика
     * Реализовать метод:
     * Переворачивает все элементы списка.
     * Пример:
     * Исходная последовательность списка "1 -> 2 -> 3 -> 4 -> null"
     * После исполнения метода последовательность должна быть такой "4 -> 3 -> 2 -> 1 -> null"
     */
    public void revertList() {
        Node previousNode = null;
        Node currentNode = head;
        Node nextNode = null;
        tail = head;
        while (currentNode != null) {
            nextNode = currentNode.next;
            currentNode.setNext(previousNode);
            previousNode = currentNode;
            currentNode = nextNode;
        }
        head = previousNode;
        counterOfModifications++;
    }

    /**
     * 1 тугрик
     * Метод выводит всю последовательность хранящуюся в списке начиная с head.
     * Формат вывода:
     * - значение каждой Node должно разделяться " -> "
     * - последовательность всегда заканчивается на null
     * - если в списке нет элементов - верните строку "null"
     *
     * @return - String with description all list
     */
    @Override
    public String toString() {
        if (size == 0) {
            return NULL_ELEMENT;
        }
        Node currentNode = head;
        StringBuilder result = new StringBuilder();
        while (currentNode != null) {
            result.append(currentNode.value);
            result.append(DELIMITER);;
            currentNode = currentNode.next;
        }
        return result.append(NULL_ELEMENT).toString();
    }

    /**
     * 3 тугрика
     * Возвращает итератор, который умеет только итерироваться. БЕЗ удаления!
     *
     * @return iterator
     */
    @Override
    public Iterator<Integer> iterator() {
        return new CustomLinkedListIterator();
    }

    private Node getNode(int index) {
        checkIndex(index);
        if (index == size - 1) {
            return tail;
        }
        Node nextNode = head;
        int counter = 0;
        while (counter != index) {
            nextNode = nextNode.next;
            counter++;
        }
        return nextNode;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }

    private class CustomLinkedListIterator implements Iterator<Integer> {
        private Node currentNode;
        private final int numberOfModifications = counterOfModifications;

        public CustomLinkedListIterator() {
            currentNode = head;
        }

        @Override
        public boolean hasNext() {
            return currentNode != null;
        }

        @Override
        public Integer next() {
            if (numberOfModifications != counterOfModifications) {
                throw new ConcurrentModificationException();
            }
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            int result = currentNode.value;
            currentNode = currentNode.next;
            return result;
        }
    }

    private static class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}
