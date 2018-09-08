package com.Algorithm;

public class DisjointSet
{
    int []parent;
    DisjointSet(int v)
    {
        parent=new int[v];
    }
    void makeSet(int i)
    {
        if(i==parent.length)return;
        parent[i]=i;
        i=i+1;
        makeSet(i);
    }


    int findParent(int i)
    {
        if(parent[i]==i)return i;
        return findParent(parent[i]);
    }


    void makeUnion(int node1,int node2)
    {
        int u=findParent(node1);
        int v=findParent(node2);

        if(u!=v)
        {
            parent[v]=u;
        }
    }
}
