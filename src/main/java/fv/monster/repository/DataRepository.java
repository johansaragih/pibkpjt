/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fv.monster.repository;

import fv.monster.model.HeaderData;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Johan Saragih
 */
public interface DataRepository extends JpaRepository<HeaderData, Long>{
    HeaderData findOneByNOBARANG(String nOBARANG);
}
