public class mergesort {
    static int[] array = {2,3,4,2,56,34,32,34,63,43,24,4,1};

    public static void sort(int[] array) {

    }

    public static void printArray(int[] array) {
        for (int i: array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
 
    public static void main(String[] args) {
        printArray(array);
        sort(array);
        printArray(array);
     }
}
