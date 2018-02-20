/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fv.monster.controller;

import barangkirimanclient.ConnectionBuilder;
import barangkirimanclient.WSBarangKiriman;
import fv.monster.dto.HeaderDataDto;
import fv.monster.model.HeaderData;
import fv.monster.repository.DataRepository;
import fv.monster.service.DataService;
import fv.monster.util.ExcelHandler;
import fv.monster.util.Util;
import fv.monster.util.XMLHandler;
import java.io.IOException;
import java.io.StringReader;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.logging.Level;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import rx.Observable;
import rx.Subscriber;
import rx.schedulers.Schedulers;

/**
 *
 * @author Johan Saragih
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path = "/api")
public class DataController {

    @Autowired
    private DataService dataService;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Value("${upload.path}")
    private String UPLOADED_FOLDER;
//    private String UPLOADED_FOLDER = "C://temp//";
//    private String UPLOADED_FOLDER = "/var/upload";

//    public DataController(DataRepository dataRepository) {
//        this.dataRepository = dataRepository;
//    }
    @GetMapping("/data")
    public List<HeaderData> list() {
        logger.debug("Preparing to get all data");
        return this.dataService.getAllData();
    }

    @GetMapping("/data/{id}")
    public ResponseEntity<HeaderData> get(@PathVariable Long id) {
        logger.debug("Preparing to get data by id : " + id);
        HeaderData headerData = this.dataService.getDataById(id);
//        if (headerData != null) {
        logger.debug("Data found with id : " + id);
        return ResponseEntity.ok(headerData);
//        }
//        logger.debug("Data not found with id : " + id);
//        return ResponseEntity.notFound().build();
    }

//    @PostMapping("/data")
//    private HeaderData add(@RequestBody HeaderData headerData) {
//        return dataRepository.save(headerData);
//    }
    @PostMapping("/upload") // //new annotation since 4.3
    @ResponseBody
    public ResponseEntity<HeaderData> upload(@RequestParam("file") MultipartFile file) {
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
            Path uploadedFilepath = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Path xmlFilePath = Paths.get(UPLOADED_FOLDER + "/Main.xml");
            Files.write(uploadedFilepath, bytes);
//            List<MasterBarang> lstMasterBarang = ExcelHandler.process(path.toString());
            List<HeaderDataDto> lstHeaderData = ExcelHandler.process(uploadedFilepath.toString());
            for (HeaderDataDto headerDataDto : lstHeaderData) {
                dataService.addData(headerDataDto);
            }
            XMLHandler.createMainXML(lstHeaderData, xmlFilePath.toString(), false);
            Util.callWS(xmlFilePath.toFile());
            logger.debug("Saving file content into database is succesfully done");
            return ResponseEntity.ok().build();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResponseEntity.badRequest().build();
    }
}
