package repository;

import dao.*;
import model.ItemEntity;
import model.UserEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

public class UserRepository {
    private UserDAO userDAO;

    public UserRepository(DaoEnum daoEnum) {
        UserDaoFactory userDaoFactory=new UserDaoFactory();
        this.userDAO = userDaoFactory.createItemDao(daoEnum);
    }

    public UserEntity findItem(int id){
        return (UserEntity) userDAO.findById(id);
    }
    public void save(UserEntity entity) {
        userDAO.save(entity);
    }

    public void delete(int id) {
        userDAO.delete(id);
    }

    public void update(UserEntity entity) {
        userDAO.update(entity);
    }

    public List<UserEntity> findAllItem() {
        return userDAO.getAll();
    }

    public boolean deleteByLogin(String login){
        return userDAO.deleteByLogin(login);
    }

    public String getRoleByLoginPassword(final String login, final String password) {
        return userDAO.getRoleByLoginPassword( login, password);
    }
    public  boolean userIsExist(final String login, final String password) {
        return userDAO.userIsExist( login,  password);
    }
    public UserEntity findUserByLoginAndPasword(final String login, final String password){
        return userDAO.findUserByLoginAndPasword( login,  password);
    }
    public String getRoleByToken(String Token){
        return userDAO.getRoleByToken(Token);
    }

}
