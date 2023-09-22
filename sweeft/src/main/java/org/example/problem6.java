package org.example;

public class problem6 {

    public static class CustomCollection<E> {
        private static final int DEFAULT_CAPACITY = 10;

        private Object[] data;
        private boolean[] deletedFlags;  // To track deleted elements
        private int size;

        public CustomCollection() {
            this(DEFAULT_CAPACITY);
        }

        public CustomCollection(int capacity) {
            data = new Object[capacity];
            deletedFlags = new boolean[capacity];
            size = 0;
        }

        private int hash(int hashCode) {
            return Math.abs(hashCode) % data.length;
        }

        public void add(E element) {
            if(element == null) {
                throw new IllegalArgumentException("Null elements are not allowed");
            }
            int hashCode = element.hashCode();
            int index = hash(hashCode);

            while (data[index] != null && !deletedFlags[index]) {
                index = (index + 1) % data.length;
            }

            data[index] = element;
            deletedFlags[index] = false;
            size++;
        }

        public void delete(E element) {
            if(element == null) {
                return;
            }
            int hashCode = element.hashCode();
            int index = hash(hashCode);

            while (data[index] != null) {
                if (!deletedFlags[index] && data[index].equals(element)) {
                    deletedFlags[index] = true;
                    size--;
                    return;
                }
                index = (index + 1) % data.length;
            }
        }

        public boolean contains(E element) {
            if(element == null) {
                return false;
            }
            int hashCode = element.hashCode();
            int index = hash(hashCode);

            while (data[index] != null) {
                if (!deletedFlags[index] && data[index].equals(element)) {
                    return true;
                }
                index = (index + 1) % data.length;
            }

            return false;
        }

        public int size() {
            return size;
        }

        public static void main(String[] args) {
            CustomCollection<Integer> collection = new CustomCollection<>();
            collection.add(1);
            collection.add(2);
            collection.add(3);

            System.out.println("Collection before deletion:");
            System.out.println(collection.contains(2));

            collection.delete(2);

            System.out.println("\nCollection after deletion:");
            System.out.println(collection.contains(2));
        }
    }

    public static void main(String[] args) {
        CustomCollection.main(args);
    }
}
