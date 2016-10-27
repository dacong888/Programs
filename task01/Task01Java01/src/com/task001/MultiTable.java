package com.task001;

public class MultiTable {
	public static void main(String[] args){
		System.out.println("---------------------------9*9³Ë·¨±í----------------------------");
		for(int i = 1; i < 10; i++){
			for(int j = 1; j <= i; j++){
				System.out.print(j + "*" + i + "=" + j*i + " ");
			}
			System.out.println(" ");
		}
		System.out.println("--------------------------------------------------------------");
	}
}
