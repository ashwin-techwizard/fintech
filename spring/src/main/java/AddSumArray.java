public class AddSumArray {


    static void recur(int n, int minusN, int[] arr, int index){
        if (minusN < 0)
            return;
        if(minusN==0){
            for(int i=0;i<index;i++){
                System.out.print(arr[i]+" ");
            }
            System.out.println();
            return;
        }

        int prev= (index==0)? 1:arr[index-1];

        for(int v=prev;v<=n;v++){
            arr[index]=v;
            recur(n,minusN-v,arr,index+1);
        }

    }


    public static void main(String[] args) {
        int n=5;
    int[] arr=new int[n];

    recur(n,n,arr,0);

    }
}
