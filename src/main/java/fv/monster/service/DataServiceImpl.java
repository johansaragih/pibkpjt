/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fv.monster.service;

import fv.monster.exception.DataAlreadyExistsException;
import fv.monster.dto.HeaderDataDto;
import fv.monster.model.HeaderData;
import fv.monster.repository.DataRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Johan Saragih
 */
public class DataServiceImpl implements DataService{

    @Autowired
    DataRepository dataRepository;
    
    @Override
    public HeaderDataDto addData(HeaderDataDto headerDataDto) {
        HeaderData headerData = dataRepository.findOneByNomorBarang(headerDataDto.getNO_BARANG());
        if (headerData != null) {
            throw new DataAlreadyExistException();
        }
    }

    @Override
    public HeaderDataDto getDataById(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<HeaderDataDto> getAllData() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateUser(HeaderDataDto headerDataDto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteUser(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
