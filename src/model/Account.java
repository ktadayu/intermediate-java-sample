package model;

public class Account {
	private String accountId;
	private String accountName;
	private String loginPassword;

	//id,name,pass全部貰う
	public Account(String staffId, String staffName, String loginPassword) {
		this.accountId = staffId;
		this.accountName = staffName;
		this.loginPassword = loginPassword;
		}

	public String getAccountId() {
			return accountId;
		}

	public void setAccountId(String staffId) {
			this.accountId = staffId;
		}

	public String getAccountName() {
			return accountName;
		}


	public void setAccountName(String staffName) {
			this.accountName = staffName;
		}


	public String getLoginPassword() {
			return loginPassword;
		}

	public void setLoginPassword(String loginPassword) {
			this.loginPassword = loginPassword;
		}
	}


