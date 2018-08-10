class Pythagorean {
    public static void main (String [] args) {
        int [] arr = {3, 1, 4, 6, 5};
        FetchPythagorean fp = new FetchPythagorean();
        boolean answer = fp.isPythagorean(arr);
        System.out.println(answer);
    }
}

class FetchPythagorean {
  public boolean isPythagorean (int [] question) {
    boolean answer = false;
    int len = question.length;

    for (int i = 0 ; i < len ; i ++) {
      question[i] = question[i] * question[i];
    }

    SortIt sq = new SortIt();
    sq.divideAndSort(question, 0, len-1);
    boolean stop = false;

    for (int i=len-1 ; i >= 0 ; i--) {
        int max = question[i];
        for (int j = 0 ; j < i-1 ; j ++) {
          int a = question[j];
          int b = question[j+1];
          int sum = a + b;
          if (sum == max) {
            answer = true;
            stop = true;
            break;
          }
        }

        if (stop == true)
          break;
    }

    return answer;
  }
}
