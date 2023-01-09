package edu.ser222.m02_02;

/**
 * Implements various divide and conquer algorithms.
 *
 * Last updated 4/2/2022.
 *
 * Completion time: (your completion time)
 *
 * @author (your name), Acuna, Sedgewick and Wayne
 * @verison (version)
 */
import java.util.Random;

public class CompletedMerging implements MergingAlgorithms {

    //TODO: implement interface methods.
    @Override
    public <T extends Comparable> Queue<T> mergeQueues(Queue<T> q1, Queue<T> q2) {
   
     
    	ListQueue<T> MergedQueue = new ListQueue<T>() ;
    	
    	int MergeSize = (q1.size()+q2.size());
    for(int i = 0; i < MergeSize; i++)
    {
    if  ((q1.size() != 0) && (q2.size() != 0) )
    	{
    		if(    ((q1.peek().compareTo(q2.peek() ) <= 0)))
    		{
    				MergedQueue.enqueue(q1.dequeue());
    				
    		}
    		else if ( ((q1.peek().compareTo(q2.peek() ) >= 0)) )
    			{
    				MergedQueue.enqueue(q2.dequeue());
    				
		
    	        }
    		
    	  }
    	
    else if(q1.size() == 0 && (q2.size() != 0)  )
    	{
    		MergedQueue.enqueue(q2.dequeue());
    		
    	}
    else if ((q1.size()!=0 ) && (q2.size() == 0 ))
    	{
    		MergedQueue.enqueue(q1.dequeue());
    		
    	}
    
    
    	
    }
    	
      return MergedQueue;
    	
    }

    @Override
    public void sort(Comparable[] a) 
    {
   
    	Comparable[] MergeSortArray  = mergesort(a);
    	for(int i = 0; i < MergeSortArray.length ; i++)
    	{
    		a[i] = MergeSortArray[i];
    	}
    
    	
    }

    
    
    
    @Override
    public Comparable[] mergesort(Comparable[] a) 
    {
       
    	//If incorrect re-implement
    	//Verifying if Sorted for Arrays
    	
    
       
       // Setting Initial Helper /Variables
       
   
       int lo = 0;  
       int mid= (a.length/2);
       int j = mid+1;
       int i = lo ;
       int hi = (a.length-1);
       int TotalSize = a.length;
     
       if (hi <= lo)
       {
       	return a;
       }
       
      //Reading Arrays into Aux Array to prep for sorting
      Comparable []half1 = new Comparable[mid];
      Comparable []half2 = new Comparable[TotalSize-mid];
    
       for(int k = lo; k < mid; k++)
    	   half1[k] = a[k];
       
       for(int k = mid; k <= hi; k++)
    	   half2[k-mid] = a[k];
       
     Comparable[] FirstHalf  =  mergesort(half1);
     Comparable[] SecondHalf =  mergesort(half2);
     a = merge(FirstHalf,SecondHalf);
     return a;

    }

   

    @Override
    public Comparable[] merge(Comparable[] a, Comparable[] b) 
    {
    	//If incorrect re-implement
    	//Verifying if Sorted for Both Arrays
    	
       assert isSorted(a);
       assert isSorted(b);
       
       // Setting Initial Helper /Variables
       
       int lo = 0;
       int mid=(a.length-1);
       int j = mid+1;
       int i = lo ;
       int TotalSize = a.length + b.length;
      
      //Reading Arrays into Aux Array to prep for sorting
      Comparable []aux = new Comparable[TotalSize];
      Comparable []FinalMerge = new Comparable[TotalSize];
       for(int k = lo; k <= mid; k++)
    	   aux[k] = a[k];
       for(int c = j; c <= TotalSize-1; c++)
    	   aux[c] = b[c-a.length];
       
       // Merging Aux into Final Merge
       for (int z = lo; z<= TotalSize-1;z++ ) 
       {
    	   if      (i > mid)                FinalMerge[z] = aux[j++];
           else if (j > TotalSize -1)       FinalMerge[z] = aux[i++];  
           else if (less(aux[j],aux[i]))    FinalMerge[z] = aux[j++];
           else                             FinalMerge[z] = aux[i++];
           
       }
    	
    	  return FinalMerge;
    }

