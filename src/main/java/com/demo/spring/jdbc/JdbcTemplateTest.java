package com.demo.spring.jdbc;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import java.io.File;

public class JdbcTemplateTest {

    //数据源
    DriverManagerDataSource dataSource = null;

    //JDBC模板
    JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

    //底层API编程式事务
    TransactionDefinition transactionDefinition = new DefaultTransactionDefinition();
    DataSourceTransactionManager transactionManager = new DataSourceTransactionManager(dataSource);
    TransactionStatus transactionStatus = transactionManager.getTransaction(transactionDefinition);

    //模板编程式事务
    TransactionTemplate transactionTemplate = new TransactionTemplate(transactionManager);

    public void test(){
        dataSource.setDriverClassName("");

        transactionManager.commit(transactionStatus);
        transactionManager.rollback(transactionStatus);

        transactionTemplate.execute(new TransactionCallback<Object>() {
            @Override
            public Object doInTransaction(TransactionStatus status) {
                status.setRollbackOnly();
                return null;
            }
        });

        BeanFactory bf = new XmlBeanFactory(new FileSystemResource(""));
    }
}
