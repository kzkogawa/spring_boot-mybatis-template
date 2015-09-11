package demo.model;

import org.apache.ibatis.session.RowBounds;

public class RootSearchModel {
	private int offset = RowBounds.NO_ROW_OFFSET;
	private int limit = 25;

	public void setO(int offset) {
		this.offset = offset;
	}
	public void setL(int limit) {
		this.limit = limit;
	}
	public RowBounds getRowBounds() {
		return new RowBounds(offset, limit);
	}
}
