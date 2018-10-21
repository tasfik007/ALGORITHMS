package algorithm;

public class Main
{
    static void listMerge(int[]arr,int left,int middle,int right)
    {
        int n1=middle-left+1;
        int n2=right-middle;
        int[]L=new int[n1];
        int[]R=new int[n2];

        for (int i = 0; i <n1 ; i++)
        {
            L[i]=arr[left+i];
        }
        for (int i = 0; i <n2 ; i++)
        {
            R[i]=arr[middle+1+i];
        }
        int i=0,j=0,k=left;
        while(i<n1 && j<n2)
        {
            if(L[i]<=R[j])
            {
                arr[k]=L[i];
                i++;
                k++;
            }
            else
            {
                arr[k]=R[j];
                j++;
                k++;
            }
        }
        while(i<n1)
        {
                arr[k]=L[i];
                i++;
                k++;
        }
        while(j<n2)
        {
                arr[k]=R[j];
                j++;
                k++;
        }

    }
    static void listSort(int[]arr,int left,int right)
    {
        if(left<right)
        {
            int middle=(left+right)/2;
            listSort(arr,left,middle);
            listSort(arr,middle+1,right);
            listMerge(arr,left,middle,right);
        }
    }
    static void listPrint(int[]arr)
    {
        for (int i = 0; i <arr.length ; i++)
        {
            System.out.print(arr[i]+",");
        }
        System.out.println();
    }
    public static void main(String[] args)
    {
        int[]arr={2,4,3,1,6,5,7,9,8,0};

        listPrint(arr);
        listSort(arr,0,arr.length-1);
        listPrint(arr);
    }
}
