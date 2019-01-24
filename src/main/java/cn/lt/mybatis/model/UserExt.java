package cn.lt.mybatis.model;

import java.util.List;

/**
 * 延迟加载，一对多关联映射查询实体类
 * @author lt
 * @Date 2019年1月24日 下午2:18:06
 */
public class UserExt extends User {
	
	private static final long serialVersionUID = 1L;
	
	private List<Order> orders;

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "UserExt [" + super.toString() + " orders=" + orders
				+ "]";
	}
	
}
