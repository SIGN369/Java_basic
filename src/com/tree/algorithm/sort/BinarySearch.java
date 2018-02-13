package com.tree.algorithm.sort;
/**
 * ���ֲ��ҷ��� �ŵ㣺�����ٶȿ�
 * 					 ȱ�㣺��������������
 * @author zyg
 *要查看注释请将workspace默认编码改为GBK，在右键点击属性即可查看注释
 */
public class BinarySearch {
	/** 
     * ���ֲ��ҵݹ�ʵ�֡� 
     * @param srcArray  �������� 
     * @param start ����͵�ַ�±� 
     * @param end   ����ߵ�ַ�±� 
     * @param key  ����Ԫ�� 
     * @return ����Ԫ�ز����ڷ���-1 
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
     * ���ֲ�����ͨʵ�֡� 
     * @param srcArray �������� 
     * @param key ����Ԫ�� 
     * @return  �����ڷ���-1 
     */  
    public static int binSearchs(int srcArray[], int key) {  
    	//��ȡ�м�������
        int mid = srcArray.length / 2;  
        if (key == srcArray[mid]) {  
        	//���Ҫ��ѯ�������м�����Ⱦͷ��ض�Ӧ������
            return mid;  
        }  
  //������㡣�յ㣬�Ƚϴ�С��������ѡ�����Ǳ߲���
        int start = 0;  
        int end = srcArray.length - 1;  
        while (start <= end) {  
        	//ÿһ�ָ����Ҫ�����ָ�ٲ���
            mid = (end - start) / 2 + start;  //�ؼ�һ�䣬start��end�ı仯
            if (key < srcArray[mid]) {  
                end = mid - 1;  
            } else if (key > srcArray[mid]) {  
                start = mid + 1;  
            } else { 
            	//�������������������ͷŻ����ֵ
                return mid;  
            }  
        }  
        return -1;  
    }  
    	/**
    	 * ����д����Щ�㷨���⣬��Ҫ����ÿһλ�õ�������˼·д��ȥ�����ˣ�����һ����ë��
    	 */
    public static int biSearch(int arr[],int key) {
    	//��ʼѭ������,�����Ҷ��壺����յ�(��̬)
    	int mid;
		int start = 0;
		int end = arr.length-1;
		while(true) { 
			mid = (end-start)/2+start;//��̬�е�ƫ����
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
