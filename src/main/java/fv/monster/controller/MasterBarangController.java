package fv.monster.controller;

import fv.monster.dto.BarangDto;
import fv.monster.model.MasterBarang;
import fv.monster.repository.MasterBarangRepository;
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
public class MasterBarangController {

    private MasterBarangRepository masterBarangRepository;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Value("${upload.path}")
    private String UPLOADED_FOLDER;
//    private String UPLOADED_FOLDER = "C://temp//";
//    private String UPLOADED_FOLDER = "/var/upload";
    
    public MasterBarangController(MasterBarangRepository masterBarangRepository) {
        this.masterBarangRepository = masterBarangRepository;
    }

    @GetMapping("/barang")
    public List<MasterBarang> list() {
        logger.debug("Preparing to get all data");
        return this.masterBarangRepository.findAll();
    }
    
    @GetMapping("/barang/{id}")
    public ResponseEntity<MasterBarang> get(@PathVariable Long id) {
        logger.debug("Preparing to get data by id : " + id);
        MasterBarang masterBarang = this.masterBarangRepository.findOne(id);
        if (masterBarang != null) {
            logger.debug("Data found with id : " + id);
            return ResponseEntity.ok(masterBarang);
        }
        logger.debug("Data not found with id : " + id);
        return ResponseEntity.notFound().build();
    }
    
    @PostMapping("/barang")
    private MasterBarang addBarang(@RequestBody MasterBarang barang) {
        return masterBarangRepository.save(barang);
    }
    
    @PostMapping("/upload") // //new annotation since 4.3
    @ResponseBody
    public ResponseEntity<MasterBarang> upload(@RequestParam("file") MultipartFile file) {
        logger.debug("Processing Upload File"); 
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
            List<MasterBarang> lstMasterBarang = ExcelHandler.process(path.toString());
            masterBarangRepository.save(lstMasterBarang);
//            XMLHandler.createMainXML(lstMasterBarang, "C://temp//", false);
            logger.debug("Saving file content into database is succesfully done");
            return ResponseEntity.ok().build();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResponseEntity.badRequest().build();
    }
    
//    @GetMapping("/error")
//    public ResponseEntity<MasterBarang> error(@PathVariable Long id) {
//        logger.debug("Redirect to error");
//        return ResponseEntity.notFound().build();
//    }
    
//    @PutMapping("/barang/{id}")
//    public ResponseEntity<MasterBarang> update(@PathVariable(value = "id") Long id, @Valid @RequestBody MasterBarang input) {
//        MasterBarang masterBarang = masterBarangRepository.findOne(id);
//        if (masterBarang == null) {
//            return ResponseEntity.notFound().build();
//        }
//        masterBarang.setAlamatPemberitahu(input.getAlamatPemberitahu());
//        masterBarang.setAlamatPenerima(input.getAlamatPenerima());
//        masterBarang.setAlamatPengirim(input.getAlamatPengirim());
//        masterBarang.setId(input.getId());
//        masterBarang.setJenisAJU(input.getJenisAJU());
//        masterBarang.setJenisIDPemberitahu(input.getJenisIDPemberitahu());
//        masterBarang.setJenisIDPenerima(input.getJenisIDPenerima());
//        masterBarang.setJumlahBarang(input.getJumlahBarang());
//        masterBarang.setJumlahBeratBrutto(input.getJumlahBeratBrutto());
//        masterBarang.setJumlahBeratNetto(input.getJumlahBeratNetto());
//        masterBarang.setKodeGudangAsal(input.getKodeGudangAsal());
//        masterBarang.setKodeGudangTujuan(input.getKodeGudangTujuan());
//        masterBarang.setKodeJenisPIBK(input.getKodeJenisPIBK());
//        masterBarang.setKodeJenisAngkut(input.getKodeJenisAngkut());
//        masterBarang.setKodeKantor(input.getJenisIDPenerima());
//        masterBarang.setKodeNegaraAsal(input.getKodeNegaraAsal());
//        masterBarang.setKodeNegaraPengirim(input.getKodeNegaraPengirim());
//        masterBarang.setKodePelabuhanBongkar(input.getKodePelabuhanBongkar());
//        masterBarang.setKodePelabuhanMuat(input.getKodePelabuhanMuat());
//        masterBarang.setKodePungutan(input.getKodePungutan());
//        masterBarang.setKodeValutaAsing(input.getKodeValutaAsing());
//        masterBarang.setDetailBarang(input.getDetailBarang());
//        masterBarang.setNDPBM(input.getNDPBM());
//        masterBarang.setNamaBilling(input.getNamaBilling());
//        masterBarang.setNamaPemberitahu(input.getNamaPemberitahu());
//        masterBarang.setNamaPenerima(input.getNamaPenerima());
//        masterBarang.setNamaPengangkut(input.getNamaPengangkut());
//        masterBarang.setNamaPengirim(input.getNamaPengirim());
//        masterBarang.setNilai(input.getNilai());
//        masterBarang.setNilaiAsuransi(input.getNilaiAsuransi());
//        masterBarang.setNilaiFreight(input.getNilaiFreight());
//        masterBarang.setNilaiTotalCIF(input.getNilaiTotalCIF());
//        masterBarang.setNilaiTotalFOB(input.getNilaiTotalFOB());
//        masterBarang.setNomorBarang(input.getNomorBarang());
//        masterBarang.setNomorDokumenBC11(input.getNomorDokumenBC11());
//        masterBarang.setNomorFlight(input.getNomorFlight());
//        masterBarang.setNomorHouseBLAWB(input.getNomorHouseBLAWB());
//        masterBarang.setTanggalIzinPemberitahu(input.getTanggalIzinPemberitahu());
//        masterBarang.setTanggalMasterBLAWB(input.getTanggalMasterBLAWB());
//        masterBarang.setTeleponPenerima(input.getTeleponPenerima());
//        masterBarang.setTotalDibayar(input.getTotalDibayar());
//        return ResponseEntity.ok(this.masterBarangRepository.save(masterBarang));
//    }
//
//    // Create a new Note
//    @PostMapping("/barang")
//    public MasterBarang create(@Valid @RequestBody MasterBarang masterBarang) {
//        logger.debug("masterBarang value : " + masterBarang.toString());
//        return masterBarangRepository.save(masterBarang);
//    }
//
//    @DeleteMapping("/barang/{id}")
//    public ResponseEntity<MasterBarang> delete(@PathVariable Long id) {
//        MasterBarang masterBarang = this.masterBarangRepository.findOne(id);
//        if (masterBarang != null) {
//            this.masterBarangRepository.delete(id);
//            return ResponseEntity.ok().build();
//        }
//        return ResponseEntity.notFound().build();
//    }
}