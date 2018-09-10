class ElementSearch {
  public static void main (String [] args) {
    int arr [] = new int [] {1, 2, 4, 6, 7, 9, 11, 14, 16, 19, 21};

    LinearSearchOne lso = new LinearSearchOne(arr);
    System.out.println(lso.searchData(3));

    BinarySearch bs = new BinarySearch(arr);
    System.out.println(bs.searchData(3));

    JumpSearch js = new JumpSearch(arr);
    System.out.println(js.searchData(9));

  }
}

  interface Search {
    //public void setArray (int [] data);
    public int searchData (int value);
  }

  abstract class setSearch {
    int [] baseData;
    int length;
    int answer = -1;
    public setSearch (int [] data) {
        baseData = data;
        length = data.length;
    }
  }

  class LinearSearchOne extends setSearch implements Search {

    public LinearSearchOne (int [] data) {
        super (data);
    }

    public int searchData (int value) {
        for (int i = 0 ; i < length ; i ++) {
          if (baseData[i] == value) {
            answer = i+1;
            break;
          }
        }

        return answer;
    }
  }

  class BinarySearch extends setSearch implements Search {
    int searching;
    public BinarySearch (int [] data) {
        super (data);
    }

    public int searchData (int value) {
      searching = value;
      findElement(0, length-1);
      return answer;
    }

    private void findElement (int start, int max) {
      int mid = (start + max)/2;
      int selData = baseData[mid];
      if (mid == start || mid == max) {
        answer = -1;
        return;
      }

      if (selData < searching) {
        findElement(mid, max);
      }
      else if (selData > searching) {
        findElement(start, mid);
      }
      else if (selData == searching){
        answer = (mid+1);
      }
    }

  }


class JumpSearch extends setSearch implements Search {
  int searching;
  int jump;
  public JumpSearch (int [] data) {
    super (data);
    jump = (int) Math.sqrt(length);
  }

  public int searchData (int value) {
    searching = value;
    int diff = Integer.MAX_VALUE;
    int index = 0;
    for (int i = 0 ; i < length ; i = i+jump) {
      int differ = searching - baseData[i];
      if (differ < 0) {
        index = i-jump;
        break;
      }
      else if(differ == 0)
        answer = i+1;
    }
    boolean found = false;
    for (int j = index ; j< (index+jump) ; j++) {
      int differ = searching - baseData[j];
      if (differ == 0) {
        answer = j+1;
        found = true;
        break;
      }
    }
    if (found == false)
      return -1;
    return answer;
  }
}

