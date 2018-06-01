package com.marklogzhu.platform.service;

import com.marklogzhu.platform.common.JsonData;
import com.marklogzhu.platform.dto.UserDTO;

public interface UserService {

    /**
     * 用户登陆
     * @param userParam
     * @return
     */
    JsonData<UserDTO> login(UserDTO userParam);

}
