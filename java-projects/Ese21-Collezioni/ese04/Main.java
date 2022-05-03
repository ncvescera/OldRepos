package ese04;

import java.util.List;
import java.util.ArrayList;

public class Main {
  public static void main(String[] args) {
    Integer[] a = {1,2,3,4,5,6,7,8,9};
    List<Integer> result_a = minoriDi(a,4);
    System.out.println(result_a);

    Float[] b = {1.1f, 2.2f, 3.3f};
    List<Float> result_b = minoriDi(b,3f);
    System.out.println(result_b);

    Double[] c = {2.3, 4.5, 7.8, 10.2, 9.3};
    List<Double> result_c = minoriDi(c,6.0);
    System.out.println(result_c);

  }

  public static <T extends Number> List<T> minoriDi(T[] array, T val){
    List<T> result = new ArrayList<T>();

    for(int i = 0; i < array.length; i++){
      if(array[i].doubleValue() < val.doubleValue()){
        result.add(array[i]);
      }
    }

    return result;
  }
}
