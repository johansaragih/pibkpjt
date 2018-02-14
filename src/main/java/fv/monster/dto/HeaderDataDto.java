/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fv.monster.dto;

import fv.monster.model.*;
import java.math.BigDecimal;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Administrator
 */
public class HeaderDataDto {
    int JNS_AJU;
    int KD_JNS_PIBK;
    String NO_BARANG;
    String KD_KANTOR;
    int KD_JNS_ANGKUT;
    String NM_PENGANGKUT;
    String NO_FLIGHT;
    String KD_PEL_MUAT;
    String KD_PEL_BONGKAR;
    String KD_GUDANG;
    String NO_INVOICE;
    String TGL_INVOICE;
    String KD_NEGARA_ASAL;
    int JML_BRG;
    String NO_BC11;
    String TGL_BC11;
    String NO_POS_BC11;
    String NO_SUBPOS_BC11;
    String NO_SUBSUBPOS_BC11;
    String NO_MASTER_BLAWB;
    String TGL_MASTER_BLAWB;
    String NO_HOUSE_BLAWB;
    String TGL_HOUSE_BLAWB;
    String KD_NEG_PENGIRIM;
    String NM_PENGIRIM;
    String AL_PENGIRIM;
    int JNS_ID_PENERIMA;
    String NO_ID_PENERIMA;
    String NM_PENERIMA;
    String AL_PENERIMA;
    String TELP_PENERIMA;
    int JNS_ID_PEMBERITAHU;
    String NO_ID_PEMBERITAHU;
    String NM_PEMBERITAHU;
    String AL_PEMBERITAHU;
    String NO_IZIN_PEMBERITAHU;
    String TGL_IZIN_PEMBERITAHU;
    String KD_VAL;
    BigDecimal NDPBM;
    BigDecimal FOB;
    BigDecimal ASURANSI;
    BigDecimal FREIGHT;
    BigDecimal CIF;
    BigDecimal NETTO;
    BigDecimal BRUTO;
    BigDecimal TOT_DIBAYAR;
    String NPWP_BILLING;
    String NAMA_BILLING;
    
    String TGL_TIBA;
    String JAM_TIBA;
    String PART_SHIPMENT;
    String KD_PEL_TRANSIT;
    String KD_PEL_AKHIR;
    BigDecimal VOLUME;
    int TOTAL_PARTIAL;
    String KD_KMS;
    String MARKING;
    
    List<DetailDataDto> details;

    public int getJNS_AJU() {
        return JNS_AJU;
    }

    public void setJNS_AJU(int JNS_AJU) {
        this.JNS_AJU = JNS_AJU;
    }

    public int getKD_JNS_PIBK() {
        return KD_JNS_PIBK;
    }

    public void setKD_JNS_PIBK(int KD_JNS_PIBK) {
        this.KD_JNS_PIBK = KD_JNS_PIBK;
    }

    public String getNO_BARANG() {
        return NO_BARANG;
    }

    public void setNO_BARANG(String NO_BARANG) {
        this.NO_BARANG = NO_BARANG;
    }

    public String getKD_KANTOR() {
        return KD_KANTOR;
    }

    public void setKD_KANTOR(String KD_KANTOR) {
        this.KD_KANTOR = KD_KANTOR;
    }

    public int getKD_JNS_ANGKUT() {
        return KD_JNS_ANGKUT;
    }

    public void setKD_JNS_ANGKUT(int KD_JNS_ANGKUT) {
        this.KD_JNS_ANGKUT = KD_JNS_ANGKUT;
    }

    public String getNM_PENGANGKUT() {
        return NM_PENGANGKUT;
    }

    public void setNM_PENGANGKUT(String NM_PENGANGKUT) {
        this.NM_PENGANGKUT = NM_PENGANGKUT;
    }

    public String getNO_FLIGHT() {
        return NO_FLIGHT;
    }

    public void setNO_FLIGHT(String NO_FLIGHT) {
        this.NO_FLIGHT = NO_FLIGHT;
    }

