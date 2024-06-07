package id.co.astratech.astra.service;

import id.co.astratech.astra.model.User;
import id.co.astratech.astra.repository.UserRepository;
import id.co.astratech.astra.response.DtoResponse;
import id.co.astratech.astra.vo.LoginVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public DtoResponse getUserByEmailAndPassword(String email, String password){
        User user = userRepository.findUserByEmailAndPassword(email, password);
        if(user != null){
            LoginVo loginVo = new LoginVo(user);
            return new DtoResponse(200, loginVo);
        }else {
            return new DtoResponse(404, null, "Data User tidak di temukan");
        }
    }

}
