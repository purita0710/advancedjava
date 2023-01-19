public class quicksort{
    static int[] array = {2,3,4,2,56,34,32,34,63,43,24,4,1};

    public static void sort(int start, int end) {
        int pivot = array[(start+end)/2];

        int left = start;
        int right = end;

        while(left<=right){
            while(array[left]<pivot) left++;
            while(array[right]>pivot) right--;

            if(left<=right){
                int temp = array[right];
                array[right] = array[left];
                array[left] = temp;

                left ++;
                right--;
            }

            if(left<end) sort(left,end);
            if(start<right) sort(start,right);
        }
    }
   

    public static void printArray(int[] array) {
        for (int i: array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
 
    public static void main(String[] args) {
        printArray(array);
        sort(0,array.length-1);
        printArray(array);
     }
}
