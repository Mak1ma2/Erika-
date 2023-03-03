

public class heapSort{ 
    /* 
     * heap sort 
     * 
     * notes: 
     *      - in place sorting: where we directly replace elements within an array in the original instead of creating a new array 
     *      - heap sort: 
     *          - rethink of an array as a binary tree where i is the head and it's left child is i + 1 and right as i + 2
     * 
    */
    
    static void sort(int[] arr){ 
        for(int i = arr.length/2; i >= 0; i--){ 
            heapify(arr, arr.length, i); 
        } 
        for(int i = arr.length -1; i >= 0; i--){ 
            int temp = arr[0]; 
            arr[0] = arr[i]; 
            arr[i] = temp; 

            heapify(arr, i, 0);
        }
    }

    static void heapify(int[]arr, int max, int i){ 
        int largest = i; 
        int left = 2 * i + 1; 
        int right = 2 * i + 2; 

        if(left < max && arr[left] > arr[i]){ 
            largest = left; 
        }
        if(right < max && arr[right] > arr[largest]){ 
            largest = right; 
        }

        if(largest != i){ 
            int temp = arr[i]; 
            arr[i] = arr[largest];
            arr[largest] = temp; 
            heapify(arr, max, largest);
        } 
    }

    static int [] NIPsort(int[]arr){ //NIP = Not In Place
        int[]result = new int[arr.length]; 
        for(int i = arr.length/2 - 1; i >= 0; i--){ 
            heapify(arr, arr.length, i); 
        }
        for(int i = arr.length -1; i >= 0; i--){ 
            int temp = arr[0];
            arr[0] = arr[i]; 
            arr[i] = temp;

            heapify(arr, i, 0);
        }
        for(int i = 0; i < arr.length; i++){ 
            result[i] = arr[i]; 
        }
        return result; 
    }

    // to test if fucntions worked properly 
    static void print(int[]arr){
        System.out.print("[");  
        for(int i = 0 ; i < arr.length - 1; i++){ 
            System.out.print(arr[i] + ", "); 
        }
        System.out.print(arr[arr.length - 1]); 
        System.out.println("]");
    }

    static int [] make_arr(int length){ 
        int[]result = new int[length]; 
        for(int i = 0 ; i < length; i++){ 
            int num = (int)(Math.random() * length) + 1; 
            result[i] = num; 
        }
        return result; 
    }


    public static void main(String[]args){
        int[] test3 = make_arr(100000000); 
        int[] test3_2 = test3;
        long start = System.currentTimeMillis(); 
        sort(test3); 
        long end = System.currentTimeMillis();
        System.out.println("In place Heap sort took: " + (end - start));  
        start = System.currentTimeMillis(); 
        test3_2 = NIPsort(test3_2); 
        end = System.currentTimeMillis();
        System.out.println("Out of place place Heap sort took: " + (end - start));  
    }
}