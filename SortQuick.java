class SortQuick {
  public static void main (String [] args) {
    int [] arr = {1,3,2,5,12,6,17,11,14,9,1,4};
    int leng = arr.length;
    SortIt si = new SortIt();
    si.divideAndSort(arr, 0, leng-1);

    System.out.println("Sorted array is ");
    for (int i=0 ; i<leng ; i++) {
      System.out.println (arr[i]);
    }
  }
}

class SortIt {
  public void divideAndSort (int [] source, int start, int end) {
    if (start < end) {
      int middle = divideDescending (source, start, end);
      divideAndSort (source, start, middle-1);
      divideAndSort (source, middle+1, end);
    }
  }

  public int divideAscending (int [] source, int start, int end) {
    int pivot = source[end];
    int j = start-1;
    for (int i=start; i < end ; i++) {
      if (source[i] <= pivot) {
        j ++;
        int temp = source[i];

        source[i] = source[j];
        source[j] = temp;
      }
    }


    int temp = source[j+1];
        source[j+1] = source[end];
        source[end] = temp;
    j = j+1;
    // source[end] = source[j];
    // source[j] = pivot;
    return j;

  }


  public int divideDescending (int [] source, int start, int end) {
    int pivot = source[end];
    int j = start-1;
    for (int i=start; i < end ; i++) {
      if (source[i] >= pivot) {
        j ++;
        int temp = source[i];

        source[i] = source[j];
        source[j] = temp;
      }
    }


    int temp = source[j+1];
        source[j+1] = source[end];
        source[end] = temp;
    j = j+1;
    // source[end] = source[j];
    // source[j] = pivot;
    return j;

  }

}
