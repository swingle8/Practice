class SelectionSort {
  public static void main (String [] args) {
    int [] data = new int [] {64, 25, 12, 22, 11};
    SelectionSort ss = new SelectionSort();
    ss.doSelectionSort(data);

    for (int i = 0 ; i < data.length ; i ++)
      System.out.println(data[i]);
  }

  public void doSelectionSort(int [] data) {
      int len = data.length;
      int min = Integer.MAX_VALUE;
      int location = -1;
      int start = 0;

      while (start < len) {

      for (int i = start ; i < len ; i ++) {
          if (min > data[i]) {
            min = data[i];
            location = i;
          }
      }

      int value = data[start];
      data[start] = min;
      data[location] = value;
      start ++;
      min = Integer.MAX_VALUE;
      }
  }
}
