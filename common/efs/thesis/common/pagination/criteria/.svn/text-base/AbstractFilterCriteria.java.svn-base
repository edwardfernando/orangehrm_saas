/**
 * 
 */
package efs.thesis.common.pagination.criteria;


/**
 * @author Edward Fernando
 * @project Thesis Project, 2013
 */
public abstract class AbstractFilterCriteria implements FilterCriteria {
	protected int max = 10;
	protected int page = 1;
	protected int nextPage;
	protected int prevPage;
	protected int totalPage;
	protected String url;
	protected String target;
	protected String order = "id";
	
	public int start(){
		return (this.page - 1) * this.max;
	}
	
	public int getMax() {
		return max;
	}
	public void setMax(int max) {
		this.max = max;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getNextPage() {
		return nextPage;
	}
	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}
	public int getPrevPage() {
		return prevPage;
	}
	public void setPrevPage(int prevPage) {
		this.prevPage = prevPage;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
}
