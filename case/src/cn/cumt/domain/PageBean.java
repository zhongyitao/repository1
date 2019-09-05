package cn.cumt.domain;

import java.util.List;

public class PageBean<T> {

    int totalCount;//总条数
    int totalPage;//总页数
    int rows = 5;//每页条数
    int currentPage = 1;//当前页
    List<T> userList;//当前页数据

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public List<T> getUserList() {
        return userList;
    }

    public void setUserList(List<T> userList) {
        this.userList = userList;
    }

    @Override
    public String toString() {
        return "PageBean{" +
                "totalCount=" + totalCount +
                ", totalPage=" + totalPage +
                ", rows=" + rows +
                ", currentPage=" + currentPage +
                ", userList=" + userList +
                '}';
    }
}
