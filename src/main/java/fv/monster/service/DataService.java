/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fv.monster.service;

import fv.monster.dto.HeaderDataDto;
import java.util.List;

/**
 *
 * @author Johan Saragih
 */
public interface DataService {
    HeaderDataDto addData(HeaderDataDto headerDataDto);

    HeaderDataDto getDataById(Long id);

    List<HeaderDataDto> getAllData();

    void updateUser(HeaderDataDto headerDataDto);

    void deleteUser(Long id);
}
