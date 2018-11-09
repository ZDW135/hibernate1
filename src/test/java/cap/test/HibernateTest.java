package cap.test;

import cap.bean.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateTest {
    private SessionFactory sessionFactory;

    public void init() {
        Configuration configuration = new Configuration().configure();
        sessionFactory = configuration.buildSessionFactory();
    }
    public void testAdd() {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Product product = new Product();
        product.setStock(12);
        product.setPrice(33.0);
        product.setName("jsp ");
        product.setSerialNumber("hhhhh");
        session.save(product);
        tx.commit();
        session.close();

    }
    public void testFind() {
        Session session = sessionFactory.openSession();
        Product product = session.get(Product.class, 1);
        System.out.println(product.getName() + ":" + product.getSerialNumber());
        session.close();
    }

}