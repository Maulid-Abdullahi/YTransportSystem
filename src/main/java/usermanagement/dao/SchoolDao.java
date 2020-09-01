package usermanagement.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import school.model.School;
import usermanagement.utl.HibernateUtil;
import java.util.List;

/**
 * CRUD database operations
 * @author Maulid
 *
 */
public class SchoolDao {

    /**
     * Save School
     *
     * @param schools
     */
    public void saveSchool(School schools) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the school object
            session.save(schools);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    /**
     * Update School
     *
     * @param schools
     */
    public void updateSchool(School schools) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the school object
            session.update(schools);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    /**
     * Delete School
     *
     * @param id
     */
    public void deleteSchool(int id) {

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();

            // Delete a school object
            School schools = session.get(School.class, id);
            if (schools != null) {
                session.delete(schools);
                System.out.println("school is deleted");
            }

            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    /**
     * Get School By ID
     *
     * @param id
     * @return
     */
    public School getSchool(int id) {

        Transaction transaction = null;
        School schools = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object
            schools = session.get(School.class, id);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return schools;
    }

    /**
     * Get all School
     *
     * @return
     */
    @SuppressWarnings("unchecked")


    public List<School> selectAllSchools(){

        List<School> listOfSchools = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            // get a school object
            listOfSchools = session.createQuery("FROM  School s").getResultList();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());

        }
        return listOfSchools;
    }
}
