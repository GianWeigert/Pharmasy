package factory;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class EntityManagerUtil {

	private static final EntityManagerUtil instance = new EntityManagerUtil();

	private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("en");

	private EntityManagerUtil() {
	}

	public static EntityManagerUtil getInstance() {
		return instance;
	}

	public EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}

	public EntityManager createEntityManager() {
		return entityManagerFactory.createEntityManager();
	}
}