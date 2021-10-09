package model;
import java.io.Closeable;
import java.lang.AutoCloseable;
import javax.servlet.http.HttpSession;
import model.HibernateUtil;
import model.HibernateUtil;
import static model.HibernateUtil.getSessionFactory;
import model.UserHBN;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.hibernate.Session;
import org.hibernate.Transaction;
public class UserDaoHBN {

    public class CloseableSession implements AutoCloseable {

    private final Session session;

    public CloseableSession(Session session) {
        this.session = session;
    }

    public Session getSession() {
        return session;
    }

    @Override
    public void close() throws Exception {
        session.close();
    }
    
}
    public void saveUser(UserHBN user) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {      
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.save(user);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    

    public boolean validate(String userName, String password) {

        Transaction transaction = null;
        UserHBN user = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object
            user = (UserHBN) session.createQuery("FROM UserHBN U WHERE U.username = :userName").setParameter("userName", userName)
                .uniqueResult();

            if (user != null && user.getPassword().equals(password)) {
//                HttpSession sessions = request.getSession();
//                sessions.setAttribute("user", user);
                return true;
            }
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return false;
    }
}