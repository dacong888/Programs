package com.task002;
import java.util.Arrays;

public class ArrayMax {
	
	public static int getArrayMax(int[] arrayData){
		for(int i = 0; i < arrayData.length - 1; i++){
			for(int j = 0; j < arrayData.length - i - 1; j++){
				if (arrayData[j] < arrayData[j+1]) {
					int temp = arrayData[j];
					arrayData[j] = arrayData[j+1];
					arrayData[j+1] = temp;
				}
			}
		}
		
		return arrayData[0];
	}
	
	public static void main(String[] args){
		int[] arrayData = new int[10];
		for (int i = 0; i < arrayData.length; i++) {
			arrayData[i] = (int)(Math.random() * 100);
		}
		
		System.out.println("数组arrayData随机产生的10个整数为：" + Arrays.toString(arrayData));
		int maxData = getArrayMax(arrayData);
		System.out.println("数组arrayData中的最大值为：" + maxData);
	}

}
