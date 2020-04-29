public class Main {
  public static void main(String[] args){
    IntRange intIter1 = new IntRange(10,0,-1);
    IntRange intIter2 = new IntRange(117,130);
    IntRange intIter3 = new IntRange(2147483640);
    IntRange intIter4 = new IntRange(2147483640, Integer.MAX_VALUE);

    Integer[] testArray1 = new Integer[]{1, 2, 3, 4, 5};
    String[] testArray2 = new String[]{"hallo","welt","foo"};
    ArrayIter arrayIter1 = new ArrayIter(testArray1);
    ArrayIter arrayIter2 = new ArrayIter(testArray2);
  }
}
