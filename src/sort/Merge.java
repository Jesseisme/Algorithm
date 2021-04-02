package sort;

public class Merge {
    private static int[] aux;
    public static void sort(int[] a){
        aux = new int[a.length];
        sort(a, 0, a.length-1); 
    }

    private static void sort(int[] a,int lo,int hi){
        if(lo>=hi) return;
        int mid=lo+(hi-lo)/2;
        sort( a, lo, mid);
        sort( a, mid+1, hi);
        MergeArray(a,lo,mid,hi);
    }

    private static void MergeArray(int[] a,int lo,int mid,int hi){
        int i=lo,j=mid+1;
        for(int k=lo;k<=hi;k++)
            aux[k]=a[k];
        
        for(int k=lo;k<=hi;k++){
            if(i>mid) a[k]=aux[j++];
            else if(j>hi)  a[k]=aux[i++];
            else if(aux[i]<aux[j]) a[k]=aux[i++];
            else  a[k]=aux[j++];
        }
    }

    public static void main(String[] args) {  
         int[] array = {49,38,65,97,76,13,27,49,78,34,12,64,5,4,62,99,98,54,56,17,18,23,34,15,35,25,53,51,2};
         sort(array);  
         for(int num:array){
        	 System.out.print(num +",");
         }
    }
}