    public String getKD_PEL_MUAT() {
        return KD_PEL_MUAT;
    }

    public void setKD_PEL_MUAT(String KD_PEL_MUAT) {
        this.KD_PEL_MUAT = KD_PEL_MUAT;
    }

    public String getKD_PEL_BONGKAR() {
        return KD_PEL_BONGKAR;
    }

    public void setKD_PEL_BONGKAR(String KD_PEL_BONGKAR) {
        this.KD_PEL_BONGKAR = KD_PEL_BONGKAR;
    }

    public String getKD_GUDANG() {
        return KD_GUDANG;
    }

    public void setKD_GUDANG(String KD_GUDANG) {
        this.KD_GUDANG = KD_GUDANG;
    }

    public String getNO_INVOICE() {
        return NO_INVOICE;
    }

    public void setNO_INVOICE(String NO_INVOICE) {
        this.NO_INVOICE = NO_INVOICE;
    }

    public String getTGL_INVOICE() {
        return TGL_INVOICE;
    }

    public void setTGL_INVOICE(String TGL_INVOICE) {
        this.TGL_INVOICE = TGL_INVOICE;
    }

    public String getKD_NEGARA_ASAL() {
        return KD_NEGARA_ASAL;
    }

    public void setKD_NEGARA_ASAL(String KD_NEGARA_ASAL) {
        this.KD_NEGARA_ASAL = KD_NEGARA_ASAL;
    }

    public int getJML_BRG() {
        return JML_BRG;
    }

    public void setJML_BRG(int JML_BRG) {
        this.JML_BRG = JML_BRG;
    }

    public String getNO_BC11() {
        return NO_BC11;
    }

    public void setNO_BC11(String NO_BC11) {
        this.NO_BC11 = NO_BC11;
    }

    public String getTGL_BC11() {
        return TGL_BC11;
    }

    public void setTGL_BC11(String TGL_BC11) {
        this.TGL_BC11 = TGL_BC11;
    }

    public String getNO_POS_BC11() {
        return NO_POS_BC11;
    }

    public void setNO_POS_BC11(String NO_POS_BC11) {
        this.NO_POS_BC11 = NO_POS_BC11;
    }

    public String getNO_SUBPOS_BC11() {
        return NO_SUBPOS_BC11;
    }

    public void setNO_SUBPOS_BC11(String NO_SUBPOS_BC11) {
        this.NO_SUBPOS_BC11 = NO_SUBPOS_BC11;
    }

    public String getNO_SUBSUBPOS_BC11() {
        return NO_SUBSUBPOS_BC11;
    }

    public void setNO_SUBSUBPOS_BC11(String NO_SUBSUBPOS_BC11) {
        this.NO_SUBSUBPOS_BC11 = NO_SUBSUBPOS_BC11;
    }

    public String getNO_MASTER_BLAWB() {
        return NO_MASTER_BLAWB;
    }

    public void setNO_MASTER_BLAWB(String NO_MASTER_BLAWB) {
        this.NO_MASTER_BLAWB = NO_MASTER_BLAWB;
    }

    public String getTGL_MASTER_BLAWB() {
        return TGL_MASTER_BLAWB;
    }

    public void setTGL_MASTER_BLAWB(String TGL_MASTER_BLAWB) {
        this.TGL_MASTER_BLAWB = TGL_MASTER_BLAWB;
    }

    public String getNO_HOUSE_BLAWB() {
        return NO_HOUSE_BLAWB;
    }

    public void setNO_HOUSE_BLAWB(String NO_HOUSE_BLAWB) {
        this.NO_HOUSE_BLAWB = NO_HOUSE_BLAWB;
    }

    public String getTGL_HOUSE_BLAWB() {
        return TGL_HOUSE_BLAWB;
    }

    public void setTGL_HOUSE_BLAWB(String TGL_HOUSE_BLAWB) {
        this.TGL_HOUSE_BLAWB = TGL_HOUSE_BLAWB;
    }

