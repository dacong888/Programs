package com.task05javathread.account;

public class Test {
	public static void main(String[] args) {
		int deposit = 1;
		int withdraw = 1;
		Account acc = new Account();
		AccountThread at;
		for (int i = 0; i < 500; i++) {//产生500个存款线程
			at = new AccountThread(acc, true, deposit);
			at.start();
		}

		for (int j = 0; j < 500; j++) {//产生500个取款线程
			at = new AccountThread(acc, false, withdraw);
			at.start();
		}

	}
}

