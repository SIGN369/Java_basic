package com.tree.algorithm.sort;
/**
 * Binary search demo
 * @author zyg
 */
public class BinarySearch {
	/** 
     * @param srcArray  �������� 
     * @param start ����
     * @param end   ���
     * @param key  ��
     * @return
     */  
    public static int binSearch(int srcArray[], int start, int end, int key) {  
        int mid = (end - start) / 2 + start;  
        if (srcArray[mid] == key) {  
            return mid;  
        }  
        if (start >= end) {  
            return -1;  
        } else if (key > srcArray[mid]) {  
            return binSearch(srcArray, mid + 1, end, key);  
        } else if (key < srcArray[mid]) {  
            return binSearch(srcArray, start, mid - 1, key);  
        }  
       
        return -1;  
      
    }  
	/** 
     * @param srcArray �������� 
     * @param key ���
     * @return  
     */  
    public static int binSearchs(int srcArray[], int key) {  
        int mid = srcArray.length / 2;  
        if (key == srcArray[mid]) {  
            return mid;  
        }  
        int start = 0;  
        int end = srcArray.length - 1;  
        while (start <= end) {  
            mid = (end - start) / 2 + start;  
            if (key < srcArray[mid]) {  
                end = mid - 1;  
            } else if (key > srcArray[mid]) {  
                start = mid + 1;  
            } else { 
                return mid;  
            }  
        }  
        return -1;  
    }  
    public static int biSearch(int arr[],int key) {
    	int mid;
		int start = 0;
		int end = arr.length-1;
		while(true) { 
			mid = (end-start)/2+start;
			if(key>arr[mid]) {
				start = mid+1;
			}else if(key<arr[mid]) {
				end = mid-1;
			}else {
				return mid;
			}
			return -1;
		}
    	
    }
    public static void main(String[] args) {
    	int biSearch = biSearch(new int[] {1,2,3,5,6,8,9},5);
    	System.out.println(biSearch);
	}
}
