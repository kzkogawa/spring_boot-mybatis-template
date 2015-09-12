package demo.model;

import java.util.Map;

import org.apache.ibatis.session.RowBounds;

public class SearchModel {

	private int limit = 25;
	private int pageNumber = 1;
	private Map<String, Object> query;

	public SearchModel(Map<String, Object> query, int pageNumber) {
		this(query, pageNumber, 25);
	}

	public SearchModel(Map<String, Object> query, int pageNumber, int limit) {
		this.pageNumber = pageNumber < 1 ? 1 : pageNumber;
		this.query = query;
		this.limit = limit;
	}

	public RowBounds getRowBounds() {
		return new RowBounds((pageNumber - 1) * limit, limit);
	}

	public Map<String, Object> getQuery() {
		return query;
	}
}
