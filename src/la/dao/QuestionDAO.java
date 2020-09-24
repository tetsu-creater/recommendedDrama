package la.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import la.bean.DramaInfoBean;
import la.bean.ShowDramaListBean;

public class QuestionDAO {
	private Connection con;

	public QuestionDAO() throws DAOException {
		getConnection();
	}

	public DramaInfoBean addBean(int number) throws DAOException{
		if(con == null)
			getConnection();

		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			//SQL文の作成
			String sql = "SELECT title,category,season,photo,casts,content,services FROM kindOfDrama WHERE code = ?";
			//PreparedStatementオブジェクトの取得
			st = con.prepareStatement(sql);
			//主キーの設定
			st.setInt(1,number);
			//SQLの実行
			rs = st.executeQuery();
			if(rs.next()) {
				String title = rs.getString("title");
				String category = rs.getString("category");
				int season = rs.getInt("season");
				String photo = rs.getString("photo");
				String casts = rs.getString("casts");
				String content = rs.getString("content");
				String services = rs.getString("services");
				DramaInfoBean bean = new DramaInfoBean(title,category,season,photo,casts,content,services);
				return bean;
			}else {
				return null;
			}

		}catch(Exception e) {
			e.printStackTrace();
			throw new DAOException("レコードの取得に失敗しました。");
		}finally {
			try {
				//リソースの開放
				if(st != null) st.close();
				close();
			} catch (Exception e) {
				throw new DAOException("リソースの開放に失敗しました。");
			}
		}
	}

	public   List<ShowDramaListBean> showDrama() throws DAOException {
		if(con == null)
			getConnection();

		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			//SQL文の作成
			String sql = "SELECT code,title,category,season,casts,services FROM kindOfDrama";
			//PreparedStatementオブジェクトの取得
			st = con.prepareStatement(sql);
			//SQLの実行
			rs = st.executeQuery();
			List<ShowDramaListBean> list = new ArrayList<ShowDramaListBean>();

			while(rs.next()) {
				int code = rs.getInt("code");
				String title = rs.getString("title");
				String category = rs.getString("category");
				int season = rs.getInt("season");
				String casts = rs.getString("casts");
				String services = rs.getString("services");
				ShowDramaListBean bean = new ShowDramaListBean(code,title,category,season,casts,services);
				list.add(bean);
			}
			return list;

		}catch(Exception e) {
			e.printStackTrace();
			throw new DAOException("レコードの取得に失敗しました。");
		}finally {
			try {
				//リソースの開放
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
