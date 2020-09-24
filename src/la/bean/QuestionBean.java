package la.bean;

import java.util.HashMap;
import java.util.Map;

import la.dao.DAOException;
import la.dao.QuestionDAO;

public class QuestionBean {
	private Map<Integer,DramaInfoBean> points = new HashMap<Integer,DramaInfoBean>();

	public QuestionBean() {

	}

	public Map<Integer, DramaInfoBean> getPoints() {
		return points;
	}

	public void add(int rank,int code) throws DAOException{
		QuestionDAO questionDao = new QuestionDAO();

		DramaInfoBean bean = questionDao.addBean(code);
		bean.setRank(rank);
		bean.setCode(code);

		//Mapに、順位(キー)とDramaInfoBeanのインスタンス(値)を入れる
		points.put(Integer.valueOf(bean.getRank()),bean);

	}
}
