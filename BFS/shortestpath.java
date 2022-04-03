package BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class shortestpath {
    static Scanner sc = new Scanner(System.in);
    static int[][]vis = new int[8][8];
    static int[][]lvl = new int[8][8];

    public static void main(String[] args) {

        

        int n = sc.nextInt();

        while(n-->0){
            reset();
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();

            System.out.println(bfs(s1, s2));

        }

        // Pair<Integer,Integer>p = new Pair<Integer,Integer>(10, 20);

        

        

       
        
    }

    static int get_x(String s1){
        return s1.charAt(0)-'a';
    }

    static int get_y(String s1){
        return s1.charAt(1)-'1';
    }

    static void reset(){
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                vis[i][j] = 0;
                lvl[i][j] = -1;
            }
        }
    }


    static ArrayList<Pair<Integer,Integer>>movements = new ArrayList<>();

    static void move(){
        movements.add(new Pair<Integer,Integer>(-1, 2));
        movements.add(new Pair<Integer,Integer>(1, 2));

        movements.add(new Pair<Integer,Integer>(-1, -2));
        movements.add(new Pair<Integer,Integer>(1, -2));

        movements.add(new Pair<Integer,Integer>(2, -1));
        movements.add(new Pair<Integer,Integer>(2, 1));

        movements.add(new Pair<Integer,Integer>(-2, -1));
        movements.add(new Pair<Integer,Integer>(-2, 1));

    }

    static boolean isValid(int x , int y){
        return x>=0 && y>=0 && x<8 && y<8;
    }

   

    static int bfs(String source , String dest){

        int source_x = get_x(source);
        int source_y = get_y(source);
        int dest_x = get_x(dest);
        int dest_y = get_y(dest);

        Queue<Pair<Integer,Integer>>queue = new LinkedList<>();
        queue.offer(new Pair<Integer,Integer>(source_x, source_y));
        vis[source_x][source_y] = 1;

        while(!queue.isEmpty()){

            Pair<Integer,Integer> v = queue.poll();
            int x = v.first;
            int y = v.second;

            for(Pair emove : movements){
                int childx = (int) emove.first + x;
                int childy = (int) emove.second +y;
                if(!isValid(childx, childy)) continue;
                if(vis[childx][childy] == 0){
                    queue.offer(new Pair<Integer,Integer>(childx, childy));
                    lvl[childx][childy] = lvl[x][y]+1;
                    vis[childx][childy] = 1;
                }

            }

            if(lvl[dest_x][dest_y] != -1){
                break; // initially lvl array fill with -1
            }


        }

       return lvl[dest_x][dest_y];

    }


    
    
}
