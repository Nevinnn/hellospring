package cn.itcast.a_hello;


import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class App {
//1.�q�L�u�t���o��ioc�e���Ыت���H
	@Test
	public void testIOC() throws Exception {
//		�Ыع�H
//		User user = new User();
		//�{�b���H�Ыإ浹Spring��IOC�e��

		Resource resource = new ClassPathResource("cn/itcast/a_hello/applicationContext.xml");
		//�Ыخe����H(bean���u�t) IOC�e�� = �u�t�� + applicationContext.xml
		BeanFactory factory = new XmlBeanFactory(resource);
		//�o��e���Ыت���H
		User user = (User) factory.getBean("user");//����xml��classID
		System.out.println(user.getId());
	}
//2.�i�H�����o��ioc�e����H
	@Test
	public void testAc() throws Exception{
		//�o��ioc�e����H
		ApplicationContext ac = new ClassPathXmlApplicationContext("cn/itcast/a_hello/applicationContext.xml");
		//�q�e�������bean
		User user = (User) ac.getBean("user");
		System.out.println(user);
	}
}
