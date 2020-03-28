package org.dullbird.my.mybatis.mapper;

import org.dullbird.my.mybatis.utils.Select;

/**
 * @author cys
 * @date 2020-01-17 23:42
 */

public interface UserMapper {
	@Select(sql = "select * from user")
	public int selectById(int number);
}
