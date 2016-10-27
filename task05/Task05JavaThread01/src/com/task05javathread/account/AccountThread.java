package com.task05javathread.account;

public class AccountThread extends Thread {

	private Account user;		//账户
	private boolean isDeposite;	//存取款标识
	private int acts;			//存取款数额

	public AccountThread(Account acc, boolean flag, int acts) {
		this.user = acc;
		this.isDeposite = flag;
		this.acts = acts;
	}

	//重载run方法，调用Account账户存款userDeposit()与取款方法userWithdraw()。
	@Override
	public void run() {
		if (isDeposite) {//存款
			this.user.userDeposit(acts);
		} else {//取款
			if (!this.user.userWithdraw(acts)) {
				System.out.println("用户账户没有额度，不能进行取款操作。");
			}
		}
	}
}
