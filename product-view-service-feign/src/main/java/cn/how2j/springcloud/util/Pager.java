package cn.how2j.springcloud.util;

import java.util.List;


public class Pager {
	/**
	 * 分页的大小
	 */
	private  int size;
	/**
	 * 分页的起始页
	 */
	private int offset = 0;
	/**
	 * 总记录数
	 */
	private long total;
	/**
	 * 分页的数据
	 */

	private static final int defaultCount = 5;

	public Pager (){
		size = defaultCount;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getOffset() {
		return offset;
	}
	public void setOffset(int offset) {
		this.offset = offset;
	}
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}

}
