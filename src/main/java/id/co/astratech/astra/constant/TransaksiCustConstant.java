package id.co.astratech.astra.constant;

public class TransaksiCustConstant {
    public static final String qGetAllTransaksiByStatus =
            "SELECT * FROM tr_transaksi WHERE status_pesanan = :status";

    public static final String qGetTransaksiByIdAndStatus =
            "SELECT * FROM tr_transaksi WHERE id_user = :idUser AND status_pesanan = :status\n" +
                    "order by id_transaksi desc";

    public static final String qGetTransaksiById =
            "SELECT * FROM tr_transaksi WHERE id_user = :idUser";

    public static final String qGetTransaksiDetail =
            "SELECT td.id_transaksi, td.id_layanan, l.nama_layanan, td.qty  \n" +
                    "FROM tr_transaksi t  \n" +
                    "JOIN tr_transaksi_detail td on t.id_transaksi = td.id_transaksi  \n" +
                    "JOIN ms_layanan l on td.id_layanan = l.id_layanan  \n" +
                    "WHERE td.id_transaksi = :idTransaksi";

    public static final String getTotalHarga =
            "SELECT \n" +
                    "    t.id_transaksi, \n" +
                    "    t.id_user, \n" +
                    "    t.id_alamat, \n" +
                    "    t.id_durasi, \n" +
                    "    CAST(t.catatan AS NVARCHAR(MAX)) AS catatan, \n" +
                    "    t.tanggal_pesanan, \n" +
                    "    t.tanggal_pengiriman, \n" +
                    "    t.status_pesanan, \n" +
                    "    t.status_pembayaran, \n" +
                    "    t.ongkir, \n" +
                    "    SUM(l.harga_layanan * td.qty) as total_harga \n" +
                    "FROM \n" +
                    "    tr_transaksi t\n" +
                    "JOIN \n" +
                    "    tr_transaksi_detail td on t.id_transaksi = td.id_transaksi\n" +
                    "JOIN \n" +
                    "    ms_layanan l on td.id_layanan = l.id_layanan\n" +
                    "WHERE \n" +
                    "    td.id_transaksi = :idTransaksi\n" +
                    "GROUP BY \n" +
                    "    t.id_transaksi, \n" +
                    "    t.id_user, \n" +
                    "    t.id_alamat, \n" +
                    "    t.id_durasi, \n" +
                    "    CAST(t.catatan AS NVARCHAR(MAX)), \n" +
                    "    t.tanggal_pesanan, \n" +
                    "    t.tanggal_pengiriman, \n" +
                    "    t.status_pesanan, \n" +
                    "    t.status_pembayaran, \n" +
                    "    t.ongkir;\n";
}
