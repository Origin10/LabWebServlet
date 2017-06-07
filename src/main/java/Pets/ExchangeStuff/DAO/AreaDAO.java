package Pets.ExchangeStuff.DAO;


import Pets.ExchangeStuff.DAO.DAOinterface.AreaIF;
import Pets.ExchangeStuff.model.Area;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Student on 2017/6/1.
 */

@Repository
public class AreaDAO implements AreaIF {


    @Override
    public void insert(Area area) {

    }

    @Override
    public void update(Area area) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public Area findByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public List<Area> getAll() {
        return null;
    }


}
