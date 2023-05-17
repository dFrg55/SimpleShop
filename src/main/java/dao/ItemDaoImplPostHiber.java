package dao;

import model.ItemEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

public class ItemDaoImplPostHiber implements ItemDao<ItemEntity> {

    public ItemEntity findById(int id) {

        // Получить сессию Hibernate
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();

        // Начать транзакцию
        Transaction tx = session.beginTransaction();

        // Создать HQL-запрос
        Query query = session.createQuery("from ItemEntity where id = :id");

        // Установить параметр id
        query.setParameter("id", id);

        // Получить список результатов
        List<ItemEntity> result = query.list();

        // Завершить транзакцию
        tx.commit();

        // Закрыть сессию
        session.close();

        return result.stream().findFirst().orElse(null);

    }

    @Override
    public List<ItemEntity> getAll() {

        // Получить сессию Hibernate
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();

        // Создать HQL-запрос
        Query query = session.createQuery("from ItemEntity order by name");

        // Получить список результатов
        List<ItemEntity> result = query.list();

        // Закрыть сессию
        session.close();

        return result;

    }



    @Override
    public void update(ItemEntity entity) {
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
        Query query = session.createQuery("delete from ItemEntity where id = :id");

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
    public void save(ItemEntity entity) {
        update(entity);
    }
}
