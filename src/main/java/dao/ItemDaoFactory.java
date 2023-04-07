package dao;

public class ItemDaoFactory {
    public ItemDao itemDao=null;
    public ItemDao createItemDao (DaoEnum type){

        switch (type){
            case MySQLHiber:
                break;
            case PostgreHiber:
                itemDao=(ItemDaoImplPostHiber) new ItemDaoImplPostHiber();
                break;
        }
        return itemDao;
    }
}
