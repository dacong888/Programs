package com.task09sshvipsystem.service;

import java.util.LinkedList;
import java.util.List;

import com.task09sshvipsystem.dao.impl.BaseDaoCommodityImpl;
import com.task09sshvipsystem.dao.impl.BaseDaoConsumeImpl;
import com.task09sshvipsystem.dao.impl.BaseDaoUserAuthImpl;
import com.task09sshvipsystem.dao.impl.BaseDaoVipImpl;
import com.task09sshvipsystem.pojo.GoodsCollect;
import com.task09sshvipsystem.pojo.GoodsRetrival;
import com.task09sshvipsystem.pojo.LoginRegister;
import com.task09sshvipsystem.pojo.UserAuth;
import com.task09sshvipsystem.pojo.UserReg;
import com.task09sshvipsystem.pojo.VipConsume;
import com.task09sshvipsystem.pojo.Vips;
import com.task09sshvipsystem.vo.Commodity;
import com.task09sshvipsystem.vo.Consume;
import com.task09sshvipsystem.vo.User;
import com.task09sshvipsystem.vo.Vip;
/**
 * DAO业务封装
 * @author Songbin
 *
 */
public class VipSystemService {
	private BaseDaoCommodityImpl baseDaoCommodityImpl;
	private BaseDaoConsumeImpl baseDaoConsumeImpl;
	private BaseDaoUserAuthImpl baseDaoUserAuthImpl;
	private BaseDaoVipImpl baseDaoVipImpl;

	public BaseDaoCommodityImpl getBaseDaoCommodityImpl() {
		return baseDaoCommodityImpl;
	}

	public void setBaseDaoCommodityImpl(BaseDaoCommodityImpl baseDaoCommodityImpl) {
		this.baseDaoCommodityImpl = baseDaoCommodityImpl;
	}

	public BaseDaoConsumeImpl getBaseDaoConsumeImpl() {
		return baseDaoConsumeImpl;
	}

	public void setBaseDaoConsumeImpl(BaseDaoConsumeImpl baseDaoConsumeImpl) {
		this.baseDaoConsumeImpl = baseDaoConsumeImpl;
	}

	public BaseDaoUserAuthImpl getBaseDaoUserAuthImpl() {
		return baseDaoUserAuthImpl;
	}

	public void setBaseDaoUserAuthImpl(BaseDaoUserAuthImpl baseDaoUserAuthImpl) {
		this.baseDaoUserAuthImpl = baseDaoUserAuthImpl;
	}

	public BaseDaoVipImpl getBaseDaoVipImpl() {
		return baseDaoVipImpl;
	}

	public void setBaseDaoVipImpl(BaseDaoVipImpl baseDaoVipImpl) {
		this.baseDaoVipImpl = baseDaoVipImpl;
	}

	public Boolean loginRegister(LoginRegister loginRegister) {
		if (!loginRegister.getPassword().equals(loginRegister.getRetryPassword())) {
			return false;
		}

		User u = new User();
		u.setUsername(loginRegister.getUserName());
		u.setPassword(loginRegister.getPassword());
		u.setQuanxian(loginRegister.getPrivilage());
		baseDaoUserAuthImpl.add(u);
		return true;
	}

	public Boolean verifyLogin(UserAuth userAuth) {
		List<User> u = baseDaoUserAuthImpl.find(userAuth.getUsername());
		if (u.size() != 0) {
			if (u.get(0).getPassword().equals(userAuth.getPassword())) {
				userAuth.setQuanxian(u.get(0).getQuanxian());
				return true;
			}
		}

		return false;
	}

	public void goodsInsert(GoodsCollect goodsCollect) {
		Commodity commodity = new Commodity();
		commodity.setCommodityName(goodsCollect.getName());
		commodity.setPrice(goodsCollect.getPrice());
		commodity.setAgio(goodsCollect.getAgio());
		baseDaoCommodityImpl.add(commodity);
	}

	public List<Commodity> getGoodsInfo(GoodsRetrival goodsRetrival) {
		List<Commodity> list = new LinkedList<>();
		if (goodsRetrival.getSelect().equals("goods_id")) {
			list.add(baseDaoCommodityImpl.get(Integer.parseInt(goodsRetrival.getContent())));
			return list;
		} else if (goodsRetrival.getSelect().equals("goods_name")) {
			return baseDaoCommodityImpl.find(goodsRetrival.getContent());
		}

		return null;
	}

	public List<Commodity> getGoods() {
		return baseDaoCommodityImpl.find();
	}

	public void userAdd(UserReg userReg) {
		User user = new User();
		user.setUsername(userReg.getUsername());
		user.setPassword(userReg.getPassword());
		user.setQuanxian(userReg.getQuanxian());

		baseDaoUserAuthImpl.add(user);
	}

	public List<User> userGet() {
		return baseDaoUserAuthImpl.find();
	}

	public void userDelete(User user) {
		List<User> list = baseDaoUserAuthImpl.find(user.getUsername());
		baseDaoUserAuthImpl.delete(list.get(0));
	}

	public void vipAdd(Vips vips) {
		Vip vip = new Vip();
		vip.setAge(vips.getAge());
		vip.setName(vips.getName());
		vip.setProfession(vips.getProfession());
		vip.setJoinTime(vips.getJoinTime());

		baseDaoVipImpl.add(vip);
	}

	public List<Vip> vipGet() {
		return baseDaoVipImpl.find();
	}

	public int vipGoodsAdd(VipConsume vipConsume) {
		Boolean isVipExist = false;
		Boolean isCommodityExist = false;
		List<Vip> v = vipGet();
		for (Vip vip : v) {
			if (vipConsume.getVipName().equals(vip.getName())) {
				isVipExist = true;
				break;
			}
		}

		List<Commodity> c = getGoods();
		for (Commodity commodity : c) {
			if (vipConsume.getGoodsName().equals(commodity.getCommodityName())) {
				isCommodityExist = true;
				break;
			}
		}

		if (!isVipExist) {
			return 1;
		}

		if (!isCommodityExist) {
			return 2;
		}

		Consume consume = new Consume();
		consume.setVipId(vipConsume.getVipId());
		consume.setName(vipConsume.getVipName());
		consume.setCommodityId(vipConsume.getGoodsId());
		consume.setCommodityName(vipConsume.getGoodsName());
		consume.setPrice(vipConsume.getGoodsPrice());
		consume.setPracitcePrice(vipConsume.getGoodsPrice().subtract(
				vipConsume.getGoodsPrice().multiply(baseDaoCommodityImpl.get(vipConsume.getGoodsId()).getAgio())));
		baseDaoConsumeImpl.add(consume);
		return 3;
	}

	public List<Consume> vipGoodsGet(String content) {
		return baseDaoConsumeImpl.find(content);
	}

}
