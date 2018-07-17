public class SortingAlgorithm
{
     void bubbleSort(int[]listOfNumbers,int length)
    {
        boolean flag;
        for(int i=0;i<length;i++)
        {
            flag=false; //This is for keeping track of when no swap was done
            for(int j=1;j<length-i;j++)
            {
                if(listOfNumbers[j-1]>listOfNumbers[j])
                {
                    flag=true;
                    listOfNumbers[j-1]=listOfNumbers[j-1]+listOfNumbers[j];
                    listOfNumbers[j]=listOfNumbers[j-1]-listOfNumbers[j];
                    listOfNumbers[j-1]=listOfNumbers[j-1]-listOfNumbers[j];
                }
            }
            if(flag==false) break;
        }
    }
    void insertionSort(int[]listOfNumbers,int length)
    {
        for(int i=1;i<length;i++)
        {
            int j=i;
            while(j>0 && listOfNumbers[j]<listOfNumbers[j-1])
            {
                listOfNumbers[j-1]=listOfNumbers[j-1]+listOfNumbers[j];
                listOfNumbers[j]=listOfNumbers[j-1]-listOfNumbers[j];
                listOfNumbers[j-1]=listOfNumbers[j-1]-listOfNumbers[j];
                j--;
            }
        }
    }
    void printList(int[]listOfNumbers,int length)
    {
        System.out.printf("The sorted list is : ");
        for(int i=0;i<length;i++)
        {
            System.out.print(listOfNumbers[i]+" ");
        }
    }
    public static void main(String[] args)
    {
        int [] listOfNumbers={2,1,4,5,3};//Inserting numbers in the list
        /*
        I have created an object of this class because
        we cannot call any non static method without any object of
        their class but we can call if we use static methods
         */
        SortingAlgorithm SortingObj=new SortingAlgorithm();

        //This line is for Bubble Sort
        SortingObj.bubbleSort(listOfNumbers,listOfNumbers.length);
        SortingObj.printList(listOfNumbers,listOfNumbers.length);
        System.out.println("[Bubble    Sort]");
        //This line is for Insertion Sort
        SortingObj.insertionSort(listOfNumbers,listOfNumbers.length);
        SortingObj.printList(listOfNumbers,listOfNumbers.length);
        System.out.println("[Insertion Sort]");

    }
}
