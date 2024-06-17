package org.example.qff.common.result;

import java.util.List;

/**
 * @author liufan
 * @version 1.0
 * @date 2024/3/6 8:03
 **/
public class QffPageable<T> {
    private Integer pageNo = 1; // 当前页码
    private Integer pageSize = 10; // 每页显示的数量
    private Integer total ; // 总数量
    private Integer totalPages ; // 总页数
    private List<T> result ; // 返回的结果列表


    /**
     * 获取返回结果
     * @param result
     */
    public void setRecords(List<T> result) {
        this.result = result;
        if (result != null && result.size() > 0) {
            setTotal(result.size());
        }
    }

    /**
     * 设置总条数
     * @param total
     */
    public void setTotal(Integer total) {
        this.total = total;
        if (this.pageSize > 0) {
            this.totalPages = (total / this.pageSize) + (total % this.pageSize == 0 ? 0 : 1);
        } else {
            this.totalPages = 0;
        }
    }

    /**
     * 设置分页大小
     * @param pageSize
     */
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * 设置页码
     * @param pageNo
     */
    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }


}