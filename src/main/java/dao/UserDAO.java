package dao;

import model.UserEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

public class UserDAO implements ItemDao<UserEntity>{

    @Override
    public UserEntity findById(int id) {
        // Получить сессию Hibernate
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();

        // Начать транзакцию
        Transaction tx = session.beginTransaction();

        // Создать HQL-запрос
        Query query = session.createQuery("from UserEntity where id = :id");

        // Установить параметр id
        query.setParameter("id", id);

        // Получить список результатов
        List<UserEntity> result = query.list();

        // Завершить транзакцию
        tx.commit();

        // Закрыть сессию
        session.close();

        return result.stream().findFirst().orElse(null);
    }

    @Override
    public List<UserEntity> getAll() {
        // Получить сессию Hibernate
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();

        // Создать HQL-запрос
        Query query = session.createQuery("from UserEntity order by name");

        // Получить список результатов
        List<UserEntity> result = query.list();

        // Закрыть сессию
        session.close();

        return result;
    }

    @Override
    public void update(UserEntity entity) {
        // Получить сессию Hibernate
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();

        // Начать транзакцию
        Transaction tx = session.beginTransaction();

        // Сохранить или обновить объект
        session.saveOrUpdate(entity);

        tx.commit();

        // Закрыть сессию
        session.close();
    }

    @Override
    public boolean delete(int id) {
        // Получить сессию Hibernate
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();

        // Начать транзакцию
        Transaction tx = session.beginTransaction();

        // Создать HQL-запрос
        Query query = session.createQuery("delete from UserEntity where id = :id");

        // Установить параметр id
        query.setParameter("id", id);

        // Выполнить запрос вернет result количество удаленных строк
        int result = query.executeUpdate();

        // Завершить транзакцию
        tx.commit();

        // Закрыть сессию
        session.close();

        if (result > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void save(UserEntity entity) {
        update(entity);
    }

    public boolean deleteByLogin(String login) {
        // Получить сессию Hibernate
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();

        // Начать транзакцию
        Transaction tx = session.beginTransaction();

        // Создать HQL-запрос
        Query query = session.createQuery("delete from UserEntity where login = :login");

        // Установить параметр id
        query.setParameter("login", login);

        // Выполнить запрос вернет result количество удаленных строк
        int result = query.executeUpdate();

        // Завершить транзакцию
        tx.commit();

        // Закрыть сессию
        session.close();

        if (result > 0) {
            return true;
        } else {
            return false;
        }
    }

    public String getRoleByLoginPassword(final String login, final String password) {
        // Получить сессию Hibernate
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();

        // Начать транзакцию
        Transaction tx = session.beginTransaction();

        // Создать HQL-запрос
        Query query = session.createQuery("from UserEntity where login = :login and password=:password");

        query.setParameter("login", login);
        query.setParameter("password", password);

        // Получить список результатов
        List<UserEntity> result = query.list();

        // Завершить транзакцию
        tx.commit();

        // Закрыть сессию
        session.close();

        return result.stream().findFirst().get().getRole();
    }

    public static boolean userIsExist(final String login, final String password) {
        if(login==null&&password==null){
            return false;
        }

        // Получить сессию Hibernate
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();

        // Начать транзакцию
        Transaction tx = session.beginTransaction();


        // Создать HQL-запрос
//        Query query = session.createQuery("from UserEntity  where login = 'admin' and password='123'");
        Query query = session.createQuery("from UserEntity  where login = :login and password=:password");

        query.setParameter("login", login);
        query.setParameter("password", password);

        // Получить список результатов
//        List<UserEntity> resultList = null;
        //TODO не может достать запрос
        List resultList = query.list();

        // Завершить транзакцию
        tx.commit();

        // Закрыть сессию
        session.close();

        if (resultList==null)
            return false;
        else
            return true;
    }
}
