package com.exp.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;
import java.util.List;
import java.util.function.Function;

public class MyBatisUtils {
    private static SqlSessionFactory sqlSessionFactory = null;
    static {
        Reader reader = null;
        try {
            reader = Resources.getResourceAsReader("mybatis-config-pre.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (Exception e) {
            //初始化错误时, 通过抛出异常ExceptionInInitializerError通知调用者
            throw new ExceptionInInitializerError(e);
        }
    }

    /**
     * 实现了自动开关SqlSession
     * 执行sql查询
     * @param func 要执行查询语句的代码块
     * @return List<T> 查询结果
     */
    public static <T> List<T> executeQuery(Function<SqlSession,Object> func) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            List<T> list = (List<T>) func.apply(sqlSession);
            return list;
        } finally {
            sqlSession.close();
        }
    }

    /**
     * 执行INSERT/UPDATE/DELETE写操作SQL
     * @param func 要执行的写操作代码块
     * @return 写操作要返回的结果
     */
    public static Object executeUpdate(Function<SqlSession,Object> func) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            Object obj = func.apply(sqlSession);
            sqlSession.commit();
            return obj;
        } catch (RuntimeException e) {
            sqlSession.rollback();
            throw e;
        } finally {
            sqlSession.close();
        }
    }
}
