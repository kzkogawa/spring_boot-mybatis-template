package demo.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;

import demo.model.Account;

public interface AccountMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table account
	 * @mbggenerated  Sat Sep 12 14:50:29 PDT 2015
	 */
	int deleteByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table account
	 * @mbggenerated  Sat Sep 12 14:50:29 PDT 2015
	 */
	int insert(Account record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table account
	 * @mbggenerated  Sat Sep 12 14:50:29 PDT 2015
	 */
	Account selectByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table account
	 * @mbggenerated  Sat Sep 12 14:50:29 PDT 2015
	 */
	List<Account> selectAll();

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table account
	 * @mbggenerated  Sat Sep 12 14:50:29 PDT 2015
	 */
	int updateByPrimaryKey(Account record);

	Account[] selectList(Map<String, Object> map, RowBounds rowBounds);

}