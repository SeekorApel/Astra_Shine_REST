package id.co.astratech.astra.constant;

public class TransaksiCustConstant {
    public static final String qGetTransaksiPickup =
            "SELECT * FROM tr_transaksi WHERE id_user = :idUser AND status_pesanan = 'pick up'";

    public static final String qGetTransaksiProses =
            "SELECT * FROM tr_transaksi WHERE id_user = :idUser AND status_pesanan = 'proses'";

    public static final String qGetTransaksiSelesai =
            "SELECT * FROM tr_transaksi " +
                    "WHERE id_user = :idUser AND status_pesanan = 'selesai' OR status_pesanan = 'batal'";

    public static final String qGetTransaksiDetail =
            "SELECT td.id_transaksi, td.id_layanan, td.qty " +
                    "FROM tr_transaksi t " +
                    "JOIN tr_transaksi_detail td on t.id_transaksi = td.id_transaksi " +
                    "JOIN ms_layanan l on td.id_layanan = l.id_layanan " +
                    "WHERE td.id_transaksi = :idTransaksi";

    public static final String qInsertTransaksi =
            "";
}
