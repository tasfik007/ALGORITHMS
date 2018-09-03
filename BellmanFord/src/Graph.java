import java.util.Scanner;

public class Graph
{
    static int V, E;
    Edge []edge;
    int []dist;
    //static int [][]weight;

    // Creates a graph with V vertices and E edges
    Graph(int v, int e)
    {
        //Write proper constructor

        edge=new Edge[e];
        for (int i = 0; i <e ; i++)
        {
            edge[i]=new Edge();
        }

        dist=new int[v];
        //weight=new int[v][v];
    }

    void relax(int u, int v,int weight)
    {
        //Relax function. Here, weight = w(u, v)
        if(dist[u]!=Integer.MAX_VALUE && dist[v]>dist[u]+ weight)
        {
            dist[v]=dist[u]+ weight;
        }
    }

    void initialize_distance(int src){
      //  System.out.println("Value of V is :: "+V);
        for (int i=0; i<V; ++i)
            dist[i] = Integer.MAX_VALUE;
        dist[src] = 0;
    }

    void calculate_distance(){

        //Actual Bellman Ford Algorithm
        for (int i = 1; i <V ; i++)
        {
            for (int j = 0; j <E ; j++)
            {

                relax(edge[j].src,edge[j].destination,edge[j].weight);
            }
        }
    }

    void find_negative_cycle(){
        //Bellman Ford with extra code for detecting negative edge
        for (int j = 0; j <E ; j++)
        {
            int u=edge[j].src;
            int v=edge[j].destination;
            if(dist[u]!=Integer.MAX_VALUE &&dist[v]>dist[u]+ edge[j].weight)
            {
                System.out.println("NEGATIVE WEIGHTED CYCLE DETECTED!!");
                System.exit(0);
            }
        }
    }

    void print_output()
    {
        System.out.println("Vertex Distance from Source");
        for (int i=0; i<V; ++i)
            System.out.println(i+"\t\t"+dist[i]);
    }


    void BellmanFord(int src)
    {

        initialize_distance(src);

        calculate_distance();

        find_negative_cycle();

        print_output();
    }


    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Vertex: ");
         V=sc.nextInt();
        System.out.println("Edge: ");
         E=sc.nextInt();
        Graph graph = new Graph(V, E);
         for (int i = 0; i <E ; i++)
        {
            graph.edge[i].src = sc.nextInt();
            graph.edge[i].destination = sc.nextInt();
            graph.edge[i].weight = sc.nextInt();
           // weight[graph.edge[i].src][graph.edge[i].destination]=graph.edge[i].weight;
        }

        graph.BellmanFord(0);
    }
}

