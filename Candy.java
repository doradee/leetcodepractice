package solutions;

import java.util.Arrays;

/*
 There are N children standing in a line. Each child is assigned a rating value.
 You are giving candies to these children subjected to the following requirements:
 Each child must have at least one candy.
 Children with a higher rating get more candies than their neighbors.
 What is the minimum candies you must give?
 */
public class Candy {
  /* Accepted. learned from 9z. The idea is scan twice from both direction. 
   * first from head to tail to ensure higher rating kid got more candy than ex
   * second from tail to head to ensure higher rating kid got more candy than post
   */
  public static int candy(int[] ratings) {
    int sum = 0;
    if (ratings == null || ratings.length == 0) {
      return sum;
    }
    int[] candies = new int[ratings.length];
    Arrays.fill(candies, 1); // at least one candy satisfied
    for (int i = 1; i < ratings.length; i++) {
      if (ratings[i] > ratings[ i - 1]) {
        candies[i] = candies[i - 1] + 1; 
      }
    }
    
    for (int i = ratings.length - 1; i > 0; i--) {
      sum+=candies[i];
      if (ratings[i - 1] > ratings[i] && candies[i - 1] <= candies[i]) {
        candies[i - 1] = candies[i] + 1;
      }
    }
    sum+= candies[0];
    
    return sum;
  }
  
  
  /* first attempt. Wrong solution. Too complex and not correct */
  public static int candy_Failed(int[] ratings) {
    if (ratings == null) {
      return 0;
    }
    if (ratings.length <= 1) {
      return ratings.length;
    }
    int[] candies = new int[ratings.length];
    candies[0] = 1;
    for (int i = 1; i < ratings.length; i++) {
      if (ratings[i] > ratings[i - 1]) {
        candies[i] = candies[i - 1] + 1;
      } else {
        /*
         * ratings[i]<ratings[i - 1]. we need to find a continuous decreasing
         * range, so that the min in this range is 1,
         */
        int j = i;
        int count = 1;
        while (j < ratings.length - 1 && ratings[j] > ratings[j + 1]) {
          count++;
          j++;
        }
        if (i == 1) {
          candies[0] = count + 1;
        }
        while (count > 0) {
          candies[i] = count;
          count--;
          ++i;
        }
      }
    }
    int sum = 0;
    for (int i : candies) {
      sum += i;
    }
    return sum;
  }
  
  public static void main(String[] args) {
    int[] ratings = { 2, 2 };
    System.out.println(candy(ratings));
  }
}
