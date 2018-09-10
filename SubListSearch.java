// class LinkedList {
//     LinkedList next;
//     int value;
//     public LinkedList(int data) {
//         value = data;
//         next = null;
//     }
// }
import java.util.*;
class SubListSearch {
  public static void main (String [] args) {
    // LinkedList l0 = new LinkedList(5);
    // LinkedList l1 = new LinkedList(10);
    // LinkedList l2 = new LinkedList(20);
    // LinkedList l3 = new LinkedList(25);
    // LinkedList l4 = new LinkedList(17);
    // l0.next = l1;
    // l1.next = l2;
    // l2.next = l3;
    // l3.next = l4;
    //
    // LinkedList l5 = new LinkedList(5);
    // LinkedList l6 = new LinkedList(10);
    // LinkedList l7 = new LinkedList(20);
    // l5.next = l6;
    // l6.next = l7;

    LinkedList<Integer> ll = new LinkedList<Integer>();
    ll.add(5);
    ll.add(10);
    ll.add(20);
    ll.add(25);
    ll.add(17);

    LinkedList<Integer> lin = new LinkedList<Integer>();
    lin.add(20);
    lin.add(25);
    lin.add(17);

    SubListSearch ls = new SubListSearch();
    ls.SearchList(ll, lin);

  }

  public void SearchList (LinkedList<Integer> oldList, LinkedList<Integer> newList) {
    int i = 0 ;
    int len = newList.size();
    boolean found = false;
    boolean previous = false;
    for (int j : oldList) {
      int value = newList.get(i);
      if (j == value && (i == 0 || previous)) {
        previous = true;
        i++;
        if (i >= len) {
          found = true;
          break;
        }
      }
      else {
        previous = false;
        i =0;
      }

    }
    System.out.println(found);
  }
}
