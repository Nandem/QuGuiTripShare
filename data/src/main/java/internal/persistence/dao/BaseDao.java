package internal.persistence.dao;

import java.util.List;
/**
 * dao基类
 * @author Nandem on 2017-05-08.
 */
public interface BaseDao<T>
{
    /**
     * 增加
     * @param t 需要增加的对象
     */
    int add(T t);

    /**
     * 删除
     * @param id 需要删除的对象的id
     */
    void delete(String id);

    /**
     * 清空
     */
    void clear();

    /**
     * 修改
     * @param t 需要修改的对象
     */
    void modify(T t);

    /**
     * 查询某一个对象
     * @param id 该对象的id
     */
    T retrieve(String id);

    /**
     * 查询所有该类型对象
     * @return 一个包含所有该类型对象的List
     */
    List<T> retrieveAll();
}