    public String getKD_NEG_PENGIRIM() {
        return KD_NEG_PENGIRIM;
    }

    public void setKD_NEG_PENGIRIM(String KD_NEG_PENGIRIM) {
        this.KD_NEG_PENGIRIM = KD_NEG_PENGIRIM;
    }

    public String getNM_PENGIRIM() {
        return NM_PENGIRIM;
    }

    public void setNM_PENGIRIM(String NM_PENGIRIM) {
        this.NM_PENGIRIM = NM_PENGIRIM;
    }

    public String getAL_PENGIRIM() {
        return AL_PENGIRIM;
    }

    public void setAL_PENGIRIM(String AL_PENGIRIM) {
        this.AL_PENGIRIM = AL_PENGIRIM;
    }

    public int getJNS_ID_PENERIMA() {
        return JNS_ID_PENERIMA;
    }

    public void setJNS_ID_PENERIMA(int JNS_ID_PENERIMA) {
        this.JNS_ID_PENERIMA = JNS_ID_PENERIMA;
    }

    public String getNO_ID_PENERIMA() {
        return NO_ID_PENERIMA;
    }

    public void setNO_ID_PENERIMA(String NO_ID_PENERIMA) {
        this.NO_ID_PENERIMA = NO_ID_PENERIMA;
    }

    public String getNM_PENERIMA() {
        return NM_PENERIMA;
    }

    public void setNM_PENERIMA(String NM_PENERIMA) {
        this.NM_PENERIMA = NM_PENERIMA;
    }

    public String getAL_PENERIMA() {
        return AL_PENERIMA;
    }

    public void setAL_PENERIMA(String AL_PENERIMA) {
        this.AL_PENERIMA = AL_PENERIMA;
    }

    public String getTELP_PENERIMA() {
        return TELP_PENERIMA;
    }

    public void setTELP_PENERIMA(String TELP_PENERIMA) {
        this.TELP_PENERIMA = TELP_PENERIMA;
    }

    public int getJNS_ID_PEMBERITAHU() {
        return JNS_ID_PEMBERITAHU;
    }

    public void setJNS_ID_PEMBERITAHU(int JNS_ID_PEMBERITAHU) {
        this.JNS_ID_PEMBERITAHU = JNS_ID_PEMBERITAHU;
    }

    public String getNO_ID_PEMBERITAHU() {
        return NO_ID_PEMBERITAHU;
    }

    public void setNO_ID_PEMBERITAHU(String NO_ID_PEMBERITAHU) {
        this.NO_ID_PEMBERITAHU = NO_ID_PEMBERITAHU;
    }

    public String getNM_PEMBERITAHU() {
        return NM_PEMBERITAHU;
    }

    public void setNM_PEMBERITAHU(String NM_PEMBERITAHU) {
        this.NM_PEMBERITAHU = NM_PEMBERITAHU;
    }

    public String getAL_PEMBERITAHU() {
        return AL_PEMBERITAHU;
    }

    public void setAL_PEMBERITAHU(String AL_PEMBERITAHU) {
        this.AL_PEMBERITAHU = AL_PEMBERITAHU;
    }

    public String getNO_IZIN_PEMBERITAHU() {
        return NO_IZIN_PEMBERITAHU;
    }

    public void setNO_IZIN_PEMBERITAHU(String NO_IZIN_PEMBERITAHU) {
        this.NO_IZIN_PEMBERITAHU = NO_IZIN_PEMBERITAHU;
    }

    public String getTGL_IZIN_PEMBERITAHU() {
        return TGL_IZIN_PEMBERITAHU;
    }

    public void setTGL_IZIN_PEMBERITAHU(String TGL_IZIN_PEMBERITAHU) {
        this.TGL_IZIN_PEMBERITAHU = TGL_IZIN_PEMBERITAHU;
    }

    public String getKD_VAL() {
        return KD_VAL;
    }

    public void setKD_VAL(String KD_VAL) {
        this.KD_VAL = KD_VAL;
    }

    public BigDecimal getNDPBM() {
        return NDPBM;
    }

