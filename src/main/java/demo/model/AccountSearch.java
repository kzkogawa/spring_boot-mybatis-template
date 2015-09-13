package demo.model;

public class AccountSearch extends RootSearchModel {
	private String[] orderByColm = { "id", "user_name" };
	private Account account;

	public AccountSearch() {
		super.setSort(new int[] { 0 });
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@Override
	public String getSortColumn(int i) {
		return 0 <= i && i < orderByColm.length ? orderByColm[i] : null;
	}
}
