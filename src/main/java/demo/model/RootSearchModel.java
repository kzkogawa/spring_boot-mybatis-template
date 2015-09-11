package demo.model;

import org.apache.ibatis.session.RowBounds;

public class RootSearchModel {
	private int limit = 25;
	private int pageNum = 1;

	public RowBounds getRowBounds() {
		return new RowBounds((pageNum - 1) * limit, limit);
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public void setP(int pageNum) {
		this.pageNum = pageNum;
	}
}
