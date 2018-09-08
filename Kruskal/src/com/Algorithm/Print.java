package com.Algorithm;

public class Print
{
    void printGraph(Graph[]g)
    {
        for (int i = 0; i <g.length ; i++)
        {
            System.out.println("Source: "+g[i].src+" Destination: "+g[i].dest+" Weight: "+g[i].weight);
        }
        System.out.println();
    }

}
