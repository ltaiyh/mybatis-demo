package cn.lt.mybatis.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.lt.mybatis.mapper.UserMapper;
import cn.lt.mybatis.model.Order;
import cn.lt.mybatis.model.OrderExt;
import cn.lt.mybatis.model.OrderExt1;
import cn.lt.mybatis.model.User;
import cn.lt.mybatis.model.UserExt;

/**
 * Mapper代理方式测试类
 * @author lt
 * @Date 2019年1月23日 上午9:57:57
 */
public class MybatisMapperTest {
	
	private SqlSessionFactory sqlSessionFactory;
	
	@Before
	public void initSqlSessionFactory() throws IOException{
		InputStream is = Resources.getResourceAsStream("MybatisConfig.xml");
		SqlSessionFactoryBuilder bulider = new SqlSessionFactoryBuilder();
		sqlSessionFactory = bulider.build(is);
	}
	
	@Test
	public void testQueryUserById(){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user = userMapper.queryUserById(5);
		System.out.println(user);
		//一级缓存	
		user = userMapper.queryUserById(5);
		System.out.println(user);
		sqlSession.close();
	}

	@Test
	public void testInsertUser(){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user = new User();
		user.setName("hyy66");
		user.setAge(18);
		int row = userMapper.insertUser(user);
		sqlSession.commit();//提交事务，不然无法保存到数据库
		System.out.println(row);
		//主键返回
		System.out.println(user.getId());
		sqlSession.close();
	}
	
	@Test
	public void testQueryOrder(){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		List<OrderExt> orders = userMapper.queryOrder();
		for(OrderExt order : orders){
			System.out.println(order.getUserId());
			//延迟加载
			System.out.println(order.getUser());//此时才去加载从信息
		}
		sqlSession.close();
		
	}
	
	@Test
	public void testQueryUser(){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		List<UserExt> users = userMapper.queryUser();
		for(UserExt user : users){
			System.out.println(user.getId());
			//延迟加载
			List<Order> order = user.getOrders();
			System.out.println(order);//此时才去加载从信息
		}
		sqlSession.close();
	}
	
	@Test
	public void testOne2One1(){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		List<OrderExt1> orders = userMapper.one2One1();
		for(OrderExt1 order : orders){
			System.out.println(order);
		}
		sqlSession.close();
	}
	
	@Test
	public void testOne2One(){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		List<OrderExt> orders = userMapper.one2One();
		for(OrderExt order : orders){
			System.out.println(order);
		}
		sqlSession.close();
	}
	
	@Test
	public void testOne2Many(){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		List<UserExt> users = userMapper.one2Many();
		for(UserExt user : users){
			System.out.println(user);
		}
		sqlSession.close();
	}
	
}
