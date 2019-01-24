package cn.lt.mybatis.model;

/**
 * 一对一关联查询结果实体类
 * @author lt
 * @Date 2019年1月24日 上午10:13:43
 */
public class OrderExt1 extends Order{
	
	private String name;
	private String age;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "OrderExt1 [name=" + name + ", age=" + age + ", toString()="
				+ super.toString() + "]";
	}
	
	
}
