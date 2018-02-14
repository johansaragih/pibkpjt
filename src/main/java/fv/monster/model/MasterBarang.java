package fv.monster.model;

import java.io.Serializable;
import java.util.ArrayList;
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

/**
 *
 * @author Johan Saragih
 */
@Entity(name="MasterBarang")
@Data
@Table(name = "MASTERBARANG")
public class MasterBarang implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "MASTERBARANG_ID")
    private Long id;
    @Column(name = "JNS_AJU")
    private String jenisAJU;
    @Column(name = "KD_JNS_PIBK")
    private String kodeJenisPIBK;
    @Column(name = "NO_BARANG")
    private String nomorBarang;
    @Column(name = "KD_KANTOR")
    private String kodeKantor;
    @Column(name = "KD_JNS_ANGKUT")
    private String kodeJenisAngkut;
    @Column(name = "NM_PENGANGKUT")
    private String namaPengangkut;
    @Column(name = "NO_FLIGHT")
    private String nomorFlight;
    @Column(name = "KD_PEL_MUAT")
    private String kodePelabuhanMuat;
    @Column(name = "KD_PEL_BONGKAR")
    private String kodePelabuhanBongkar;
    @Column(name = "KD_GUDANG")
    private String kodeGudangAsal;
    @Column(name = "NO_INVOICE")
    private String nomorInvoice;
    @Column(name = "TGL_INVOICE")
    private String tanggalInvoice;
    @Column(name = "KD_NEGARA_ASAL")
    private String kodeNegaraAsal;
    @Column(name = "JML_BRG")
    private String jumlahBarang;
    @Column(name = "NO_BC11")
    private String nomorDokumenBC11;
    @Column(name = "TGL_BC11")
    private String tanggalDokumenBC11;
    @Column(name = "NO_POS_BC11")
    private String nomorPosBC11;
    @Column(name = "NO_SUBPOS_BC11")
    private String nomorSubPosBC11;
    @Column(name = "NO_SUBSUBPOS_BC11")
    private String nomorSubSubPosBC11;
    @Column(name = "NO_MASTER_BLAWB")
    private String nomorMasterBLAWB;
    @Column(name = "TGL_MASTER_BLAWB")
    private String tanggalMasterBLAWB;
    @Column(name = "NO_HOUSE_BLAWB")
    private String nomorHouseBLAWB;
    @Column(name = "TGL_HOUSE_BLAWB")
    private String tanggalHouseBLAWB;
    @Column(name = "KD_NEG_PENGIRIM")
    private String kodeNegaraPengirim;
    @Column(name = "NM_PENGIRIM")
    private String namaPengirim;
    @Column(name = "AL_PENGIRIM")
    private String alamatPengirim;
    @Column(name = "JNS_ID_PENERIMA")
    private String jenisIDPenerima;
    @Column(name = "NO_ID_PENERIMA")
    private String nomorIDPenerima;
    @Column(name = "NM_PENERIMA")
    private String namaPenerima;
    @Column(name = "AL_PENERIMA")
    private String alamatPenerima;
    @Column(name = "TELP_PENERIMA")
    private String teleponPenerima;
    @Column(name = "JNS_ID_PEMBERITAHU")
    private String jenisIDPemberitahu;
    @Column(name = "NO_ID_PEMBERITAHU")
    private String nomorIDPemberitahu;
    @Column(name = "NM_PEMBERITAHU")
    private String namaPemberitahu;
    @Column(name = "AL_PEMBERITAHU")
    private String alamatPemberitahu;
    @Column(name = "NO_IZIN_PEMBERITAHU")
    private String nomorIzinPemberitahu;
    @Column(name = "TGL_IZIN_PEMBERITAHU")
    private String tanggalIzinPemberitahu;
    @Column(name = "KD_VAL")
    private String kodeValutaAsing;
    @Column(name = "NDPBM")
    private String NDPBM;
    @Column(name = "FOB")
    private String nilaiTotalFOB;
    @Column(name = "ASURANSI")
    private String nilaiAsuransi;
    @Column(name = "FREIGHT")
    private String nilaiFreight;
    @Column(name = "CIF")
    private String nilaiTotalCIF;
    @Column(name = "NETTO")
    private String jumlahBeratNetto;
    @Column(name = "BRUTO")
    private String jumlahBeratBrutto;
    @Column(name = "TOT_DIBAYAR")
    private String totalDibayar;
    @Column(name = "KD_GUDANG_TUJUAN")
    private String kodeGudangTujuan;
    @Column(name = "NPWP_BILLING")
    private String npwpBilling;
    @Column(name = "NAMA_BILLING")
    private String namaBilling;
    @Column(name = "KD_PUNGUTAN")
    private String kodePungutan;
    @Column(name = "NILAI")
    private String nilai;
    @Column(name = "TGL_TIBA")
    private String tanggalTiba;
    @Column(name = "JAM_TIBA")
    private String jamTiba;
    @Column(name = "PART_SHIPMENT")
    private String partShipment;
    @Column(name = "KD_PEL_TRANSIT")
    private String kodePelabuhanTransit;
    @Column(name = "KD_PEL_AKHIR")
    private String kodePelabuhanAkhir;
    @Column(name = "VOLUME")
    private String volume;
    @Column(name = "JNS_KMS")
    private String jenisKemasan;
    @Column(name = "TOTAL_PARTIAL")
    private String totalPartial;
    @Column(name = "MARKING")
    private String marking;
    @OneToMany(mappedBy = "masterBarang", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetailBarang> detailBarang = new ArrayList<>();

}