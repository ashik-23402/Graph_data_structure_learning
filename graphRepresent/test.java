package graphRepresent;

import java.util.ArrayList;
import java.util.Scanner;

public class test {

    static int mxvertext =(int) 1e3+10;
    static int [][] adjmatrix = new int[mxvertext][mxvertext]; // initially it is filled with zeroes

    //for adjlist

    static ArrayList<ArrayList<Integer>>adjlist = new ArrayList<ArrayList<Integer>>();
    //initially added maxnode times empty list in adjlist.


    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int v = sc.nextInt();
        int e = sc.nextInt();

        

        for(int i=0;i<e;i++){
            int source = sc.nextInt();
            int dist = sc.nextInt();
            adjmatrix[source][dist] = 1; //if weight given ,store weight
            adjmatrix[dist][source] = 1; //if weight given ,store weight


            adjlist.get(source).add(dist);
            adjlist.get(dist).add(source);
            
            


        }

        // limitation of adjmatrix
        
        // 1. space complexity beshi O(N^2)
        // N= 10^6 this is not possible
        // i,j connected? or not .....O(1).



        // ***************adjecencyList*************
        //space complexity O(m+n)->m=verteces n= edges
        //i,j connected? or not ....this is not optimal).


        



        
    }
    
}
