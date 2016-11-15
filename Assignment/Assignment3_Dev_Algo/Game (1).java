import java.io.*;
import java.util.*;
class Game
{
  public static void main(String args[])
  {
  Scanner sc=new Scanner(System.in);
  int n=30;
  int nc=30;
  int cell[]=new int[30];
  for(int i=0;i<nc;i++)
  cell[i]=-1;
  //ladder
  cell[2]=21;
  cell[4]=7;
  cell[10]=25;
  cell[19]=28;
  //snake
  cell[16]=3;
  cell[18]=6;
  cell[20]=8;
  cell[26]=0;
  int ladder=0; 
  int snake=0;
  for(int i=0;i<n;i++)
  { 
   if(cell[i]<i && cell[i]>=0)
    snake++;
   if(cell[i]>i)
     ladder++;
  }  
  System.out.println("no. of ladder="+ladder);
  System.out.println("no. of snake="+snake);
  int k=findMinThrows(0,0,cell,n);
  System.out.println("Min Throws to get from First to last cell "+k);
  int k2=findMinThrowsTS(cell,n);
  System.out.println("Min throws to get from last to first cell "+k2);
  int k3=findMinThrowsD(cell,n);
  System.out.println("min throws required when snake encountered once "+k3);   
  }
//class for storing cell and throws
  static class QEntry
  {
   int vertex;
   int distance;
  }
//function return minimum throws from starting cell to end cell
static int findMinThrows(int v,int d,int board[],int n)
{
  boolean visited[]=new boolean[n];
  for(int i=0;i<n;i++)
  {
   visited[i]=false;
  }
  Queue<QEntry> q = new LinkedList<QEntry>();
  visited[0]=true;
  QEntry s=new QEntry();
  s.vertex=v;
  s.distance=d;
  q.add(s);
  QEntry qe=new QEntry();
  while(!q.isEmpty())
  {
   qe=q.peek();
   int vertex=qe.vertex;
   if(vertex==n-1)
   break;
   q.remove();
   for(int i=vertex+1;i<=(vertex+6)&&i<n;i++)
   {
    if(visited[i]==false)
    {
     QEntry nqe=new QEntry();
     nqe.distance=qe.distance+1;
      visited[i]=true;
    if(board[i]!=-1)
     nqe.vertex=board[i];
    else
     nqe.vertex=i;
    q.add(nqe);  
    }
   }
  }
 return qe.distance;
 }
//function for getting min throws from last to first cell
static int findMinThrowsTS(int board[],int n)
 {
  boolean visited[]=new boolean[30];
  for(int i=0;i<n;i++)
  {
   visited[i]=false;
  }
  Queue<QEntry> q1 = new LinkedList<QEntry>();
  visited[29]=true;
  QEntry s1=new QEntry();
  s1.vertex=29;
  s1.distance=0;
  q1.add(s1);
  QEntry qe1=new QEntry();
  while(!q1.isEmpty())
  {
   qe1=q1.peek();
   int vertex=qe1.vertex;
   if(vertex==0)
    break;
   q1.remove();
   for(int i=vertex-1;i>=(vertex-6)&&i>0;i--)
   {
    if(visited[i]==false)
    {
     QEntry nqe1=new QEntry();
     nqe1.distance=qe1.distance+1;
      visited[i]=true;
     if(board[i]!=-1)
     {
      nqe1.vertex=board[i];
     }
     else
      nqe1.vertex=i;
     q1.add(nqe1);  
    }
   }
  }
 return qe1.distance;
}
/////minimum 1 snake encounter
static int findMinThrowsD(int board[],int n)
{
   boolean visited[]=new boolean[n];
   for(int i=0;i<n;i++)
   {
     visited[i]=false;
   }
   Queue<QEntry> q = new LinkedList<QEntry>();
   visited[0]=true;
   QEntry s=new QEntry();
   s.vertex=0;
   s.distance=0;
   q.add(s);
   QEntry qe=new QEntry();
   while(!q.isEmpty())
   { 
   int f=0; 
   qe=q.peek();
   int vertex=qe.vertex;
   if(vertex==n-1)
   break;
   q.remove();
   for(int i=vertex+1;i<=(vertex+6)&&i<n;i++)
   {
   if(visited[i]==false)
   {
   QEntry nqe=new QEntry();
   nqe.distance=qe.distance+1;
      if(board[i]!=-1)
       {
         if(board[i]<i)
         {
         f++;
         nqe.vertex=board[i];
         int p=findMinThrows(nqe.vertex,nqe.distance,board,n);
         return p;
         }
         nqe.vertex=board[i];
       }
      else
      nqe.vertex=i;
      q.add(nqe);  
   }
   }
  }
 return qe.distance;
 }
}
