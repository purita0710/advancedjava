import java.util.*;

public class TicTacToe{                 
    public static char[][] arr = new char[3][3];
        

    public static void printArr(char [][] arr){
        System.out.println();
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length;j++){
                if(arr[i][j]=='\u0000'){
                    System.out.print(". ");
                }else  System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static boolean playgame(){
        if(arr[0][0]!='\u0000' && arr[0][0]==arr[0][1] && arr[0][1]==arr[0][2]){                        // 게임이 끝났을때 Win
            return false;
        }
        else if(arr[1][0]!='\u0000' && arr[1][0]==arr[1][1] && arr[1][1]==arr[1][2]){
            return false;
        }
        else if(arr[2][0]!='\u0000' && arr[2][0]==arr[2][1] && arr[2][1]==arr[2][2]){
            return false;
        }
        else if(arr[0][0]!='\u0000' && arr[0][0]==arr[1][0] && arr[1][0]==arr[2][0]){
            return false;
        }
        else if(arr[0][1]!='\u0000' && arr[0][1]==arr[1][1] && arr[1][1]==arr[2][1]){
            return false;
        }
        else if(arr[0][2]!='\u0000' && arr[0][2]==arr[1][2] && arr[1][2]==arr[2][2]){
            return false;
        }
        else if(arr[0][0]!='\u0000' && arr[0][0]==arr[1][1] && arr[1][1]==arr[2][2]){
            return false;
        }
        else if(arr[0][2]!='\u0000' && arr[0][2]==arr[0][1] && arr[1][1]==arr[2][0]){
            return false;
        }
        else return true;  // 게임을 진행
    }
    public static void main(String[] args) { 
        Scanner scanner = new Scanner(System.in);

        int cnt=0;                                  // (컴퓨터,나) 횟수
        int i=0,j=0;                                // 컴퓨터가 선택할 랜덤 좌표
       printArr(arr);
        
        while(true){                                         
            do{                                     // 컴퓨터가 선택한 칸이 비어있지 않다면 다시 고르기
                i=(int)(Math.random()*3);
                j=(int)(Math.random()*3);
            }while(arr[i][j]!='\u0000');

            arr[i][j]='X';                          // 컴퓨터가 선택한 좌표에 'X'넣기
            System.out.printf("Computer(%d ,%d)",i,j);      // 컴퓨터가 선택한 좌표 출력
            printArr(arr);
            
            while(arr[i][j]=='X'||arr[i][j]=='O'){
                System.out.print("좌표를 입력하세요(ex>>1 2)>>");
                i = scanner.nextInt();
                j = scanner.nextInt();
            }

            arr[i][j]='O';
            printArr(arr);

            if(!playgame()){
                break;
            }
            if(cnt>4){                             // 더이상 게임을 진행 할 수 없을때 무승부로 게임 종료
                System.out.println("Draw");
                break;
            }
            cnt++;
        }
        scanner.close();
        System.out.println("Game End");      
    }
}