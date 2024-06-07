package id.co.astratech.astra.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DtoResponse {

    private int status;

    private Object data;

    private String message;

    public DtoResponse(int status, Object data){
        this.status = status;
        this.data = data;
    }

}
