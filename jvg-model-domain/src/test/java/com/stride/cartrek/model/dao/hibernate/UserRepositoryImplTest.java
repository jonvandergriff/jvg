package com.stride.cartrek.model.dao.hibernate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate4.HibernateTransactionManager;

import com.stride.cartrek.model.dto.Name;
import com.stride.cartrek.model.dto.User;

//@RunWith(JUnit4.class)
public class UserRepositoryImplTest {

	@Test
	public void testSave() {

		ApplicationContext ctx = HibernateDAOTestUtil.setUpTest();

		UserDAO userRepo = (UserDAO) ctx.getAutowireCapableBeanFactory()
				.createBean(UserDAOImpl.class,
						AutowireCapableBeanFactory.AUTOWIRE_BY_TYPE, false);

		User user = new User();

		Name name = new Name();
		name.setFirstName("Jon");
		name.setLastName("Vandergriff");
		name.setPrimry(true);
		name.setTitle("Mr. Awesome");
		user.getNames().add(name);

		userRepo.save(user);

		assertNotNull(user);

		assertEquals("Jon", user.getNames().iterator().next().getFirstName());

//		Search search = new Search(Person.class);
//		search.addFilterEqual("userDetails.username", "test");
//		List<Person> persons = personRepo.search(search);
//
//		Person testPerson = persons.iterator().next();
//
//		assertNotNull(testPerson);
//
		ctx = null;

	}

//	@Test
//	public void testFindByUsername() {
//
//		ApplicationContext ctx = HibernateDAOTestUtil.setUpTest();
//
//		PersonDAO personRepo = (PersonDAO) ctx.getAutowireCapableBeanFactory()
//				.createBean(PersonDAOImpl.class,
//						AutowireCapableBeanFactory.AUTOWIRE_BY_TYPE, false);
//
//		Search search = new Search(Person.class);
//		search.addFilterEqual("userDetails.username", "admin");
//		List<Person> persons = personRepo.search(search);
//
//		assertTrue(persons.size() > 0);
//
//		assertNotNull(personRepo);
//
//	}

}