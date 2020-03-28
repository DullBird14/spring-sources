package org.dullbird.my.mybatis.mapper;

import org.dullbird.my.mybatis.utils.Select;

/**
 * @author cys
 * @date 2020-01-17 23:42
 */

public interface AccountMapper {
	@Select(sql = "select * from account")
	public int selectById(int number);
}
