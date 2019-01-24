package cn.lt.mybatis.model;

/**
 * 延迟加载，一对一关联映射查询实体类
 * @author lt
 * @Date 2019年1月24日 下午2:16:58
 */
public class OrderExt extends Order{
	
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "OrderExt [" + super.toString() + ", " + user
				+ "]";
	}
	
}
