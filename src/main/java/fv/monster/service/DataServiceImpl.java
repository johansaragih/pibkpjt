/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fv.monster.service;

import fv.monster.dto.DetailDataDto;
import fv.monster.dto.HeaderDataDto;
import fv.monster.exception.DataAlreadyExistException;
import fv.monster.model.DetailData;
import fv.monster.model.HeaderData;
import fv.monster.repository.DataRepository;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.transaction.Transactional;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Johan Saragih
 */
@Service
@Transactional
public class DataServiceImpl implements DataService{

    @Autowired
    DataRepository dataRepository;
    
    @Override
    public HeaderData addData(HeaderDataDto headerDataDto) {
        HeaderData headerData = dataRepository.findOneByNOBARANG(headerDataDto.getNO_BARANG());
        if (headerData != null) {
            throw new DataAlreadyExistException();
        }
        
        headerData = new HeaderData();
        List<DetailData> lstDetailData = new ArrayList<DetailData>();
        headerData.setAL_PEMBERITAHU(headerDataDto.getAL_PEMBERITAHU());
        headerData.setAL_PENERIMA(headerDataDto.getAL_PENERIMA());
        headerData.setAL_PENGIRIM(headerDataDto.getAL_PENGIRIM());
        headerData.setASURANSI(headerDataDto.getASURANSI());
        headerData.setBRUTO(headerDataDto.getBRUTO());
        headerData.setCIF(headerDataDto.getCIF());
        headerData.setFOB(headerDataDto.getFOB());
        headerData.setFREIGHT(headerDataDto.getFREIGHT());
        headerData.setJAM_TIBA(headerDataDto.getJAM_TIBA());
        headerData.setJML_BRG(headerDataDto.getJML_BRG());
        headerData.setJNS_AJU(headerDataDto.getJNS_AJU());
        headerData.setJNS_ID_PEMBERITAHU(headerDataDto.getJNS_ID_PEMBERITAHU());
        headerData.setJNS_ID_PENERIMA(headerDataDto.getJNS_ID_PENERIMA());
        headerData.setKD_GUDANG(headerDataDto.getKD_GUDANG());
        headerData.setKD_JNS_ANGKUT(headerDataDto.getKD_JNS_ANGKUT());
        headerData.setKD_JNS_PIBK(headerDataDto.getKD_JNS_PIBK());
        headerData.setKD_KANTOR(headerDataDto.getKD_KANTOR());
        headerData.setKD_KMS(headerDataDto.getKD_KMS());
        headerData.setKD_NEGARA_ASAL(headerDataDto.getKD_NEGARA_ASAL());
        headerData.setKD_NEG_PENGIRIM(headerDataDto.getKD_NEG_PENGIRIM());
        headerData.setKD_PEL_AKHIR(headerDataDto.getKD_PEL_AKHIR());
        headerData.setKD_PEL_BONGKAR(headerDataDto.getKD_PEL_BONGKAR());
        headerData.setKD_PEL_MUAT(headerDataDto.getKD_PEL_MUAT());
        headerData.setKD_PEL_TRANSIT(headerDataDto.getKD_PEL_TRANSIT());
        headerData.setKD_VAL(headerDataDto.getKD_VAL());
        headerData.setMARKING(headerDataDto.getMARKING());
        headerData.setNAMA_BILLING(headerDataDto.getNAMA_BILLING());
        headerData.setNDPBM(headerDataDto.getNDPBM());
        headerData.setNETTO(headerDataDto.getNETTO());
        headerData.setNM_PEMBERITAHU(headerDataDto.getNM_PEMBERITAHU());
        headerData.setNM_PENERIMA(headerDataDto.getNM_PENERIMA());
        headerData.setNM_PENGANGKUT(headerDataDto.getNM_PENGANGKUT());
        headerData.setNM_PENGIRIM(headerDataDto.getNM_PENGIRIM());
        headerData.setNOBARANG(headerDataDto.getNO_BARANG());
        headerData.setNO_BC11(headerDataDto.getNO_BC11());
        headerData.setNO_FLIGHT(headerDataDto.getNO_FLIGHT());
        headerData.setNO_HOUSE_BLAWB(headerDataDto.getNO_HOUSE_BLAWB());
        headerData.setNO_ID_PEMBERITAHU(headerDataDto.getNO_ID_PEMBERITAHU());
        headerData.setNO_ID_PENERIMA(headerDataDto.getNO_ID_PENERIMA());
        headerData.setNO_INVOICE(headerDataDto.getNO_INVOICE());
        headerData.setNO_IZIN_PEMBERITAHU(headerDataDto.getNO_IZIN_PEMBERITAHU());
        headerData.setNO_MASTER_BLAWB(headerDataDto.getNO_MASTER_BLAWB());
        headerData.setNO_POS_BC11(headerDataDto.getNO_POS_BC11());
        headerData.setNO_SUBPOS_BC11(headerDataDto.getNO_SUBPOS_BC11());
        headerData.setNO_SUBSUBPOS_BC11(headerDataDto.getNO_SUBSUBPOS_BC11());
        headerData.setNPWP_BILLING(headerDataDto.getNPWP_BILLING());
        headerData.setPART_SHIPMENT(headerDataDto.getPART_SHIPMENT());
        headerData.setTELP_PENERIMA(headerDataDto.getTELP_PENERIMA());
        headerData.setTGL_BC11(headerDataDto.getTGL_BC11());
        headerData.setTGL_HOUSE_BLAWB(headerDataDto.getTGL_HOUSE_BLAWB());
        headerData.setTGL_INVOICE(headerDataDto.getTGL_INVOICE());
        headerData.setTGL_IZIN_PEMBERITAHU(headerDataDto.getTGL_IZIN_PEMBERITAHU());
        headerData.setTGL_MASTER_BLAWB(headerDataDto.getTGL_MASTER_BLAWB());
        headerData.setTGL_TIBA(headerDataDto.getTGL_TIBA());
        headerData.setTOTAL_PARTIAL(headerDataDto.getTOTAL_PARTIAL());
        headerData.setTOT_DIBAYAR(headerDataDto.getTOT_DIBAYAR());
        for (DetailDataDto detail : headerDataDto.getDetails()) {
            DetailData detailData = new DetailData();
            detailData.setBM(detail.getBM());
            detailData.setBM_TRF(detail.getBM_TRF());
            detailData.setCIF(detail.getCIF());
            detailData.setHS_CODE(detail.getHS_CODE());
            detailData.setFL_BEBAS(detail.getFL_BEBAS());
            detailData.setJML_KMS(detail.getJML_KMS());
            detailData.setJML_SAT(detail.getJML_SAT());
            detailData.setJML_SAT_HRG(detail.getJML_SAT_HRG());
            detailData.setKD_TARIF(detail.getKD_TARIF());
            detailData.setNO_HOUSE_BLAWB(detail.getNO_HOUSE_BLAWB());
            detailData.setNO_SKEP(detail.getNO_SKEP());
            detailData.setPPH(detail.getPPH());
            detailData.setPPH_TRF(detail.getPPH_TRF());
            detailData.setPPN(detail.getPPN());
            detailData.setPPNBM(detail.getPPNBM());
            detailData.setPPNBM_TRF(detail.getPPNBM_TRF());
            detailData.setPPN_TRF(detail.getPPN_TRF());
            detailData.setSERI_BRG(detail.getSERI_BRG());
            detailData.setTGL_SKEP(detail.getTGL_SKEP());
            detailData.setUR_BRG(detail.getUR_BRG());
            lstDetailData.add(detailData);
//            detailData.setHeaderData(headerData);
        }
        headerData.setDetails(lstDetailData);
        dataRepository.save(headerData);
        return headerData;
    }

    @Override
    public HeaderData getDataById(Long id) {
        return dataRepository.findOne(id);
    }

    @Override
    public List<HeaderData> getAllData() {
        return dataRepository.findAll();
    }

//    @Override
//    public void updateUser(HeaderDataDto headerDataDto) {
//        dataRepository.save(user);
//    }
//
//    @Override
//    public void deleteUser(Long id) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
}