/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fv.monster.model;

import java.math.BigDecimal;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Administrator
 */
public class HeaderData {
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
    
    List<DetailData> details;
}
