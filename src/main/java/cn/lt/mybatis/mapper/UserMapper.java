package cn.lt.mybatis.mapper;

import java.util.List;

import cn.lt.mybatis.model.OrderExt;
import cn.lt.mybatis.model.OrderExt1;
import cn.lt.mybatis.model.User;
import cn.lt.mybatis.model.User1;
import cn.lt.mybatis.model.UserExt;

/**
 * UserMapper接口
 * @author lt
 * @Date 2019年1月23日 上午11:11:52
 */
public interface UserMapper {
	
	User queryUserById(Integer id);
	
	int insertUser(User user);
	
	int insertUser1(User1 user);
	
	List<OrderExt> queryOrder();
	
	List<UserExt> queryUser();

	List<OrderExt1> one2One1();
	
	List<OrderExt> one2One();

	List<UserExt> one2Many();

}
