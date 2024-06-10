package id.co.astratech.astra.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DetailTransaksiVo {
    private Integer idTransaksi;

    private Integer idLayanan;

    private Integer qty;
}
