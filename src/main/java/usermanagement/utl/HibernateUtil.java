package usermanagement.utl;

import customer.model.customer;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
import school.model.School;
import schoolBus.model.commuteCompany;
import schoolBus.model.commuteTrip;
import schoolBus.model.studentInTrip;
import student.model.Student;
import usermanagement.model.User;


import java.util.Properties;

public class HibernateUtil {

	private static SessionFactory sessionFactory;

	private static SessionFactory createSessionFactory(){


		Configuration configuration = new Configuration();

		Properties properties = new Properties();
		properties.setProperty(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
		properties.setProperty(Environment.URL, "jdbc:mysql://localhost:3306/demo?useSSL=false&serverTimezone=UTC");
		properties.setProperty(Environment.USER, "root");
		properties.setProperty(Environment.PASS, "");
		properties.setProperty(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
		properties.setProperty(Environment.SHOW_SQL, "true");
		properties.setProperty(Environment.HBM2DDL_AUTO, "update");
		properties.setProperty(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

		configuration.setProperties(properties);

		configuration.addAnnotatedClass(User.class);
		configuration.addAnnotatedClass(customer.class);
		configuration.addAnnotatedClass(School.class);
		configuration.addAnnotatedClass(commuteCompany.class);
		configuration.addAnnotatedClass(commuteTrip.class);
		configuration.addAnnotatedClass(studentInTrip.class);
		configuration.addAnnotatedClass(Student.class);

		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();

		sessionFactory = configuration.buildSessionFactory(serviceRegistry);

		return sessionFactory;

	}

	public static SessionFactory getSessionFactory(){
		if (sessionFactory == null)
			sessionFactory = createSessionFactory();

		return sessionFactory;
	}
}



