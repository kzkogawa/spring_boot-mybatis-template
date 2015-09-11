package demo.mapper;

import demo.model.Account;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

public interface AccountMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table account
	 * @mbggenerated  Thu Sep 10 20:28:08 PDT 2015
	 */
	int deleteByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table account
	 * @mbggenerated  Thu Sep 10 20:28:08 PDT 2015
	 */
	int insert(Account record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table account
	 * @mbggenerated  Thu Sep 10 20:28:08 PDT 2015
	 */
	Account selectByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table account
	 * @mbggenerated  Thu Sep 10 20:28:08 PDT 2015
	 */
	List<Account> selectAll();

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table account
	 * @mbggenerated  Thu Sep 10 20:28:08 PDT 2015
	 */
	int updateByPrimaryKey(Account record);

	/**
	 * 
	 * @param record
	 * @param bounds
	 * @return
	 */
	Account[] selectList(Account record, RowBounds bounds);
}