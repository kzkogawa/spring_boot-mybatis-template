package demo.mapper;

import demo.model.AccountRole;
import java.util.List;

public interface AccountRoleMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table account_role
	 * @mbggenerated  Sat Sep 12 14:50:29 PDT 2015
	 */
	int deleteByPrimaryKey(String userName);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table account_role
	 * @mbggenerated  Sat Sep 12 14:50:29 PDT 2015
	 */
	int insert(AccountRole record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table account_role
	 * @mbggenerated  Sat Sep 12 14:50:29 PDT 2015
	 */
	AccountRole selectByPrimaryKey(String userName);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table account_role
	 * @mbggenerated  Sat Sep 12 14:50:29 PDT 2015
	 */
	List<AccountRole> selectAll();

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table account_role
	 * @mbggenerated  Sat Sep 12 14:50:29 PDT 2015
	 */
	int updateByPrimaryKey(AccountRole record);
}