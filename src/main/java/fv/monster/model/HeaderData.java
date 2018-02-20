/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fv.monster.model;

import java.math.BigDecimal;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Administrator
 */
@Entity(name="HeaderData")
@Data
@Table(name = "HEADERDATA")
public class HeaderData {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "HEADERDATA_ID")
    private Long id;        
    @Column(name = "JNS_AJU")
    int JNS_AJU;
    @Column(name = "KD_JNS_PIBK")
    int KD_JNS_PIBK;
    @Column(name = "NO_BARANG")
    String nOBARANG;
    @Column(name = "KD_KANTOR")
    String KD_KANTOR;
    @Column(name = "KD_JNS_ANGKUT")
    int KD_JNS_ANGKUT;
    @Column(name = "NM_PENGANGKUT")
    String NM_PENGANGKUT;
    @Column(name = "NO_FLIGHT")
    String NO_FLIGHT;
    @Column(name = "KD_PEL_MUAT")
    String KD_PEL_MUAT;
    @Column(name = "KD_PEL_BONGKAR")
    String KD_PEL_BONGKAR;
    @Column(name = "KD_GUDANG")
    String KD_GUDANG;
    @Column(name = "NO_INVOICE")
    String NO_INVOICE;
    @Column(name = "TGL_INVOICE")
    String TGL_INVOICE;
    @Column(name = "KD_NEGARA_ASAL")
    String KD_NEGARA_ASAL;
    @Column(name = "JML_BRG")
    int JML_BRG;
    @Column(name = "NO_BC11")
    String NO_BC11;
    @Column(name = "TGL_BC11")
    String TGL_BC11;
    @Column(name = "NO_POS_BC11")
    String NO_POS_BC11;
    @Column(name = "NO_SUBPOS_BC11")
    String NO_SUBPOS_BC11;
    @Column(name = "NO_SUBSUBPOS_BC11")
    String NO_SUBSUBPOS_BC11;
    @Column(name = "NO_MASTER_BLAWB")
    String NO_MASTER_BLAWB;
    @Column(name = "TGL_MASTER_BLAWB")
    String TGL_MASTER_BLAWB;
    @Column(name = "NO_HOUSE_BLAWB")
    String NO_HOUSE_BLAWB;
    @Column(name = "TGL_HOUSE_BLAWB")
    String TGL_HOUSE_BLAWB;
    @Column(name = "KD_NEG_PENGIRIM")
    String KD_NEG_PENGIRIM;
    @Column(name = "NM_PENGIRIM")
    String NM_PENGIRIM;
    @Column(name = "AL_PENGIRIM")
    String AL_PENGIRIM;
    @Column(name = "JNS_ID_PENERIMA")
    int JNS_ID_PENERIMA;
    @Column(name = "NO_ID_PENERIMA")
    String NO_ID_PENERIMA;
    @Column(name = "NM_PENERIMA")
    String NM_PENERIMA;
    @Column(name = "AL_PENERIMA")
    String AL_PENERIMA;
    @Column(name = "TELP_PENERIMA")
    String TELP_PENERIMA;
    @Column(name = "JNS_ID_PEMBERITAHU")
    int JNS_ID_PEMBERITAHU;
    @Column(name = "NO_ID_PEMBERITAHU")
    String NO_ID_PEMBERITAHU;
    @Column(name = "NM_PEMBERITAHU")
    String NM_PEMBERITAHU;
    @Column(name = "AL_PEMBERITAHU")
    String AL_PEMBERITAHU;
    @Column(name = "NO_IZIN_PEMBERITAHU")
    String NO_IZIN_PEMBERITAHU;
    @Column(name = "TGL_IZIN_PEMBERITAHU")
    String TGL_IZIN_PEMBERITAHU;
    @Column(name = "KD_VAL")
    String KD_VAL;
    @Column(name = "NDPBM")
    BigDecimal NDPBM;
    @Column(name = "FOB")
    BigDecimal FOB;
    @Column(name = "ASURANSI")
    BigDecimal ASURANSI;
    @Column(name = "FREIGHT")
    BigDecimal FREIGHT;
    @Column(name = "CIF")
    BigDecimal CIF;
    @Column(name = "NETTO")
    BigDecimal NETTO;
    @Column(name = "BRUTO")
    BigDecimal BRUTO;
    @Column(name = "TOT_DIBAYAR")
    BigDecimal TOT_DIBAYAR;
//    @Column(name = "KD_GUDANG_TUJUAN")
    @Column(name = "NPWP_BILLING")
    String NPWP_BILLING;
    @Column(name = "NAMA_BILLING")
    String NAMA_BILLING;
    @Column(name = "TGL_TIBA")
    String TGL_TIBA;
    @Column(name = "JAM_TIBA")
    String JAM_TIBA;
    @Column(name = "PART_SHIPMENT")
    String PART_SHIPMENT;
    @Column(name = "KD_PEL_TRANSIT")
    String KD_PEL_TRANSIT;
    @Column(name = "KD_PEL_AKHIR")
    String KD_PEL_AKHIR;
    @Column(name = "VOLUME")
    BigDecimal VOLUME;
    @Column(name = "TOTAL_PARTIAL")
    int TOTAL_PARTIAL;
    @Column(name = "JNS_KMS")
    String KD_KMS;
    @Column(name = "MARKING")
    String MARKING;
    @OneToMany(mappedBy = "headerData", cascade = CascadeType.ALL, orphanRemoval = true)
    List<DetailData> details;
}
