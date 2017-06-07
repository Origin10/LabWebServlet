package Pets.ExchangeStuff.DAO.DAOinterface;

import Pets.ExchangeStuff.model.Stuff;
import Pets.ExchangeStuff.model.StuffDetail;

import java.util.List;
import java.util.Set;

/**
 * Created by Student on 2017/6/1.
 */
public interface StuffIF {

    public void insert(Stuff stuff);

    public void update(Stuff stuff);

    public void deleteByID(Integer id);

    public Stuff findByPrimaryKey(Integer id);

    public List<Stuff> getAll();

    public Set<StuffDetail> getDetailsByStuffID(Integer id);
}
