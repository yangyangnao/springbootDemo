package com.chenbing.base.param;

/**
 * 按条件查询抽象父类（可以结合分页PageBean使用）
 * 
 * SysUserCriteria Demo: <br>
 *
 * <pre><code>
 * public class SysUserCriteria extends EasyCriteria implements java.io.Serializable {
 * 	// 1. Criteria field
 * 	private String name;
 * 	private String realName;
 * 	private Integer status; // 0 is ON; 1 is OFF; 2 is REMOVED
 * 
 * 	// 2. Constructor
 * 	public SysUserCriteria() {
 * 	}
 * 
 * 	public SysUserCriteria(String name, String realName, Integer status) {
 * 		super();
 * 		this.name = name;
 * 		this.realName = realName;
 * 		this.status = status;
 * 	}
 * 
 * 	// 3. Condition genertator abstract method implements
 * 	public String getCondition() {
 * 		values.clear(); // **Must clear old values**
 * 		StringBuffer condition = new StringBuffer();
 * 		if (StringUtils.isNotNullAndEmpty(this.getName())) {
 * 			condition.append(" and name like #{name}");
 * 			values.put("name", "%" + this.getName() + "%");
 * 		}
 * 		if (StringUtils.isNotNullAndEmpty(this.getRealName())) {
 * 			condition.append(" and realName like #{realName}");
 * 			values.put("realName", "%" + this.getRealName() + "%");
 * 		}
 * 		if (StringUtils.isNotNullAndEmpty(this.getStatus())) {
 * 			condition.append(" and status=#{status}");
 * 			values.put("status" ,this.getStatus());
 * 		}
 * 		return condition.toString();
 * 	}
 * 
 * 	// 4. Setters&amp;Getters...
 * 
 * }
 * </code></pre>
 * 
 * @author Ray
 * @author inthinkcolor@gmail.com
 * @author easyproject.cn
 * @since 1.0.0
 * @see https://github.com/ushelp/EasyMyBatisPagination
 * 
 */
public class Param {

	/**
	 * 页码
	 */
	private int page;
	private int rows = 30;
	private String sort;
	private String order;

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}
}
