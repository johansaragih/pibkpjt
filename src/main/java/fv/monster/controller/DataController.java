/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fv.monster.controller;

import fv.monster.model.HeaderData;
import fv.monster.repository.DataRepository;
import fv.monster.util.ExcelHandler;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Johan Saragih
 */

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path = "/api")
public class DataController {
    private DataRepository dataRepository;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Value("${upload.path}")
    private String UPLOADED_FOLDER;
//    private String UPLOADED_FOLDER = "C://temp//";
//    private String UPLOADED_FOLDER = "/var/upload";
    
    public DataController(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    @GetMapping("/data")
    public List<HeaderData> list() {
        logger.debug("Preparing to get all data");
        return this.dataRepository.findAll();
    }
    
    @GetMapping("/data/{id}")
    public ResponseEntity<HeaderData> get(@PathVariable Long id) {
        logger.debug("Preparing to get data by id : " + id);
        HeaderData headerData = this.dataRepository.findOne(id);
        if (headerData != null) {
            logger.debug("Data found with id : " + id);
            return ResponseEntity.ok(headerData);
        }
        logger.debug("Data not found with id : " + id);
        return ResponseEntity.notFound().build();
    }
    
    @PostMapping("/data")
    private HeaderData add(@RequestBody HeaderData headerData) {
        return dataRepository.save(headerData);
    }
    
    @PostMapping("/upload") // //new annotation since 4.3
    @ResponseBody
    public ResponseEntity<HeaderDataDto> upload(@RequestParam("file") MultipartFile file) {
//        logger.debug("Processing Upload File"); 
        if (file.isEmpty()) {
            logger.debug("File is empty");
//            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return ResponseEntity.badRequest().build();
        }

        try {
            logger.debug("File is not empty");
            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);
//            List<MasterBarang> lstMasterBarang = ExcelHandler.process(path.toString());
              List<HeaderDataDto> lstHeaderData = ExcelHandler.process(path.toString());
            dataRepository.save(lstHeaderData);
//            XMLHandler.createMainXML(lstMasterBarang, "C://temp//", false);
            logger.debug("Saving file content into database is succesfully done");
            return ResponseEntity.ok().build();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResponseEntity.badRequest().build();
    }
}
