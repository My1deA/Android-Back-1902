package dao;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


import domain.User;

public class UserDao {

	public void addUser(User user) {
		// TODO Auto-generated method stub
		//hibernate
		//得到配置信息
		Configuration configuration=new Configuration().configure();
		//创建sessionFactory
		SessionFactory sessionFactory= configuration.buildSessionFactory();
		//获得session
		Session session=sessionFactory.openSession();
		//打开事务
		Transaction transaction=session.beginTransaction();
		
		//操作数据库
		//存储user
		session.save(user);
		//提交事务
		transaction.commit();
		//关闭session
		session.close();
	
	}

}
