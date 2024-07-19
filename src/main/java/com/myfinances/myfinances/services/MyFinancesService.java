package com.myfinances.myfinances.services;

import com.myfinances.myfinances.models.MyFinancesModel;
import com.myfinances.myfinances.repositories.MyFinanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyFinancesService {
    @Autowired
    MyFinanceRepository myFinanceRepository;

    public MyFinancesModel findById(Long findItemById) {
        MyFinancesModel entityModel = myFinanceRepository.findById(findItemById).orElseThrow();
        return entityModel;
    }

    public List<MyFinancesModel> findAll() {
        return myFinanceRepository.findAll();
    }

    public MyFinancesModel create(MyFinancesModel addNewEntityModel) {
        MyFinancesModel addEntityModel = myFinanceRepository.save(addNewEntityModel);
        return addEntityModel;
    }

    public MyFinancesModel update(MyFinancesModel updateNewEntityModel) {
        MyFinancesModel updateEntity = myFinanceRepository.findById(updateNewEntityModel.getId()).orElseThrow();

        updateEntity.setEmpresa(updateNewEntityModel.getEmpresa());
        updateEntity.setValorDespesa(updateNewEntityModel.getValorDespesa());
        updateEntity.setDataPagamento(updateNewEntityModel.getDataPagamento());

        return myFinanceRepository.save(updateEntity);
    }

    public void delete(Long deleteEntityModel) {
        MyFinancesModel entityModel = myFinanceRepository.findById(deleteEntityModel).orElseThrow();
        myFinanceRepository.delete(entityModel);
    }
}
