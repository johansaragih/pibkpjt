/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fv.monster.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author Johan Saragih
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "data_already_exists")
public class DataAlreadyExistException extends RuntimeException{
    
}
