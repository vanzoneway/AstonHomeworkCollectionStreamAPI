package sia.streamhomework;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PuttingIntoPractice {

  public static void main(String... args) {
    Trader raoul = new Trader("Raoul", "Cambridge");
    Trader mario = new Trader("Mario", "Milan");
    Trader alan = new Trader("Alan", "Cambridge");
    Trader brian = new Trader("Brian", "Cambridge");

    List<Transaction> transactions = Arrays.asList(
        new Transaction(raoul, 2011, 400),
        new Transaction(brian, 2011, 300),
        new Transaction(raoul, 2012, 1000),
        new Transaction(mario, 2012, 710),
        new Transaction(mario, 2012, 700),
        new Transaction(alan, 2012, 950)
    );

    /*
     * Task 1: all transactions for 2011 and sort them
     * bases on their summary
     */
    System.out.println("Task 1:");

    transactions.stream()
        .filter(t -> t.getYear() == 2011)
        .sorted(Comparator.comparingInt(Transaction::getValue))
        .forEach(x -> System.out.print(x.toString() + " "));

    System.out.println();

    /*
     * Task 2: do a set of all cities where traders work
     */

    System.out.println("Task 2:");

    System.out.print(
        transactions.stream()
            .map(x -> x.getTrader().getCity())
            .collect(Collectors.toSet())
    );

    System.out.println();

    /*
     * Task 3: find all from Cambridge and sort them
     */

    System.out.println("Task 3:");

    transactions.stream()
        .filter(t -> t.getTrader().getCity().equals("Cambridge"))
        .sorted(new Comparator<Transaction>() {
          @Override
          public int compare(Transaction t1, Transaction t2) {
            return t1.getTrader().getName().compareTo(t2.getTrader().getName());
          }
        })
        .forEach(x -> System.out.print(x.toString() + " "));

    System.out.println();

    /*
     * Task 4: find all names of various traders and sorted them in alphabet order
     */

    System.out.println("Task 4:");

    transactions.stream()
        .map(t -> t.getTrader().getName())
        .distinct()
        .sorted()
        .forEach(x -> System.out.print(x + " "));

    System.out.println();

    /*
     * Task 5: is any trader from Milan
     */
    System.out.println("Task 5:");

    System.out.print(
        transactions.stream()
            .anyMatch(x -> x.getTrader().getCity().equals("Milan"))
    );
    System.out.println();

    /*
     * Task 6: print values from Cambridge
     */

    System.out.println("Task 6:");

    transactions.stream()
        .filter(x -> x.getTrader().getCity().equals("Cambridge"))
        .map(x -> x.getValue())
        .forEach(x -> System.out.print(x + " "));

    System.out.println();

    /*
     * Task 7: max value from all transactions
     */

    System.out.println("Task 7:");

    System.out.print(
        transactions.stream()
            .map(Transaction::getValue)
            .max(Integer::compareTo)
            .get()
    );

    System.out.println();

    /*
     * Task 8: min value from all transactions
     */

    System.out.println("Task 8:");

    System.out.print(
        transactions.stream()
            .map(Transaction::getValue)
            .min(Integer::compareTo)
            .get()
    );

    System.out.println();


  }
}
