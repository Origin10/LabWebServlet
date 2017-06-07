package Pets.ExchangeStuff.DAO.DAOinterface;

import Pets.ExchangeStuff.model.StuffDetail;

import java.util.List;

/**
 * Created by Student on 2017/6/1.
 */
public interface StuffDeIF {

    public void insert(StuffDetail stuffDetail);

    public void update(StuffDetail stuffDetail);

    public void delete(Integer id);

    public StuffDetail findByPrimaryKey(Integer id);

    public List<StuffDetail> getAll();

}
