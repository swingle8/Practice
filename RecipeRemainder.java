import java.io.*;
import java.util.*;
import java.util.stream.Collectors;


public class RecipeRemainder {
  /**
   * Complete the function below.And make sure to include required imports
   * DONOT MODIFY anything outside this function!
   */
  static int[]  calculateRemainders(int[] proportions,int[] availableGrams) {
    int propLen = proportions.length;
    int gramslen = availableGrams.length;
    int[] remaining_grams = new int[propLen];

    if (propLen != gramslen) {
      System.out.println("Inavlid data : Number of proportions don't match with the available grams.");
      return remaining_grams;
    }

    if (propLen == 0 || gramslen == 0) {
      System.out.println("No data found for calculations. Hence exiting the programme.");
      return remaining_grams;
    }

    int ratio = findRatio (proportions, availableGrams);

    for (int i = 0 ; i < propLen ; i ++) {
      int usedGrams = ratio * proportions[i];
      int remainingGrams = availableGrams[i] - usedGrams;
      remaining_grams[i] = remainingGrams;
    }

    return remaining_grams;

  }

  static int findRatio (int[] proportions, int[] availableGrams) {
    int ratio;
    int len = proportions.length;
    int [] allpotentialratios = new int[len];
    int j = 0;

    for (int i = 0 ; i < len ; i++) {
      if (availableGrams[i] % proportions[i] == 0) {
        int potentialRatio = availableGrams[i] / proportions[i];
        boolean hasRequiredGrams = isGramsAvailable(potentialRatio, len, proportions, availableGrams);
        if (hasRequiredGrams) {
          allpotentialratios[j] = potentialRatio;
          j ++;
        }
      }
    }

    ratio = maxRatio(allpotentialratios);

    return ratio;
  }


  static boolean isGramsAvailable (int potentialRatio, int len, int[] proportions, int[] availableGrams) {
    for (int i = 0 ; i < len ; i ++) {
      int gramsrequired = potentialRatio * proportions[i];
      if (gramsrequired <= availableGrams[i])
        continue;
      else
        return false;
    }
    return true;
  }

  static int maxRatio (int[] allpotentialratios) {
    int result = 0;
    int len = allpotentialratios.length;

    for (int i = 0 ; i < len ; i ++) {
      if (allpotentialratios[i] > result) {
        result = allpotentialratios[i];
      }
    }

    return result;
  }

  /**
   * DO NOT MODIFY THIS METHOD!
   */
  public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      int[] proportions = Arrays.stream(in.nextLine().split(", ")).mapToInt(Integer::valueOf).toArray();
      int[] availableGrams = Arrays.stream(in.nextLine().split(", ")).mapToInt(Integer::valueOf).toArray();

      int[] remainder = calculateRemainders(proportions,availableGrams) ;

      System.out.println(Arrays.stream(remainder)
                         .mapToObj(String::valueOf)
                         .collect(Collectors.joining(", ")));
   }
}
