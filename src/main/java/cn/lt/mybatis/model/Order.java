package cn.lt.mybatis.model;

/**
 * 用户订单类
 * @author lt
 * @Date 2019年1月23日 下午3:10:57
 */
public class Order {
	
	private int id;
	private int userId;
	private int number;
	private String note;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", userId=" + userId + ", number=" + number
				+ ", note=" + note + "]";
	}
	
}
