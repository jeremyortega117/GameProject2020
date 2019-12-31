package Algorithms;

import NPCHuman.NPCHumanObject;

/* Java program for Merge Sort */
/**
 *
 * @author GeeksforGeeks: "https://www.geeksforgeeks.org/merge-sort/"
 * JPOje
 *
 */
public class NPCLoc_MergeSort
{
	int size = 20;
	NPCHumanObject[] NPCHO = new NPCHumanObject[size];

	// Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    public void merge(NPCHumanObject arr[], int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays - Will need to match the objects comparing */
        NPCHumanObject L[] = new NPCHumanObject [n1];
        NPCHumanObject R[] = new NPCHumanObject [n2];

        /*Copy data to temp arrays*/
        for (int i=0; i<n1; ++i)
            L[i] = arr[l + i];
        for (int j=0; j<n2; ++j)
            R[j] = arr[m + 1+ j];


        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2)
        {
        	// The only code that actually compares itself
        	// Can change this one line to meet the needs of the comparators.
            if (L[i].getPosX() <= R[j].getPosX())
            {
                arr[k] = L[i];
                i++;
            }
            else
            {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1)
        {
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2)
        {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // Main function that sorts arr[l..r] using
    // merge()
    public void sort(NPCHumanObject arr[], int l, int r)
    {
        if (l < r)
        {
            // Find the middle point
            int m = (l+r)/2;

            // Sort first and second halves
            sort(arr, l, m);
            sort(arr , m+1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }
}