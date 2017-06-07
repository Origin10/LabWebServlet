package Pets.ExchangeStuff.DAO;


import Pets.ExchangeStuff.DAO.DAOinterface.StuffDeIF;
import Pets.ExchangeStuff.model.StuffDetail;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Created by Student on 2017/6/1.
 */

@Repository
public class StuffDetailDAO  implements StuffDeIF{


    @Override
    public void insert(StuffDetail stuffDetail) {

    }

    @Override
    public void update(StuffDetail stuffDetail) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public StuffDetail findByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public List<StuffDetail> getAll() {
        return null;
    }

//    @Override
//    public List<Stuff> getAll() {
//        List<Stuff> list = null;
//        return list;
//    }


}
