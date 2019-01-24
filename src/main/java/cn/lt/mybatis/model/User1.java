package cn.lt.mybatis.model;

/**
 * 用户实体类
 * @author lt
 * @Date 2019年1月23日 上午9:38:10
 */
public class User1 {
	
	private String id;
	private String name;
	private int age;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
	
}
