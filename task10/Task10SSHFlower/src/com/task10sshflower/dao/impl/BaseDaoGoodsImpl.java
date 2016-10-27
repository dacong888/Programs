package com.task10sshflower.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.task10sshflower.dao.BaseDao;
import com.task10sshflower.vo.Goods;

public class BaseDaoGoodsImpl extends HibernateDaoSupport implements BaseDao<Goods> {

	@Override
	public List<Goods> find() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * 解析内容
	 * @param content
	 * @return
	 */
	private String ParseContent(String content)
	{
		String temp;
		switch (content) {
		case "goods_100":
			temp = "100";
			break;
		case "goods_200":
			temp = "200";
			break;
		case "goods_300":
			temp = "300";
			break;
		default:
			temp = null;
			break;
		}
		return temp;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Goods> find(String key) {

		String temp = ParseContent(key);
		String hql = null;
		if (temp.equals("100"))
		{
			hql = "from Goods where price between 100 and 200";
		}
		else if (temp.equals("200")) 
		{
			hql = "from Goods where price between 200 and 300";
		}
		else if (temp.equals("300"))
		{
			hql = "from Goods where price > 300";
		}
		
		return this.getHibernateTemplate().find(hql);
	}

	@Override
	public Goods get(Integer key) {
		return this.getHibernateTemplate().load(Goods.class, key);
	}

	@Override
	public void add(Goods entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Goods entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String hql, String key) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void edit(Goods entity) {
		// TODO Auto-generated method stub
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Goods> findAll() {
		String hql = "from Goods";
		return this.getHibernateTemplate().find(hql);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Goods get(String key) {
		
		String hql = "from Goods where goodsName = ?";
		List<Goods> list = this.getHibernateTemplate().find(hql, key);
		if (list.size() == 0) {
			return null;
		}
		
		return list.get(0);
	}

	@Override
	public Goods getLast() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Integer id) {
		Goods goods = get(id);
		this.getHibernateTemplate().delete(goods);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Goods> findEx(String key) {
		String hql = "from Goods where goodsName = ?";
		return this.getHibernateTemplate().find(hql, key);
	}

}
