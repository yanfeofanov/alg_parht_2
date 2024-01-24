package sky.pro.alg.parth2;

import java.util.Arrays;
import java.util.Objects;

public class IntegerListImpl implements IntegerList {

    private Integer[] storage;
    private int size;

    public IntegerListImpl(int intSize) {
        storage = new Integer[intSize];
        size = 0;
    }

    public IntegerListImpl(Integer... args) {
        storage = new Integer[args.length];
        System.arraycopy(args, 0, storage, 0, args.length);
        size = storage.length;
    }

    @Override
    public Integer add(Integer item) {
        if (size == storage.length) {
            grow();
        }
        storage[size] = item;
        size++;
        return item;
    }

    @Override
    public Integer add(int index, Integer item) {

        if (size >= storage.length) {  // Проверяем если фиксовая длинна равна длине массива то
            grow();    //  вызываем метод resize который увеличивает размер массива в 2х раза, выделяя новую область памяти и копирую туда
        }                             // предыдущий заполенный массив Пример oldArray[1,2,3,4,5] newArray[1,2,3,4,5,null,null,null,null,null]
        for (int i = size; i > index; i--) {    // бежим по длинне массива до указанного индекса с конца, начинаем перезаписывать ячейки
            storage[i] = storage[i - 1];        // Пример oldArray[1,2,3,4,5,null] newArray[1,2,3,4,5,5]
        }
        storage[index] = item;                  // По индексу перезаписываем получившиеся массив newArray[1,2,3,4,6,5]
        size++;
        return item;
    }


    @Override
    public Integer set(int index, Integer item) {
        checkBox(index);
        storage[index] = item;
        return item;
    }

    @Override
    public Integer remove(Integer item) {
        int index = indexOf(item);
        if (index == -1) {
            throw new ElementNotFindException();
        }
        return remove(index);
    }

    @Override
    public Integer remove(int index) {
        checkBox(index);
        Integer result = storage[index];
        for (int i = index; i < size; i++) {
            storage[i - 1] = storage[i];
        }
        size--;
        return result;
    }

    @Override
    public boolean contains(Integer item) {
        sort();
        return search(item);
    }

    @Override
    public int indexOf(Integer item) {
        for (int i = 0; i < size; i++) {
            if (storage[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Integer item) {
        for (int i = size; i >= 0; i--) {
            if (storage[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Integer get(int index) {
        checkBox(index);
        return storage[index];
    }

    @Override
    public boolean equals(IntegerList otherList) {
        if (otherList == null) {
            throw new ElementNotFindException();
        }
        if (size != otherList.size()) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (!Objects.equals(storage[i], otherList.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    @Override
    public Integer[] toArray() {
        Integer[] array = new Integer[size];
        return Arrays.copyOf(storage, size);
    }

    private void grow() {
        Integer[] storage = new Integer[(int) (this.storage.length * 1.5)];
        System.arraycopy(this.storage, 0, storage, 0, this.storage.length);
        this.storage = storage;
    }

    public void checkBox(int index) {
        if (index < 0 || index >= size) {
            throw new NullItemException();
        }
    }

    private void sort() {
        int in, out;
        for (out = 1; out < size; out++) {
            Integer temp = storage[out];
            in = out;
            while (in > 0 && storage[in - 1] >= temp) {
                storage[in] = storage[in - 1];
                in--;
            }
            storage[in] = temp;
        }
    }

    private boolean search(Integer item) {
        int lo = 0;
        int hi = size - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (storage[mid].compareTo(item) == 0) {
                return true;
            } else if (storage[mid].compareTo(item) < 0) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return false;
    }
}
