package Pets.ExchangeStuff.DAO.DAOinterface;

import Pets.ExchangeStuff.model.Cart;

import java.util.List;

/**
 * Created by Student on 2017/6/1.
 */
public interface CartIF {

    public void insert(Cart cart);

    public void update(Cart cart);

    public void delete(Integer id);

    public Cart findByPrimaryKey(Integer id);

    public List<Cart> getAll();

}
