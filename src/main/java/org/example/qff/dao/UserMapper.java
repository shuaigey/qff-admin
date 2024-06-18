package org.example.qff.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.example.qff.entity.User;
import org.springframework.stereotype.Repository;

/**
 * @author liufan
 * @version 1.0
 * @date 2024/3/5
 **/

@Repository
public interface UserMapper  extends BaseMapper<User>{

    User selectByPhone(@Param("phone") String phone);

    String selectByUserId(@Param("userId")String userId);
}
