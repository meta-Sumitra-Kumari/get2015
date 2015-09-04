package Sorting;

/**
 * @author Sumitra this program is to sort an unsorted array by using the
 *         concept of quick sort. will be used when array is of greater than
 *         size 10.
 */
public class QuickSort {

	/**
	 * 
	 * @param arr
	 *            array which is to be sorted
	 * @param start
	 *            starting index of array
	 * @param end
	 *            last index of array
	 */
	void sort(int arr[], int start, int end) {

		if (end != -1) {
			if (start <= end)
			// will execute till start is less than end i.e they do not cross
			// each other.
			{
				int i = start;
				int j = end;
				int pivot = start;
				// Assigning pivot with start index of array
				while (i < j)
				// while they dont cross each other
				{
					while (arr[i] <= arr[pivot] && i < end)
					// if arr[i] is small than arr[pivot] and i is less than
					// last index
					{
						i++;
					}
					while (arr[j] > arr[pivot] && j >= start)
					// checking that arr[pivot] is smaller than arr[j] and j is
					// greater than smallest index
					{
						j--;
					}
					if (i < j)
					// if they did not crosses each other and values are greater
					// than we will call swap method

					{
						swap(arr, i, j);
					}
				}
				swap(arr, j, pivot);
				// to change the pivot with j.
				sort(arr, start, j - 1);
				// Recursive call
				sort(arr, j + 1, end);
			}
		}

	}

	/**
	 * 
	 * @param arr
	 *            array of value
	 * @param i
	 *            index
	 * @param j
	 *            index i and j are to be swapped with each other.
	 */
	void swap(int arr[], int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
