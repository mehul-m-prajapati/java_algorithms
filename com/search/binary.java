package search;

public class binary {
	
    public static int binarySearch(int arr[], int l, int r, int x) 
    { 
        if (r >= l) { 
            int mid = l + (r - l) / 2; 
  
            if (arr[mid] == x) 
                return mid; 
  
            if (arr[mid] > x) 
                return binarySearch(arr, l, mid - 1, x); 

            return binarySearch(arr, mid + 1, r, x); 
        } 
  
        return -1; 
    } 
  
    public static void main(String args[]) 
    { 
        int test_arr[] = { 10, 40, 56, 89, 110, 225, 568 }; 
        
        int n = test_arr.length; 
        int x = 110; 
        int res = binarySearch(test_arr, 0, n - 1, x); 
        
        if (res == -1) 
            System.out.println("Element not present"); 
        else
            System.out.println("Element found at index " + res); 
    } 

}
