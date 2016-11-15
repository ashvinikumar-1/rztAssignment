import java.util.*;
import java.io.*;
class Union
{
 public static void main(String args[])
 {
  Scanner sc=new Scanner(System.in);
  System.out.println("enter length of first array");
  int l1=sc.nextInt();
  int[] a1=new int[l1];
  for(int i=0;i<l1;i++)
    a1[i]=sc.nextInt();
  System.out.println("enter length of second array");
  int l2=sc.nextInt();
  int[] a2=new int[l2];
  for(int i=0;i<l2;i++)
    a2[i]=sc.nextInt();
   int[] k=new int[l1+l2];
    int i=0;int j=0;
     int l3=-1;
    while(i<l1 && j<l2)
     {
      if(a1[i]<a2[j])
       {
         l3++;
          k[l3]=a1[i];
          i++;
       }
       else if(a1[i]>a2[j])
       {
        l3++;
        k[l3]=a2[j];
        j++; 
       }
       else
      {
       l3++;
       k[l3]=a1[i];
       i++; j++;
       }
    }
    while(i<l1)
    { 
         l3++;
          k[l3]=a1[i];
          i++;
    }
   while(j<l2)
    { 
         l3++;
          k[l3]=a2[j];
          j++;
    }
System.out.println("elements are:");
 for(int p=0;p<=l3;p++)
{
System.out.println(k[p]);
}
if((l3+1)%2==0)
{
 int m=(k[(l3+1)/2]+k[(l3+1)/2-1])/2;
System.out.println("median="+m);
}
else
{
System.out.println("median="+k[l3/2]);
}
  }
}
