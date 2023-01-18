public class maze {

    private static int N =10;                     // 2차원 미로의 배열크기 설정할 상수
    
    private static final int PATHWAY = 0;         // 아직 가보지 못한 길 = 0
    private static final int WALL = 1;            // 벽 =1
    private static final int BLOCKED =2;          // 가봤던 길 = 2
    private static final int DEAD = 3;            // 동서남북으로 확인해봤을때 더이상 갈 수 있는 통로가 없는 길 =3
    
    public static int[][] arr = new int[N][N];
    public static boolean findMazePath(int x, int y, int xend,int yend){
        if(x<0||y<0||x>=N||y>=N){       // 좌표 이외의 값은 false반환
            return false;
        }
        else if(arr[x][y]!=PATHWAY){   // arr[x][y]의 값이 1(WALL) 2(BLOCKED)이거나 3(DEAD)일 경우 false반환
            return false;
        }
        else if (x==xend&&y==yend){    // 출구일 경우 true 반환
            arr[x][y]=DEAD;
            return true;
        }
        else{                   // 일반적인 경우
            arr[x][y]=DEAD;
            if(findMazePath(x-1,y,xend,yend)|| findMazePath(x,y+1,xend,yend) || findMazePath(x+1,y,xend,yend) || findMazePath(x,y-1,xend,yend)) {
				//서 → 북 → 동 → 남 순서로 시도
				return true;
            }
            arr[x][y] = BLOCKED; // 출구 찾지 못함 false반환
			return false;
        }
    }
    public static void arrprint(){          // 미로 출력
        for(int a=0;a<N;a++){
        for(int b=0;b<N;b++){
            System.out.print(arr[a][b]+" ");
        }
        System.out.println();
    }
}

    public static void main(String[] args) {
        try {
            System.out.println("========================start=========================");

            int wallcnt;           // 벽의 개수
            int i,j;
            
        
            wallcnt = (int)(Math.random()*100)+1;               // 생성할 벽의 개수 1~100개 사이로 Random하게 지정
            System.out.println("wallcnt : " + wallcnt);

           for(int a=0;a<=wallcnt;a++){                     // 벽의 개수만큼 반복해서 arr[i][j]=1 ->벽을 만듦
                do{
                    i = (int)(Math.random()*N);
                    j = (int)(Math.random()*N);
                }while(i==0&&j==0);
                arr[i][j]=WALL;
            }

            int xend,yend;              // 출구로 설정할 변수 선언
            do{
               xend = (int)(Math.random()*N);       
               yend = (int)(Math.random()*N);
            }while((xend==0&&yend==0)&&(arr[xend][yend]==WALL));

            arrprint();             // 미로 출력

            if(findMazePath(0, 0,xend,yend)){           // 미로 출구를 찾으면(true) Find exit출력
                System.out.println("Find exit!");
            }else System.out.println("Fail");             // 실패시(false)    Fail출력


    
        } catch(Exception e) {
            System.out.println("Exception!!");
            throw new RuntimeException(e);
        }

    }
}