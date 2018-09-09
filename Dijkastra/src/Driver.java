import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Driver
{
    static int V,E;
    static ArrayList<ArrayList<Edge>> list=new ArrayList<ArrayList<Edge>>();
    static int []dist;
    static void createEdge(int s,int d,int w)
    {
        list.get(s).add(new Edge(s,d,w));
    }
    static void initialize()
    {
        for (int i = 0; i <V ; i++)
        {
            dist[i]=Integer.MAX_VALUE;
        }
    }
    static void dijkastra(int src)
    {
        initialize();
        PriorityQueue<Integer>Q=new PriorityQueue<Integer>();
        dist[src]=0;
        Q.add(src);
        while(!Q.isEmpty())
        {
            int u=Q.poll();
            for (int i = 0; i <list.get(u).size() ; i++)
            {
                int uvWeigh=list.get(u).get(i).weight;
                int vDest=list.get(u).get(i).dest;

                if(dist[vDest]>dist[u]+uvWeigh)
                {
                    dist[vDest]=dist[u]+uvWeigh;
                   // System.out.println("dest -> "+ vDest);
                    Q.add(vDest);
                }
            }
        }

    }

    static void printOutput(int src)
    {
        for (int i = 0; i < V; i++)
        {
            System.out.println("From ->"+src+" To ->"+i+" Distance -> "+dist[i]);
        }
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Vertices: ");
        V=sc.nextInt();
        dist=new int[V];
        System.out.println("Edgse:    ");
        E=sc.nextInt();
        for (int i = 0; i <V ; i++)
        {
            list.add(new ArrayList<Edge>());
        }
        for (int i = 0; i <E ; i++)
        {
            int node1=sc.nextInt(),node2=sc.nextInt(),weight=sc.nextInt();
            createEdge(node1,node2,weight);
        }

        dijkastra(0);
        printOutput(0);


    }
}
