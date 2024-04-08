package sia.customcollection;

import java.util.Objects;
import java.util.stream.Stream;

public class CustomArrayList<T extends Comparable<? super T>> implements CustomList<T>{

  private final int BEGIN_SIZE = 16;

  private Object[] array = new Object[BEGIN_SIZE];

  private int currentIndex = 0;

  public CustomArrayList(CustomList<? extends T> c) {
    addAll(c);
  }
  public CustomArrayList() {}

  @Override
  public int size() {
    return currentIndex;
  }

  @Override
  public void add(T element) {
    if (currentIndex == array.length - 1)
      resize(array.length * 2);
    array[currentIndex++] = element;
  }

  @Override
  public void add(int index, T element) {
    if (index < 0 || index > currentIndex) {
      throw new IndexOutOfBoundsException();
    }
    if (currentIndex == array.length) {
      resize(array.length * 2);
    }
    for (int i = currentIndex; i > index; i--) {
      array[i] = array[i - 1];
    }
    array[index] = element;
    currentIndex++;

  }

  @Override
  public void remove(int index) {
    if (index < 0 || index > currentIndex) {
      throw new IndexOutOfBoundsException();
    }
    for (int i = index; i < currentIndex - 1; i++)
      array[i] = array[i + 1];

    array[currentIndex - 1] = null;
    currentIndex--;
    if(array.length/2 > currentIndex)
      resize(array.length / 2);

  }

  @Override
  public T get(int index) {
    if (index < 0 || index > currentIndex) {
      throw new IndexOutOfBoundsException();
    }
    return (T) array[index];
  }

  @Override
  public void addAll(CustomList<? extends T> c) {
    for(int i = 0; i < c.size(); i++) {
      add(c.get(i));
    }
  }

  @Override
  public void sort() {
    for (int i = 0; i < currentIndex - 1; i++) {
      for (int j = 0; j < currentIndex - i - 1; j++) {
        //added here new lines to learn git
        T current = (T) array[j];
        T next = (T) array[j + 1];
        if (current.compareTo(next) > 0) {
          swap(j, j + 1);
        }
      }
    }
  }

  private void swap(int i, int j) {
    Object temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }

  public void print() {
    Stream.of(array)
        .filter(Objects::nonNull)
        .forEach(x -> System.out.print(x + " "));
    System.out.println(" ");
  }

  private void resize(int newLength) {
    Object[] newArray = new Object[newLength];
    System.arraycopy(array, 0, newArray, 0, currentIndex);
    array = newArray;

  }

}
