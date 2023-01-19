public class bubble{
    static int[] array = {2,3,4,2,56,34,32,34,63,43,24,4,1};

    public static void sort(int[] array) {
        for(int i=0;i<array.length;i++){
            for(int j =0;j<array.length;j++){
                if(array[i]<array[j]){
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                    
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

