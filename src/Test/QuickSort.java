package Test;

public class QuickSort {
    public static void quickSort(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        quickSort(array, 0, array.length - 1);
    }

    private static void quickSort(int[] array, int low, int high) {
        if (low >= high) {
            return;
        }

        int pivotIndex = partition(array, low, high);
        quickSort(array, low, pivotIndex - 1);
        quickSort(array, pivotIndex + 1, high);
    }

    private static int partition(int[] array, int low, int high) {
        int pivot = array[low]; // 选取第一个元素作为pivot
        int left = low + 1;
        int right = high;

        while (left <= right) {
            while (left <= right && array[left] <= pivot) {
                left++;
            }

            while (left <= right && array[right] > pivot) {
                right--;
            }

            if (left < right) {
                // 交换左右两个元素
                int temp = array[left];
                array[left] = array[right];
                array[right] = temp;
            }
        }

        // 将pivot放置到正确的位置
        int temp = array[right];
        array[right] = array[low];
        array[low] = temp;

        return right;
    }

    public static void main(String[] args) {
        int[] array = {6, 2, 8, 1, 4, 3, 9, 5, 7};
        quickSort(array);
        System.out.println("Sorted array:");
        for (int num : array) {
            System.out.print(num + " ");
        }
    }
}
