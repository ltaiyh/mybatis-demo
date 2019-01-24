package cn.lt.mybatis.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.lt.mybatis.model.User;
import cn.lt.mybatis.model.User1;

/**
 * 原始Dao接口方式测试类
 * @author lt
 * @Date 2019年1月23日 上午9:57:57
 */
public class MybatisDaoTest {
	
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
		User user = sqlSession.selectOne("cn.lt.dao.mapper.UserMapper.queryUserById", 2);
		System.out.println(user);
		sqlSession.close();
	}

	@Test
	public void testInsertUser(){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		User user = new User();
		user.setName("hyy");
		user.setAge(18);
		int row = sqlSession.insert("cn.lt.dao.mapper.UserMapper.insertUser", user);
		sqlSession.commit();//提交事务
		System.out.println(row);
		System.out.println(user.getId());
		sqlSession.close();
	}
	
	@Test
	public void testInsertUser1(){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		User1 user = new User1();
		user.setName("hyy");
		user.setAge(18);
		int row = sqlSession.insert("cn.lt.dao.mapper.UserMapper.insertUser1", user);
		sqlSession.commit();//提交事务
		System.out.println(row);
		System.out.println(user.getId());
		sqlSession.close();
	}
	
}
