package cn.itcast.a_hello;


import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class App {
//1.通過工廠類得到ioc容器創建的對象
	@Test
	public void testIOC() throws Exception {
//		創建對象
//		User user = new User();
		//現在把對象創建交給Spring的IOC容器

		Resource resource = new ClassPathResource("cn/itcast/a_hello/applicationContext.xml");
		//創建容器對象(bean的工廠) IOC容器 = 工廠類 + applicationContext.xml
		BeanFactory factory = new XmlBeanFactory(resource);
		//得到容器創建的對象
		User user = (User) factory.getBean("user");//對應xml的classID
		System.out.println(user.getId());
	}
//2.可以直接得到ioc容器對象
	@Test
	public void testAc() throws Exception{
		//得到ioc容器對象
		ApplicationContext ac = new ClassPathXmlApplicationContext("cn/itcast/a_hello/applicationContext.xml");
		//從容器中獲取bean
		User user = (User) ac.getBean("user");
		System.out.println(user);
	}
}
