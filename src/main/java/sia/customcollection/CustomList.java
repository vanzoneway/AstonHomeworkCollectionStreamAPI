package sia.customcollection;


public interface CustomList<T> {

  void add(T element);

  void add(int index, T element);

  void remove(int index);

  T get(int index);

  void addAll(CustomList<? extends T> other);

  int size();

  void sort();



}
