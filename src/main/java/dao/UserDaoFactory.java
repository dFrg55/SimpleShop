package dao;

public class UserDaoFactory {
    public UserDAO userDao=null;
    public UserDAO createItemDao (DaoEnum type){

        switch (type){
            case MySQL:
                break;
            case PostgreHiber:
                userDao=(UserDAO) new UserDAO();
                break;
        }
        return userDao;
    }
}