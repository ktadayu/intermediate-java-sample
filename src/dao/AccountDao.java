package dao;

import java.sql.SQLException;

import exception.MyException;
import model.Account;

//ログインメソッドとエラー時メッセージの設定
public class AccountDao extends BaseDao {

	public AccountDao() throws MyException {
		super();
	}


	public Account doLogin(int loginId, String loginPassword)
		throws MyException {
			// スタッフ情報
			Account loginUser = null;
			try {
				String sql = "SELECT * FROM account WHERE id = ? AND pass = ?";
				ps = con.prepareStatement(sql);
				ps.setInt(1, loginId);
				ps.setString(2, loginPassword);
				rs = ps.executeQuery();
				while(rs.next()) {
					String userId = rs.getString("id");
					String userName = rs.getString("name");
					String password = rs.getString("pass");
					loginUser = new Account(userId, userName, password);
				}

				// ログイン結果を確認
				if(loginUser == null) {
					System.out.println("ログインできませんでした");
					throw new MyException("ログインできませんでした");
				}
			} catch (SQLException e) {
				e.printStackTrace();
				throw new MyException("SQL実行中に例外が発生しました");
			}finally {
				close();
			}

			System.out.println("ログイン完了");
		return loginUser;
	}
}