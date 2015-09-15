package demo.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.util.StringUtils;

public abstract class SearchModelBase {

	/**
	 * limit
	 */
	private int limit = 25;
	/**
	 * page
	 */
	private int page = 1;
	/**
	 * sort
	 * <p>
	 * store index for sort column
	 * </p>
	 */
	private int[] sort;
	/**
	 * desc
	 * <p>
	 * desc flag for the index of sort column
	 * </p>
	 */
	private int[] dsc;

	public RowBounds getRowBounds() {
		return new RowBounds((page - 1) * limit, limit);
	}

	public String getOrderBy() {
		List<String> orderBys = new ArrayList<String>();
		if (sort != null) {
			for (int i = 0, n = sort.length; i < n; i++) {
				String column = getSortColumn(sort[i]);
				if (!StringUtils.isEmpty(column)) {
					if (dsc != null) {
						for (int desc : dsc) {
							if (desc == sort[i]) {
								column += " DESC";
								break;
							}
						}
					}
					orderBys.add(column);
				}
			}
		}

		return orderBys.isEmpty() ? null : "ORDER BY " + String.join(",", orderBys);
	}

	/**
	 * Obtain column name for sorting
	 * <p>
	 * according to sort index, child class needs to decide what column name
	 * will be return.
	 * </p>
	 * 
	 * @param i
	 * @return
	 */
	public abstract String getSortColumn(int i);

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int[] getSort() {
		return sort;
	}

	public void setSort(int[] sort) {
		this.sort = sort;
	}

	public int[] getDsc() {
		return dsc;
	}

	public void setDsc(int[] dsc) {
		this.dsc = dsc;
	}
}
