package demo.model;

public class AccountRole extends ModelBase {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column account_role.user_name
	 * @mbggenerated  Mon Sep 14 18:28:23 PDT 2015
	 */
	private String userName;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column account_role.role
	 * @mbggenerated  Mon Sep 14 18:28:23 PDT 2015
	 */
	private String role;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column account_role.user_name
	 * @return  the value of account_role.user_name
	 * @mbggenerated  Mon Sep 14 18:28:23 PDT 2015
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column account_role.user_name
	 * @param userName  the value for account_role.user_name
	 * @mbggenerated  Mon Sep 14 18:28:23 PDT 2015
	 */
	public void setUserName(String userName) {
		this.userName = userName == null ? null : userName.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column account_role.role
	 * @return  the value of account_role.role
	 * @mbggenerated  Mon Sep 14 18:28:23 PDT 2015
	 */
	public String getRole() {
		return role;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column account_role.role
	 * @param role  the value for account_role.role
	 * @mbggenerated  Mon Sep 14 18:28:23 PDT 2015
	 */
	public void setRole(String role) {
		this.role = role == null ? null : role.trim();
	}
}