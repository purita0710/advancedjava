public class insertsort{
    static int[] array = {2,3,4,2,56,34,32,34,63,43,24,4,1};

    public static void sort(int[] array) {
        for(int i=0;i<array.length;i++){
            int temp = array[i];
            for(int j=i;j>=0;j--){
                if(j==0){
                    array[0]=temp;
                }
                else if(array[j-1]<=temp){
                    array[j]=temp;
                    break;
                }
                else{
                    array[j] = array[j-1];
                }
            }
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
        sort(array);
        printArray(array);
     }
}