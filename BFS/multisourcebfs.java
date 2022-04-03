package BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class multisourcebfs {

    static Scanner sc = new Scanner(System.in);
    static final int n = (int)1e3+10;
    static int [][] val = new int[n][n];
    static int [][] vis = new int[n][n];
    static int [][] level = new int[n][n];
    static int nn,mm;

    public static void main(String[] args) {

        int test = sc.nextInt();

        while(test-->0){
            nn = sc.nextInt();
            mm = sc.nextInt();
            reset();

            for(int i=0;i<nn;i++){
                for(int j=0;j<mm;j++){
                    val[i][j] = sc.nextInt();
                }
            }

            System.out.println(bfs());


        }

        
    }


    static void reset(){
        for(int i=0;i<nn;i++){
            for(int j=0;j<mm;j++){
                vis[i][j] = 0;
                level[i][j]=0;
            }
        }
    }



    static int bfs(){

        int mxval = 0;

        for(int i=0;i<nn;i++){
            for(int j=0;j<mm;j++){
                mxval = Math.max(mxval, val[i][j]);
            }
        }

        Queue<Pair<Integer,Integer>>queue= new LinkedList<Pair<Integer,Integer>>();

        for(int i=0;i<nn;i++){
            for(int j=0;j<mm;j++){
                if(mxval == val[i][j]){
                    queue.offer(new Pair<Integer,Integer>(i, j));
                    level[i][j]=0;
                }
            }
        }

        int ans =0;

        while(!queue.isEmpty()){
            Pair v = queue.poll();

            int v_x = (int)v.first;
            int v_y = (int)v.second;

            for(Pair movement : movements){
                int child_x =(int) movement.first + v_x;
                int child_y = (int)movement.second+v_y;

                if(!isValid(child_x, child_y))continue;
                if(vis[child_x][child_y]==1) continue;
                level[child_x][child_y] = level[v_x][v_y]+1;
                vis[child_x][child_y] = 1;
                ans = Math.max(ans, level[child_x][child_y] );


            }


        }


        return ans;
    }


    static ArrayList<Pair<Integer,Integer>>movements = new ArrayList<Pair<Integer,Integer>>();

    static void move(){
        movements.add(new Pair<Integer,Integer>(0, 1));
        movements.add(new Pair<Integer,Integer>(0, -1));

        movements.add(new Pair<Integer,Integer>(1, 0));
        movements.add(new Pair<Integer,Integer>(-1, 0));

        movements.add(new Pair<Integer,Integer>(1, 1));
        movements.add(new Pair<Integer,Integer>(1, -1));

        movements.add(new Pair<Integer,Integer>(-1, 1));
        movements.add(new Pair<Integer,Integer>(-1, -1));

       

    }


    static boolean isValid(int i,int j){
        return i>=0 && j >=0 && i<n && j <n;

    }

    
    
}
