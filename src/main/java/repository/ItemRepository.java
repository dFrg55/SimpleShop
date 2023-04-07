package repository;

import dao.ItemDao;
import dao.DaoEnum;
import dao.ItemDaoFactory;
import jakarta.ejb.Stateless;
import model.ItemEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Stateless
public class ItemRepository {
    private ItemDao itemDao;

    public ItemRepository(DaoEnum daoEnum) {
        ItemDaoFactory itemDaoFactory=new ItemDaoFactory();
        this.itemDao = itemDaoFactory.createItemDao(daoEnum);
    }

    public ItemEntity findItem(int id){
        return (ItemEntity) itemDao.findById(id);
    }
    public void save(ItemEntity entity) {
        itemDao.save(entity);
    }

    public void delete(int id) {
        itemDao.delete(id);
    }

    public void update(ItemEntity entity) {
        itemDao.update(entity);
    }

    public List<ItemEntity> findAllItem() {
        return itemDao.getAll();
    }
}
