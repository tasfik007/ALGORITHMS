/*
BFS ALGORITHM IMPLEMENTATION
BFS TRAVERSAL OF A GRAPH
AKA LEVEL ORDER TRAVERSAL
 */


//import java.util.*; //this library can be added for including all the below library at once
import java.util.Scanner;
import java.util.Queue;
import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;

public class BFSalgorithm
{

    static List<List<Integer>> list=new ArrayList<List<Integer>>(5);
    static ArrayList<Integer> visit =new ArrayList<Integer>();

    /**
     *
     * @param root calling BFS through this node,it can be any node
     * @param node it represents the number of total nodes in the graph
     */
    static void BFS(int root,int node)
    {
        for(int i=0;i<node;i++)
        {
            visit.add(0);
        }
        Queue<Integer> q=new LinkedList<>();
        q.add(root);
        visit.set(0,1);
        while(q.peek()!=null)
        {
            int u=q.peek();
            System.out.print(u+"  ");
            q.remove();
            for(int i=0;i<list.get(u).size();i++)
            {
                int v=list.get(u).get(i);
                if(visit.get(v)==0)
                {
                    visit.set(v,1);
                    q.add(v);
                }
            }
        }
    }

    /**
     *
     * @param node1 it holds the source of an Edge
     * @param node2 it holds the destination of the Edge
     */
    static void createEdge(int node1,int node2)
    {
        list.get(node1).add(node2);
    }

    /**
     *
     * @param args to this main method can be passed an array of String
     */
    public static void main(String[] args)
    {
       // System.out.printf("Debugging!!");
        Scanner sc=new Scanner(System.in);
        System.out.printf("Enter the number of Nodes: ");
        int node=sc.nextInt();
        System.out.printf("Enter the number of Edges: ");
        int edge=sc.nextInt();

        for(int i=0;i<node;i++)
        {
            list.add(new ArrayList<Integer>());
        }
        System.out.println("Create the edges-");
        for(int i=0;i<edge;i++)
        {
            int node1=sc.nextInt();
            int node2=sc.nextInt();
            createEdge(node1,node2);
        }
        // calling BFS through index 0
        System.out.printf("The BFS order is: ");
        BFS(0,node);

    }
}
