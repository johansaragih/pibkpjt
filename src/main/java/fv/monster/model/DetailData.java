/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fv.monster.model;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author Administrator
 */
@Entity(name="DetailData")
@Data
@Table(name = "DETAILDATA")
public class DetailData {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="HEADERDATA_ID")
    private HeaderData headerData;
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "DETAILDATA_ID")
    private Long id;
    @Column(name = "NO_HOUSE_BLAWB")
    String NO_HOUSE_BLAWB;
    @Column(name = "SERI_BRG")
    String SERI_BRG;
    @Column(name = "HS_CODE")
    String HS_CODE;
    @Column(name = "UR_BRG")
    String UR_BRG;
    @Column(name = "KD_NEG_ASAL")
    String KD_NEG_ASAL;
    @Column(name = "JML_KMS")
    int JML_KMS;
    @Column(name = "JNS_KMS")
    String JNS_KMS;
    @Column(name = "CIF")
    BigDecimal CIF;
    @Column(name = "KD_SAT_HRG")
    String KD_SAT_HRG;
    @Column(name = "JML_SAT_HRG")
    int JML_SAT_HRG;
    @Column(name = "FL_BEBAS")
    String FL_BEBAS;
    @Column(name = "NO_SKEP")
    String NO_SKEP;
    @Column(name = "TGL_SKEP")
    String TGL_SKEP;
    @Column(name = "JNS_TARIF")
    String JNS_TARIF;
    @Column(name = "KD_TARIF")
    String KD_TARIF;
    @Column(name = "KD_SAT_TARIF")
    String KD_SAT_TARIF;
    @Column(name = "JML_SAT")
    int JML_SAT;
    @Column(name = "BM_TRF")
    BigDecimal BM_TRF;
    @Column(name = "PPH_TRF")
    BigDecimal PPH_TRF;
    @Column(name = "PPN_TRF")
    BigDecimal PPN_TRF;
    @Column(name = "PPNBM_TRF")
    BigDecimal PPNBM_TRF;
    @Column(name = "BM")
    BigDecimal BM;
    @Column(name = "PPH")
    BigDecimal PPH;
    @Column(name = "PPN")
    BigDecimal PPN;
    @Column(name = "PPNBM")
    BigDecimal PPNBM;
}
