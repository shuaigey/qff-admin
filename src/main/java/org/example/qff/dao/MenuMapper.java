package org.example.qff.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.example.qff.entity.Menu;

import java.util.List;

/**
 * @author liufan
 * @version 1.0
 * @date 2024/3/17 8:39
 **/
public interface MenuMapper extends BaseMapper<Menu> {
    List<Menu> selectByMenuIds(@Param("menuIds") List<String> menuIds);
}
