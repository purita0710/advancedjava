public class selectsort{
    /*
     * 주어진 자료들 중에 현재 위치에 맞는 자료를 찾아 선택
    위치를 교환하는 정렬 알고리즘
    한번 순회를 돌게되면 알고리즘 상 전체 자료 중 가장 작은 값의 자료가 0번째 인덱스에 위치
    그 다음 순회부터는 1번 인덱스부터 순회를 돌며 반복하면 된다.
     */
    static int[] array = {2,3,4,2,56,34,32,34,63,43,24,4,1};

    public static void sort(int[] array) {
        for(int i=0;i<array.length;i++){
            int min_index = i;
            for(int j=i+1;j<array.length;j++){
                if(array[j]<array[min_index]){
                    min_index = j;
                }
            }
            int temp = array[i];
            array[i] = array[min_index];
            array[min_index]=temp;
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