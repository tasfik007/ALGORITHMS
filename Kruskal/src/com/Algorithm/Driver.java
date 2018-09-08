package com.Algorithm;

import java.util.Scanner;

public class Driver
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of vertices: ");
        int vertex=sc.nextInt();
        System.out.println("Enter the number of edges: ");
        int edge=sc.nextInt();

        /**
         * @param g1 represents the weighted graph
         */
        Graph []g1=new Graph[edge];
        DisjointSet d1=new DisjointSet(vertex);
        d1.makeSet(0);
        for (int i = 0; i <edge ; i++)
        {
            g1[i]=new Graph();
        }


        System.out.println("Create the graph: ");
        for (int i = 0; i < edge; i++)
        {
            int s=sc.nextInt();
            int d=sc.nextInt();
            int w=sc.nextInt();


            g1[i].src=s;
            g1[i].dest=d;
            g1[i].weight=w;
        }

        SortGraph sg=new SortGraph();
        sg.sortEdges(g1);
        /**
         * @param g2 represents the MST
         */
        Graph []g2=new Graph[edge];

        for (int i = 0; i <edge ; i++)
        {
            g2[i]=new Graph();
        }
        for (int i = 0; i <edge ; i++)
        {
            int u=d1.findParent(g1[i].src);
            int v=d1.findParent(g1[i].dest);
            if(u!=v)
            {
              //  System.out.println("Debugging...");
                g2[i].src=g1[i].src;
                g2[i].dest=g1[i].dest;
                g2[i].weight=g1[i].weight;
                d1.makeUnion(g1[i].src,g1[i].dest);
            }

        }

        Print p1=new Print();
        System.out.println("The Graph is: ");
        p1.printGraph(g1);
        System.out.println("The MST   is:");
        p1.printGraph(g2);


    }
}
