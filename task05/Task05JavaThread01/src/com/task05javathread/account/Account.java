package com.task05javathread.account;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Account {
	private int balance = 100;
	private ReadWriteLock rwLock = new ReentrantReadWriteLock(); // 产生一个锁对象

	// 用户存款
	public void userDeposit(int amount) {
		rwLock.writeLock().lock();// 取到写锁
		try {
			System.out.println("用户存入：" + amount + "元。");
			this.balance += amount;
			System.out.println("用户账户余额：" + this.balance + "元。");
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} finally {
			rwLock.writeLock().unlock(); // 释放写锁
		}
	}

	// 用户取款
	public boolean userWithdraw(int amount) {

		if (balance == 0) {
			return false;
		}
		rwLock.writeLock().lock(); // 取到写锁
		try {
			System.out.println("用户取出：" + amount + "元。");
			this.balance -= amount;
			try {
				Thread.sleep(10);
			} catch (Exception e) {
				e.printStackTrace();
			}

			rwLock.readLock().lock(); // 获取读锁
			try {
				System.out.println("用户账户余额：" + this.balance + "元。");
				try {
					Thread.sleep(10);
				} catch (Exception e) {
					e.printStackTrace();
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				rwLock.readLock().unlock(); // 释放读锁
			}
		} finally {
			rwLock.writeLock().unlock(); // 释放写锁
		}

		return true;
	}

}
