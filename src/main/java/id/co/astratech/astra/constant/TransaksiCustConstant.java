package id.co.astratech.astra.constant;

public class TransaksiCustConstant {
    public static final String qGetAllTransaksiByStatus =
            "SELECT * FROM tr_transaksi WHERE status_pesanan = :status";

    public static final String qGetTransaksiByIdAndStatus =
            "SELECT * FROM tr_transaksi WHERE id_user = :idUser AND status_pesanan = :status";

    public static final String qGetTransaksiById =
            "SELECT * FROM tr_transaksi WHERE id_user = :idUser";

    public static final String qGetTransaksiDetail =
            "SELECT td.id_transaksi, td.id_layanan, l.nama_layanan, td.qty  \n" +
                    "FROM tr_transaksi t  \n" +
                    "JOIN tr_transaksi_detail td on t.id_transaksi = td.id_transaksi  \n" +
                    "JOIN ms_layanan l on td.id_layanan = l.id_layanan  \n" +
                    "WHERE td.id_transaksi = :idTransaksi";

    public static final String qInsertTransaksi =
            "";
}
