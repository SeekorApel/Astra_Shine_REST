package id.co.astratech.astra.vo;

import id.co.astratech.astra.model.Transaksi;

import java.util.Date;

public class TransaksiListVo {
    private Integer idTransaksi;

    private Integer idUser;

    private String namaUser;

    private String noTelp;

    private Double longitude;

    private Double latitude;

    private Integer idAlamat;

    private String namaAlamat;

    private Integer idDurasi;

    private String namaDurasi;

    private Date tanggalPesanan;

    private Date tanggalPengiriman;

    private String statusPembayaran;

    private String statusPesanan;

    private Integer ongkir;

    private Integer totalHarga;

    private String catatan;

    public TransaksiListVo(Transaksi transaksi) {
        this.idTransaksi = transaksi.getId_transaksi();
        this.idUser = transaksi.getId_user();
        this.idAlamat = transaksi.getId_alamat();
        this.idDurasi = transaksi.getId_durasi();
        this.tanggalPesanan = transaksi.getTanggal_pesanan();
        this.tanggalPengiriman = transaksi.getTanggal_pengiriman();
        this.statusPembayaran = transaksi.getStatus_pembayaran();
        this.statusPesanan = transaksi.getStatus_pesanan();
        this.ongkir = transaksi.getOngkir();
        this.totalHarga = transaksi.getTotal_harga();
        this.catatan = transaksi.getCatatan();
    }
}
