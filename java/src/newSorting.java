public class newSorting {

    public void newSorting(int[]A, int size){
        //base case
        if(A.length <= size){
            int L = 0; // start of the array
            int R = A.length-1; // end of the array
            quicksort(A, L, R); // calling quick sort method
        }
        //recursive case
        else{
            int mid = A.length/2;
            int[] L = new int[mid]; // left side of the array will only be from 0 - mid
            int[] R = new int [A.length-mid]; // right side of the array will only be from mid +1 to the end of the array

            //populate l and r
            //for loop
            // puts left array in to the left subarray of array
            for(int i = 0; i < L.length; i++){
                L[i] = A[i];
            }

            // puts right array in to the right subarray of array
            for(int i = mid; i < A.length; i++){ // want to start at A mid
                R[i-mid] = A[i];
            }

            newSorting(L,size); // sorting the left side of the array
            newSorting(R, size); // sorting the right side of the array
            mergeSortedHalves(A,L,R); // call the method to merge both sides
        }
    }
    private int partition(int[] A, int L, int R){
        int pivot = A[L]; // is the start of the array
        int less = L +1;
        int more = R;

        while(less < more) {
            while (more > L && A[more] >= pivot) { // checking
                more--;
            }
            while (less <= R && A[less] <= pivot) {
                less++;
            }
            if (less < more) { // same as the while loop will start the swapping
                int temp = A[less]; // swapping elements
                A[less] = A[more];
                A[more] = temp;
            }
        }
        int temp = pivot; // swapping elements that did not fall under the while loop
        A[L] = A[more];
        A[more] = temp;

        return more;
    }
    private void quicksort(int[] A, int L, int R){
        // base case
        if(L == R-1){ // if there is only an array of 2 element then there is no point going though quick sort
            if(A[R] < A[L]){ // find out which one of the two elements if the biggest
                int temp = A[R]; // and swap them
                A[R] = A[L];
                A[L] = temp;
            }
            return;
        }
        // base case 2
        // if the array had more then two elements
        if(L < R){
            int p = partition(A,L,R); //calling method

            // recursive call to the method
            quicksort(A,L,p-1);
            quicksort(A, p+1, R);
        }
    }

    private void mergeSortedHalves(int[] A, int[] L, int[] R){
        int i = 0; // assigned to L
        int j = 0; // assigned to R
        int k = 0; // assigned to K

        while(i < L.length && j < R.length){ // check the length of both array going from min to max
            if(L[i] < R[j]){  // if the left part is less then the right part
                A[k] = L[i]; // the left will go first
                i++; // move on to the next element of L
            }
            else{
                A[k] = R[j]; // when right side is less then the left the the right side will go first
                j++; // move on to the next element of R
            }
            k++; // move on to the next element of A
        }

        while(i < L.length){ // traversing the rest of L
            A[k] = L[i];
            i++;
            k++;
        }
        while(j < R.length){ // traversing the rest of R
            A[k] = R[j];
            j++;
            k++;
        }

    }
}
