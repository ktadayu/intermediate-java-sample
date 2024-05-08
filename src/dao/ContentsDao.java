package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import exception.MyException;
import model.Contents;


public class ContentsDao extends BaseDao{

	//BaseDaoを呼び出す
	public ContentsDao() throws MyException {
		super();
	}

	//とりあえず全件取得メソッド
	public List<Contents> findAllContents() throws MyException {

		ArrayList<Contents> contentsList = new ArrayList<>();

		try {
			String sql = "select * from contents";

			// 検索の実行
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while(rs.next()) {
				String name = rs.getString("name");
				String email = rs.getString("email");
				String title = rs.getString("title");
				String text = rs.getString("text");
				String url = rs.getString("url");
				String p_key = rs.getString("p-key");

				Contents contents = new Contents(name,email,title,text,url,p_key);
				contentsList.add(contents);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new MyException("取得に失敗");
		}finally {
			close();
		}

		return contentsList;

	}


	public void Insert(Contents content) throws MyException{

		String name = content.getName();
		String email = content.getEmail();
		String title = content.getTitle();
		String text = content.getText() ;
		String url = content.getUrl();

		try {
			String sql = "insert into contents  (`name`, `email`, `title`, `text`, `url`) value (?, ?, ?, ?, ?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, email);
			ps.setString(3, title);
			ps.setString(4, text);
			ps.setString(5, url);
			ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
			throw new MyException("SQLエラー");
		}
	}

}
