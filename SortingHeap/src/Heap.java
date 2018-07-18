import java.util.Scanner;

public class Heap
{
    /**
     * @param len is declared globally to store the length-
     *            of the list of the numbers & is static for
     *            being called in static main method or we had to
     *            call it by an object
     */
    static int len;

    /**
     * @param index  it indicates from where heapify is being called
     */
    void heapify(int[]listOfNumbers,int length,int index)
    {
        int left=2*index,right=2*index+1,largest=index;
        if(left<=length && listOfNumbers[index]<listOfNumbers[left] )
        {
            largest=left;
        }
        if(right<=length && listOfNumbers[largest]<listOfNumbers[right] )
        {
            largest=right;
        }
        if(largest!=index)
        {
            listOfNumbers[largest]=listOfNumbers[largest]+listOfNumbers[index];
            listOfNumbers[index]=listOfNumbers[largest]-listOfNumbers[index];
            listOfNumbers[largest]=listOfNumbers[largest]-listOfNumbers[index];
            heapify(listOfNumbers,length,largest);
        }
    }
    /**
     * @param listOfNumbers holds the elements in the array
     * @param length        holds the total number of the elements in the array
     *
     */
    void buildHeap(int[]listOfNumbers,int length)
    {
        for(int i=length/2;i>=1;i--)
        {
            heapify(listOfNumbers,length,i);
        }

    }
    void heapSort(int[]listOfNumbers,int length)
    {
        buildHeap(listOfNumbers,length);
        for(int i=1;i<length;i++)
        {
            listOfNumbers[1]=listOfNumbers[1]+listOfNumbers[len];
            listOfNumbers[len]=listOfNumbers[1]-listOfNumbers[len];
            listOfNumbers[1]=listOfNumbers[1]-listOfNumbers[len];
            len--;
            heapify(listOfNumbers,len,1);
        }
    }
    void printHeap(int []listOfNumbers,int length)
    {
        for(int i=1;i<=length;i++)
        {
            System.out.print(listOfNumbers[i]+",");
        }
    }

    /**
     * @param args this main function receives an array of string argument
     */

    public static void main(String[] args)
    {
        Heap heapObj=new Heap();
        Scanner sc=new Scanner(System.in);
        //System.out.printf("All is ok!!");
        System.out.printf("Enter the size of ur list: ");
        int size=sc.nextInt();

        int []listOfNumbers=new int[size+1];
        len=size;
        for(int i=1;i<=5;i++)
        {
            listOfNumbers[i]=sc.nextInt();
        }

        heapObj.heapSort(listOfNumbers,listOfNumbers.length-1);
        heapObj.printHeap(listOfNumbers,listOfNumbers.length-1);

    }
}
