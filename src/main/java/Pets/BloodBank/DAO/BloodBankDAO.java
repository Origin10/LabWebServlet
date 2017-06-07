package Pets.BloodBank.DAO;


import Pets.BloodBank.DAO.DAOinterface.BloodBankIF;
import Pets.BloodBank.model.BloodBank;
import Pets.BloodBank.model.BloodDetail;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

/**
 * Created by Student on 2017/6/1.
 */

@Repository
public class BloodBankDAO implements BloodBankIF {


    @Override
    public void insert(BloodBank BloodBank) {

    }

    @Override
    public void update(BloodBank BloodBank) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public BloodBank findByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public List<BloodBank> getAll() {
        return null;
    }

    @Override
    public Set<BloodDetail> getDetailsByBloodBankID(Integer id) {
//        Set<BloodDetail>set = findByPrimaryKey(id).getBloodBankDetail();
//        return set;
        return null;
    }

}
