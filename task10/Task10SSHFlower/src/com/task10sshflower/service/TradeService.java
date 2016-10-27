package com.task10sshflower.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.task10sshflower.dao.impl.BaseDaoAdminImpl;
import com.task10sshflower.dao.impl.BaseDaoCategoryImpl;
import com.task10sshflower.dao.impl.BaseDaoGoodsImpl;
import com.task10sshflower.dao.impl.BaseDaoOrderDetailsImpl;
import com.task10sshflower.dao.impl.BaseDaoOrdersImpl;
import com.task10sshflower.dao.impl.BaseDaoUsersImpl;
import com.task10sshflower.vo.Admin;
import com.task10sshflower.vo.Category;
import com.task10sshflower.vo.Goods;
import com.task10sshflower.vo.OrderDetails;
import com.task10sshflower.vo.Orders;
import com.task10sshflower.vo.Users;
import com.task10sshflower.pojo.*;


public class TradeService {
	private BaseDaoAdminImpl baseDaoAdminImpl;
	private BaseDaoCategoryImpl baseDaoCategoryImpl;
	private BaseDaoGoodsImpl baseDaoGoodsImpl;
	private BaseDaoOrderDetailsImpl baseDaoOrderDetailsImpl;
	private BaseDaoOrdersImpl baseDaoOrdersImpl;
	private BaseDaoUsersImpl baseDaoUsersImpl;
	/**
	 * @return the baseDaoAdminImpl
	 */
	public BaseDaoAdminImpl getBaseDaoAdminImpl() {
		return baseDaoAdminImpl;
	}
	/**
	 * @param baseDaoAdminImpl the baseDaoAdminImpl to set
	 */
	public void setBaseDaoAdminImpl(BaseDaoAdminImpl baseDaoAdminImpl) {
		this.baseDaoAdminImpl = baseDaoAdminImpl;
	}
	/**
	 * @return the baseDaoCategoryImpl
	 */
	public BaseDaoCategoryImpl getBaseDaoCategoryImpl() {
		return baseDaoCategoryImpl;
	}
	/**
	 * @param baseDaoCategoryImpl the baseDaoCategoryImpl to set
	 */
	public void setBaseDaoCategoryImpl(BaseDaoCategoryImpl baseDaoCategoryImpl) {
		this.baseDaoCategoryImpl = baseDaoCategoryImpl;
	}
	/**
	 * @return the baseDaoGoodsImpl
	 */
	public BaseDaoGoodsImpl getBaseDaoGoodsImpl() {
		return baseDaoGoodsImpl;
	}
	/**
	 * @param baseDaoGoodsImpl the baseDaoGoodsImpl to set
	 */
	public void setBaseDaoGoodsImpl(BaseDaoGoodsImpl baseDaoGoodsImpl) {
		this.baseDaoGoodsImpl = baseDaoGoodsImpl;
	}
	/**
	 * @return the baseDaoOrderDetailsImpl
	 */
	public BaseDaoOrderDetailsImpl getBaseDaoOrderDetailsImpl() {
		return baseDaoOrderDetailsImpl;
	}
	/**
	 * @param baseDaoOrderDetailsImpl the baseDaoOrderDetailsImpl to set
	 */
	public void setBaseDaoOrderDetailsImpl(BaseDaoOrderDetailsImpl baseDaoOrderDetailsImpl) {
		this.baseDaoOrderDetailsImpl = baseDaoOrderDetailsImpl;
	}
	/**
	 * @return the baseDaoOrdersImpl
	 */
	public BaseDaoOrdersImpl getBaseDaoOrdersImpl() {
		return baseDaoOrdersImpl;
	}
	/**
	 * @param baseDaoOrdersImpl the baseDaoOrdersImpl to set
	 */
	public void setBaseDaoOrdersImpl(BaseDaoOrdersImpl baseDaoOrdersImpl) {
		this.baseDaoOrdersImpl = baseDaoOrdersImpl;
	}
	/**
	 * @return the baseDaoUsersImpl
	 */
	public BaseDaoUsersImpl getBaseDaoUsersImpl() {
		return baseDaoUsersImpl;
	}
	/**
	 * @param baseDaoUsersImpl the baseDaoUsersImpl to set
	 */
	public void setBaseDaoUsersImpl(BaseDaoUsersImpl baseDaoUsersImpl) {
		this.baseDaoUsersImpl = baseDaoUsersImpl;
	}
	
	
	/**
	 * 用户注册
	 * @param user
	 */
	public void UserRegister(Users user) {
		baseDaoUsersImpl.add(user);
	}
	
	
	/**
	 * 用户登录
	 * @param userLogin
	 * @return
	 */
	public Boolean UserLogin(UserLogin userLogin)
	{
		List<Users> user = baseDaoUsersImpl.find(userLogin.getUserName());
		if (user.size() != 0) {
			if (user.get(0).getPassWord().equals(userLogin.getPassword())) {
				return true;
			}
		}
		return false;
	}
	
	
	/**
	 * 管理员注册
	 * @param admin
	 */
	public void AdminRegister(Admin admin)
	{
		baseDaoAdminImpl.add(admin);
	}
	
	
	/**
	 * 管理员登录
	 * @param adminLogin
	 * @return
	 */
	public Boolean AdminLogin(AdminLogin adminLogin)
	{
		List<Admin> admin = baseDaoAdminImpl.find(adminLogin.getAdminName());
		if (admin.size() != 0) {
			if (admin.get(0).getPassWord().equals(adminLogin.getPassword())) {
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * 按类型搜索
	 * @param type
	 * @return
	 */
	public List<Goods> searchByType(String type)
	{
		List<Goods> goods = new ArrayList<>();
		List<Category> categories = baseDaoCategoryImpl.find(type);
		for (Category category : categories) {
			Set<Goods> g = category.getGoods();
			for (Iterator<Goods> iterator = g.iterator(); iterator.hasNext();) {
				goods.add(iterator.next());
			}
		}
		
		return goods;
	}
	
	
	/**
	 * 按价格范围搜索
	 * @param price
	 * @return
	 */
	public List<Goods> searchByPrice(String price)
	{
		//baseDaoCategoryImpl.find(price);
		List<Goods> goods = baseDaoGoodsImpl.find(price);
		for (Goods goods2 : goods) {
			System.out.println(goods2.toString());
		}
		return goods;
	}
	
	
	/**
	 * 按照名称搜索
	 * @param name
	 * @return
	 */
	public List<Goods> searchByName(String name)
	{
		List<Goods> goods = baseDaoGoodsImpl.findEx(name);
		return goods;
	}
	
	
	/**
	 * 查找单个商品是否存在
	 * @param goods
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Boolean addCart(String goods, HttpServletRequest request)
	{
		// 查找数据库商品是否存在
		Goods g = baseDaoGoodsImpl.get(goods);
		if (g.getGoodsName().isEmpty()) {
			return false;
		}
		
		// 添加购物车代码
		// 获取session
		HttpSession session = request.getSession();
		
		// 从session中获取购物车对象
		Map<String, Integer> cart = (Map<String, Integer>) session.getAttribute("cart");
		
		// 通过cart判断是否是第一次访问
		if (cart == null) {
			// 创建购物车
			cart = new HashMap<>();
			// 第一次访问
			cart.put(goods, 1);
			// 存入session
			session.setAttribute("cart", cart);
		}else{
			// 不是第一次访问，判断是否已经选购此商品
			if (cart.containsKey(goods)) {
				// 如果购物车中有此商品，则在原有数量的基础上+1
				Integer count = cart.get(goods) + 1;
				cart.put(goods, count);
				
				// 存入session
				session.setAttribute("cart", cart);
			}else{
				// 如果不包含
				cart.put(goods, 1);
				
				// 存入session
				session.setAttribute("cart", cart);
			}
		}
		
		return true;
	}
	
	
	/**
	 * 用户购物车信息
	 * @param request
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<OrderDetails> goodsOrderInfo(HttpServletRequest request)
	{
		HttpSession session = request.getSession();
		Map<String, Integer> cart = (Map<String, Integer>) session.getAttribute("cart");
		
		// 如果session中没有cart购物车，返回空。
		if (cart == null) {
			return null;
		}
		
		// 将购物车中商品保存在orderDetails中
		// 遍历cart中的KEY，得到商品名称，然后去goods中查询对应价格
		List<OrderDetails> orderDetails = new ArrayList<>();
		int index = 1;
		Iterator<Map.Entry<String, Integer>> iterator = cart.entrySet().iterator();
		while(iterator.hasNext())
		{
			Map.Entry<String, Integer> iter = iterator.next();
			OrderDetails od = new OrderDetails();
			String name = iter.getKey();
			od.setGoodsName(name);
			od.setId(index);
			++index;
			od.setNum(iter.getValue());
			Goods goods = baseDaoGoodsImpl.get(name);
			od.setPrice(goods.getPrice().multiply(BigDecimal.valueOf(od.getNum())));
			orderDetails.add(od);
		}
		
		return orderDetails;
	}
	
	/**
	 * 订单提交
	 * @param request
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Boolean orderSubmit(HttpServletRequest request)
	{
		HttpSession session = request.getSession();
		// 详情表
		Set<OrderDetails> orderDetails = new HashSet<>();
		
		// 订单
		Orders orders = new Orders();
		
		// 商品总数，商品总价
		int goodsCounts = 0;
		BigDecimal goodsPrice = new BigDecimal(0.00);
		
		//获取去用户信息
		UserLogin user = (UserLogin) session.getAttribute("UserLoginSession");
		
		// 购物车
		Map<String, Integer> cart = (Map<String, Integer>) session.getAttribute("cart");
		
		// 枚举购物车
		Iterator<Map.Entry<String, Integer>> iterator = cart.entrySet().iterator();
		while(iterator.hasNext())
		{
			Map.Entry<String, Integer> iter = iterator.next();
			String goodsName = iter.getKey();
			OrderDetails od = new OrderDetails();
			
			// 商品名称
			od.setGoodsName(goodsName);
			
			// 商品数量
			int tempCount = iter.getValue();
			goodsCounts += tempCount;
			od.setNum(tempCount);
			
			// 商品单价
			Goods goods = baseDaoGoodsImpl.get(goodsName);
			
			BigDecimal tempPrice = goods.getPrice();
			goodsPrice = goodsPrice.add(tempPrice.multiply(BigDecimal.valueOf(tempCount)));
			od.setPrice(goods.getPrice());
			
			// 商品详情ID自动增加
			
			// 添加到list中
			orderDetails.add(od);
		}
		
		// 添加订单到数据库
		orders.setUserName(user.getUserName());
		orders.setNum(goodsCounts);
		orders.setSum(goodsPrice);
		orders.setCreateTime(new Date());
		orders.setOrderDetails(orderDetails);
		baseDaoOrdersImpl.add(orders);
		
		int id = baseDaoOrdersImpl.getLast().getOrdersId();
		
		for (OrderDetails o : orderDetails) {
			o.setOrdersId(id);
			o.setOrders(orders);
			baseDaoOrderDetailsImpl.add(o);
		}
		
		return true;
	}
	
	/**
	 * 获取用户列表
	 * @return
	 */
	public List<Users> getUsers()
	{
		List<Users> list = baseDaoUsersImpl.findAll();
		return list;
	}
	
	
	
	/**
	 * 获取用户列表
	 * @return
	 */
	public List<Orders> getOrders()
	{
		List<Orders> list = baseDaoOrdersImpl.findAll();
		return list;
	}
	
	
	/**
	 * 获取商品列表
	 * @return
	 */
	public List<Category> getGoods()
	{
		List<Category> list = baseDaoCategoryImpl.findAll();
		return list;
	}
	
	/**
	 * 删除用户
	 * @param id
	 */
	public void deleteUser(Integer id)
	{
		Users users = baseDaoUsersImpl.get(id);
		baseDaoUsersImpl.delete(users);
		
	}
	
	/**
	 * 删除订单
	 * @param id
	 */
	public void deleteOrder(Integer id)
	{
		baseDaoOrdersImpl.delete(id);
	}
	
	/**
	 * 删除商品
	 * @param id
	 */
	public void deleteGoods(Integer id)
	{
		baseDaoGoodsImpl.delete(id);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
