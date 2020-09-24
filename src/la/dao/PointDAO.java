package la.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import la.bean.CodePointBean;

public class PointDAO {
	private Connection con;

	public PointDAO() throws DAOException {
		getConnection();
	}

	public List<CodePointBean> addPoint(String q) throws DAOException{
		if(con == null)
			getConnection();

		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			//SQL文の作成
			String sql = "SELECT * FROM dramaPoints";
			//PreparedStatementオブジェクトの取得
			st = con.prepareStatement(sql);
			//SQLの実行
			rs = st.executeQuery();
			List<CodePointBean> list1 = new ArrayList<CodePointBean>();

			while(rs.next()) {
				int code = rs.getInt("code");
				int point = rs.getInt(q);
				CodePointBean bean = new CodePointBean(code,point);
				list1.add(bean);
			}

			return list1;

		}catch(Exception e) {
			e.printStackTrace();
			throw new DAOException("レコードの取得に失敗しました。");
		} finally {
			try {
				//リソースの開放
				if(rs != null) rs.close();
				if(st != null) st.close();
				close();
			} catch (Exception e) {
				throw new DAOException("リソースの開放に失敗しました。");
			}
		}
	}

	private void getConnection() throws DAOException {
		try {
			//JDBCドライバの登録
			Class.forName("org.postgresql.Driver");
			//URL、ユーザ名、パスワードの設定
			String url = "jdbc:postgresql:sample";
			String user = "student";
			String pass = "himitu";
			//データベースへの接続
			con = DriverManager.getConnection(url,user,pass);
		}catch (Exception e) {
			throw new DAOException("接続に失敗しました。");
		}
	}

	private void close() throws SQLException {
		if(con != null) {
			con.close();
			con = null;
		}
	}
}
