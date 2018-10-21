package algorithm;


public class Main
{
    static void LpsTable(String pat,int m,int[]LPS)
    {
        int len=0;
        int i=1;
        LPS[0]=0;
        while(i<m)
        {
            if(pat.charAt(i)==pat.charAt(len))
            {
                len++;
                LPS[i]=len;
                i++;
            }
            else
            {
                if(len!=0)
                    len=LPS[len-1];
                else
                {
                    LPS[i]=len;
                    i++;
                }
            }
        }
    }
    static  void KmpSearch(String txt,String pat)
    {
        int m=pat.length();
        int n=txt.length();
        int[]LPS=new int [m];
        int i=0,j=0;
        boolean flag=false;

        LpsTable(pat,m,LPS);
        while(i<n)
        {
            if(txt.charAt(i)==pat.charAt(j))
            {
                i++;
                j++;
            }
            if(j==m)
            {
                System.out.println("pattern found at: "+(i-j));
                flag=true;
                j=LPS[j-1];
            }
            else if(i<n && txt.charAt(i)!=pat.charAt(j))
            {
                if(j!=0)
                    j=LPS[j-1];
                else i++;
            }
        }
        if(flag==false) System.out.println("pattern not found!!");
    }
    public static void main(String[] args)
    {
            String txt="ABCDCDEFGHIJIJ";
            String pat="CDEF";
            KmpSearch(txt,pat);
    }
}
