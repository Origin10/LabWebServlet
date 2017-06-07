package Pets.BloodBank.service;

import Pets.BloodBank.DAO.BloodBankDAO;
import Pets.BloodBank.model.BloodBank;
import Pets.BloodBank.model.BloodDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * Created by Student on 2017/6/1.
 */


@Service
public class BloodBankService {

    @Autowired private BloodBankDAO BloodBankDAO;

    public void insert(BloodBank BloodBank){
         BloodBankDAO.insert(BloodBank);
    }

    public void update(BloodBank BloodBank){
        BloodBankDAO.update(BloodBank);
    }

    public void delete(Integer id){
        BloodBankDAO.delete(id);
    }

    public BloodBank findByPrimaryKey(Integer id){
        return BloodBankDAO.findByPrimaryKey(id);
    }

    public List<BloodBank> getAll(){
        return BloodBankDAO.getAll();
    }

    public Set<BloodDetail> getDetailsByBloodBankID(Integer id){
        return BloodBankDAO.getDetailsByBloodBankID(id);
    }


}
