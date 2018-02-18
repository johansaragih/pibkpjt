package fv.monster.model;

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
 * @author Johan Saragih
 */
//@Entity(name="DetailBarang")
//@Data
//@Table(name = "DETAILBARANG")
public class DetailBarang {
    private static final long serialVersionUID = 1L;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="masterbarang_id")
    private MasterBarang masterBarang;
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "DETAILBARANG_ID")
    private Long id;
    @Column(name = "SERI_BRG")
    private String seriBarang;
    @Column(name = "HS_CODE")
    private String hsCode;
    @Column(name = "UR_BRG")
    private String uraianBarang;
    @Column(name = "KD_NEG_ASAL")
    private String kodeNegaraAsal;
    @Column(name = "JML_KMS")
    private String jumlahKemasan;
    @Column(name = "JNS_KMS")
    private String jenisKemasan;
    @Column(name = "CIF")
    private String CIF;
    @Column(name = "KD_SAT_HRG")
    private String kodeSatuanHarga;
    @Column(name = "JML_SAT_HRG")
    private String jumlahSatuanHarga;
    @Column(name = "FL_BEBAS")
    private String flagPembebasan;
    @Column(name = "NO_SKEP")
    private String nomorSKEPembebasan;
    @Column(name = "TGL_SKEP")
    private String tanggalSKEPPembebasan;
    @Column(name = "KD_PUNGUTAN")
    private String kodePungutan;
    @Column(name = "NILAI")
    private String nilai;
    @Column(name = "KD_TARIF")
    private String kodeTarif;
    @Column(name = "KD_SAT_TARIF")
    private String kodeSatuanTarif;
    @Column(name = "JML_SAT")
    private String jumlahSatuanTarif;
    @Column(name = "TARIF")
    private String tarif;
    @Column(name = "NO_HOUSE_BLAWB")
    private String nomorHouseBLAWB;
    @Column(name = "JNS_TARIF")
    private String jenisTarif;
    @Column(name = "BM_TRF")
    private String beaMasukTarif;
    @Column(name = "PPH_TRF")
    private String pajakPenghasilanTarif;
    @Column(name = "PPN_TRF")
    private String pajakPertambahanNilaiTarif;
    @Column(name = "PPNBM_TRF")
    private String pajakPertambahanNilaiBarangMewahTarif;
}
