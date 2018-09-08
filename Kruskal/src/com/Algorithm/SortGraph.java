package com.Algorithm;

public class SortGraph
{
    void sortEdges(Graph[] g)
    {
        for (int i = 0; i <g.length ; i++)
        {
            for (int j = 1; j < g.length-i; j++)
            {
                if(g[j-1].weight>g[j].weight)
                {
                    g[j-1].weight=g[j-1].weight+g[j].weight;
                    g[j].weight= g[j-1].weight-g[j].weight;
                    g[j-1].weight=g[j-1].weight-g[j].weight;

                    g[j-1].src=g[j-1].src+g[j].src;
                    g[j].src= g[j-1].src-g[j].src;
                    g[j-1].src=g[j-1].src-g[j].src;

                    g[j-1].dest=g[j-1].dest+g[j].dest;
                    g[j].dest= g[j-1].dest-g[j].dest;
                    g[j-1].dest=g[j-1].dest-g[j].dest;
                }
            }
        }
    }
}
