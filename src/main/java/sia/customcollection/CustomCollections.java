package sia.customcollection;


public class CustomCollections {

  public static <T extends Comparable<? super T>> void sort(CustomList<T> list) {
    list.sort();
  }

}