    public void setNDPBM(BigDecimal NDPBM) {
        this.NDPBM = NDPBM;
    }

    public BigDecimal getFOB() {
        return FOB;
    }

    public void setFOB(BigDecimal FOB) {
        this.FOB = FOB;
    }

    public BigDecimal getASURANSI() {
        return ASURANSI;
    }

    public void setASURANSI(BigDecimal ASURANSI) {
        this.ASURANSI = ASURANSI;
    }

    public BigDecimal getFREIGHT() {
        return FREIGHT;
    }

    public void setFREIGHT(BigDecimal FREIGHT) {
        this.FREIGHT = FREIGHT;
    }

    public BigDecimal getCIF() {
        return CIF;
    }

    public void setCIF(BigDecimal CIF) {
        this.CIF = CIF;
    }

    public BigDecimal getNETTO() {
        return NETTO;
    }

    public void setNETTO(BigDecimal NETTO) {
        this.NETTO = NETTO;
    }

    public BigDecimal getBRUTO() {
        return BRUTO;
    }

    public void setBRUTO(BigDecimal BRUTO) {
        this.BRUTO = BRUTO;
    }

    public BigDecimal getTOT_DIBAYAR() {
        return TOT_DIBAYAR;
    }

    public void setTOT_DIBAYAR(BigDecimal TOT_DIBAYAR) {
        this.TOT_DIBAYAR = TOT_DIBAYAR;
    }

    public String getNPWP_BILLING() {
        return NPWP_BILLING;
    }

    public void setNPWP_BILLING(String NPWP_BILLING) {
        this.NPWP_BILLING = NPWP_BILLING;
    }

    public String getNAMA_BILLING() {
        return NAMA_BILLING;
    }

    public void setNAMA_BILLING(String NAMA_BILLING) {
        this.NAMA_BILLING = NAMA_BILLING;
    }

    public String getTGL_TIBA() {
        return TGL_TIBA;
    }

    public void setTGL_TIBA(String TGL_TIBA) {
        this.TGL_TIBA = TGL_TIBA;
    }

    public String getJAM_TIBA() {
        return JAM_TIBA;
    }

    public void setJAM_TIBA(String JAM_TIBA) {
        this.JAM_TIBA = JAM_TIBA;
    }

    public String getPART_SHIPMENT() {
        return PART_SHIPMENT;
    }

    public void setPART_SHIPMENT(String PART_SHIPMENT) {
        this.PART_SHIPMENT = PART_SHIPMENT;
    }

    public String getKD_PEL_TRANSIT() {
        return KD_PEL_TRANSIT;
    }

    public void setKD_PEL_TRANSIT(String KD_PEL_TRANSIT) {
        this.KD_PEL_TRANSIT = KD_PEL_TRANSIT;
    }

    public String getKD_PEL_AKHIR() {
        return KD_PEL_AKHIR;
    }

    public void setKD_PEL_AKHIR(String KD_PEL_AKHIR) {
        this.KD_PEL_AKHIR = KD_PEL_AKHIR;
    }

    public BigDecimal getVOLUME() {
        return VOLUME;
    }

    public void setVOLUME(BigDecimal VOLUME) {
        this.VOLUME = VOLUME;
    }

    public int getTOTAL_PARTIAL() {
        return TOTAL_PARTIAL;
    }

    public void setTOTAL_PARTIAL(int TOTAL_PARTIAL) {
        this.TOTAL_PARTIAL = TOTAL_PARTIAL;
    }

    public String getKD_KMS() {
        return KD_KMS;
    }

    public void setKD_KMS(String KD_KMS) {
        this.KD_KMS = KD_KMS;
    }

    public String getMARKING() {
        return MARKING;
    }

    public void setMARKING(String MARKING) {
        this.MARKING = MARKING;
    }

    public List<DetailDataDto> getDetails() {
        return details;
    }

    public void setDetails(List<DetailDataDto> details) {
        this.details = details;
    }
    
    
}
