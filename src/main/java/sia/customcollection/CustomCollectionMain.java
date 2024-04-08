package sia.customcollection;

public class CustomCollectionMain {
  public static void main(String[] args) {


    CustomArrayList<String> p = new CustomArrayList<>();

    /*
     *Test CustomArrayLit and CustomCollections
     */
    p.add("Ivan");
    p.add("Ivanov");
    p.add("Arsen");
    p.add("Dima");
    p.add("Ruslan");
    p.remove(0);
    p.remove(1);

    p.print();

    CustomCollections.sort(p);

    p.print();



  }
}