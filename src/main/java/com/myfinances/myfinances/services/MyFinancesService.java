package com.myfinances.myfinances.services;

import com.myfinances.myfinances.dto.MyFinancesDTO;
import com.myfinances.myfinances.mapper.VOMapper;
import com.myfinances.myfinances.models.MyFinancesModel;
import com.myfinances.myfinances.repositories.MyFinanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyFinancesService {
    @Autowired
    MyFinanceRepository myFinanceRepository;

    public MyFinancesDTO findById(Long findItemById) {
        MyFinancesModel entityModel = myFinanceRepository.findById(findItemById).orElseThrow();
        return VOMapper.parseObjectClassDTOToModel(entityModel, MyFinancesDTO.class);
    }

    public List<MyFinancesDTO> findAll() {
        return VOMapper.parseListClassDTOToModel(myFinanceRepository.findAll(), MyFinancesDTO.class);
    }

    public MyFinancesDTO create(MyFinancesDTO addNewEntityDTO) {
        MyFinancesModel entityModel = VOMapper.parseObjectClassDTOToModel(addNewEntityDTO, MyFinancesModel.class);
        MyFinancesDTO entityDTO = VOMapper.parseObjectClassDTOToModel(myFinanceRepository.save(entityModel), MyFinancesDTO.class);

        return entityDTO;
    }

    public MyFinancesDTO update(MyFinancesDTO updateNewEntityDTO) {
        MyFinancesModel updateEntityModel = myFinanceRepository.findById(updateNewEntityDTO.getId()).orElseThrow();

        updateEntityModel.setEmpresa(updateNewEntityDTO.getEmpresa());
        updateEntityModel.setValorDespesa(updateNewEntityDTO.getValorDespesa());
        updateEntityModel.setDataPagamento(updateNewEntityDTO.getDataPagamento());

        return VOMapper.parseObjectClassDTOToModel(myFinanceRepository.save(updateEntityModel), MyFinancesDTO.class);
    }

    public ResponseEntity<?> delete(Long deleteEntityModel) {
        MyFinancesModel entityModel = myFinanceRepository.findById(deleteEntityModel).orElseThrow();
        myFinanceRepository.delete(entityModel);
        return ResponseEntity.noContent().build();
    }
}
