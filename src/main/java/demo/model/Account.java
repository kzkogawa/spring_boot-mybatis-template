package demo.model;

public class Account extends RootModel {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column account.id
	 * @mbggenerated  Thu Sep 10 20:28:08 PDT 2015
	 */
	private Integer id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column account.user_name
	 * @mbggenerated  Thu Sep 10 20:28:08 PDT 2015
	 */
	private String userName;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column account.password
	 * @mbggenerated  Thu Sep 10 20:28:08 PDT 2015
	 */
	private String password;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column account.id
	 * @return  the value of account.id
	 * @mbggenerated  Thu Sep 10 20:28:08 PDT 2015
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column account.id
	 * @param id  the value for account.id
	 * @mbggenerated  Thu Sep 10 20:28:08 PDT 2015
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column account.user_name
	 * @return  the value of account.user_name
	 * @mbggenerated  Thu Sep 10 20:28:08 PDT 2015
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column account.user_name
	 * @param userName  the value for account.user_name
	 * @mbggenerated  Thu Sep 10 20:28:08 PDT 2015
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column account.password
	 * @return  the value of account.password
	 * @mbggenerated  Thu Sep 10 20:28:08 PDT 2015
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column account.password
	 * @param password  the value for account.password
	 * @mbggenerated  Thu Sep 10 20:28:08 PDT 2015
	 */
	public void setPassword(String password) {
		this.password = password;
	}
}