    @Override
    public void shuffle(Object[] a) 
    {
    
       	Object[] ShuffleSortArray  = shufflemergesort(a);
    	for(int i = 0; i < ShuffleSortArray.length ; i++)
    	{
    		a[i] = ShuffleSortArray[i];
    	}
    
      
    
      
    }
    
    private Object[] shufflemergesort(Object a[])
    {

        int lo = 0;  
        int mid= (a.length/2);
        int j = mid+1;
    
        int hi = (a.length-1);
        int TotalSize = a.length;
        if (hi <= lo)
        {
        	 return a;
        }
        
       //Reading Arrays into Aux Array to prep for sorting
       Object []half1 = new Comparable[mid];
       Object []half2 = new Comparable[TotalSize-mid];
     
        for(int k = lo; k < mid; k++)
     	   half1[k] = a[k];
        
        for(int k = mid; k <= hi; k++)
     	   half2[k-mid] = a[k];
        
      Object[] FirstShuffle  =  shufflemergesort(half1);
      Object[] SecondShuffle =  shufflemergesort(half2);
      return a = shufflemerge(FirstShuffle,SecondShuffle);
    	
    	
    	
    	
    }
    
    private Object[] shufflemerge(Object[] a, Object[] b) 
    {
    	//If incorrect re-implement
    	//Verifying if Sorted for Both Arrays
    	
     
       Random SomeNum = new Random();
       int NUM;
       // Setting Initial Helper /Variables
       
       int lo = 0;
       int mid=(a.length-1);
       int j = mid+1;
       int i = lo ;
       int TotalSize = a.length + b.length;
      

     //Reading Arrays into Aux Array to prep for sorting

     Object []aux = new Comparable[TotalSize];
     Object []hold = new Comparable[TotalSize];

     Object []FinalMerge = new Comparable[TotalSize];

      for(int k = lo; k <= mid; k++)

   	   aux[k] = a[k];

      for(int c = j; c <= TotalSize-1; c++)

   	   aux[c] = b[c-a.length];

  	  

      // Merging Aux into Final Merge

      for (int z = 0; z < TotalSize ; z++) 

      {

       do {
       NUM = SomeNum.nextInt(TotalSize);
       FinalMerge[z] = aux[NUM];
          }
       while	
    	   (aux[NUM] == null);
      
    	   aux[NUM] = null;   	   
           
      }
      
      return FinalMerge;
    }
    
    
    
    
    /**
     * entry point for sample output.
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Queue<String> q1 = new ListQueue<>(); q1.enqueue("E"); q1.enqueue("L"); q1.enqueue("O"); q1.enqueue("R"); q1.enqueue("T");
        Queue<String> q2 = new ListQueue<>(); q2.enqueue("A"); q2.enqueue("E"); q2.enqueue("M"); q2.enqueue("P"); q2.enqueue("S"); q2.enqueue("X");
        Queue<Integer> q3 = new ListQueue<>(); q3.enqueue(5); q3.enqueue(12); q3.enqueue(15); q3.enqueue(17); q3.enqueue(20);
        Queue<Integer> q4 = new ListQueue<>(); q4.enqueue(1); q4.enqueue(4); q4.enqueue(12); q4.enqueue(13); q4.enqueue(16); q4.enqueue(18);

        MergingAlgorithms ma = new CompletedMerging();

        //Q1 - sample test cases
        Queue merged1 = ma.mergeQueues(q1, q2);
        System.out.println(merged1.toString());
        Queue merged2 = ma.mergeQueues(q3, q4);
        System.out.println(merged2.toString());
        
        //Q2 - sample test cases
        String[] a = {"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
        ma.sort(a);
        assert isSorted(a);
        show(a);
        
        //Q3 - sample test cases
        String[] b = {"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
        ma.shuffle(b);
        show(b);
        
        ma.shuffle(b);
        show(b);
    }

    //below are utilities functions, please do not change them.
        
    //sorting helper from text
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    //sorting helper from text
    private static void show(Comparable[] a) {
        for (Comparable a1 : a)
            System.out.print(a1 + " ");

        System.out.println();
    }
    
    //sorting helper from text
    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++)
            if (less(a[i], a[i-1]))
                return false;
        
        return true;
    }
    
    //sorting helper from text
    public static boolean isBool(Comparable[] a) {
        for (int i = 1; i < a.length; i++)
            if (less(a[i], a[i-1]))
                return false;
        
        return true;
    }
    
    
    
}