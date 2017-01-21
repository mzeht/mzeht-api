package com.wpmac.mzehtapi.config;

import com.alibaba.druid.filter.Filter;
import com.alibaba.druid.filter.stat.StatFilter;
import com.alibaba.druid.pool.DruidDataSource;
import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;



@Configuration
@MapperScan(basePackages = "com.wpmac.mzeht.mapper.days", sqlSessionFactoryRef = "baseSqlSessionFactory")
public class DaysDBConfig {

    private final Logger log = Logger.getLogger(DaysDBConfig.class);

    @Autowired
    private Environment env;

    @Bean(name = "baseDataSource")
    @Primary
    public DataSource baseDataSource() throws Exception {

        log.info("...................BaseDBConfig init start....................");

        StatFilter statFilter = new StatFilter();
        statFilter.setLogSlowSql((null == env.getProperty("druidpool.log-slow-sql")) ? true
                : Boolean.valueOf(env.getProperty("druidpool.log-slow-sql")));
        statFilter.setSlowSqlMillis((null == env.getProperty("druidpool.slow-sql-millis[0]")) ? 3000
                : Long.valueOf(env.getProperty("druidpool.slow-sql-millis[0]")));
        statFilter.setMergeSql((null == env.getProperty("druidpool.merge-sql")) ? true
                : Boolean.valueOf(env.getProperty("druidpool.merge-sql")));
        List<Filter> filters = new ArrayList<Filter>();
        filters.add(statFilter);
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName(env.getProperty("druidpool.driver-class-name"));
        druidDataSource.setName(env.getProperty("druidpool.name[0]"));
        druidDataSource.setUrl(env.getProperty("druidpool.url[0]"));
        druidDataSource.setUsername(env.getProperty("druidpool.username[0]"));
        druidDataSource.setPassword(env.getProperty("druidpool.password[0]"));
        druidDataSource.setFilters(env.getProperty("druidpool.filters"));
        druidDataSource.setProxyFilters(filters);
        druidDataSource.setUseGlobalDataSourceStat(
                Boolean.valueOf(env.getProperty("druidpool.global-datasource-stat")));
        druidDataSource.setMaxActive(Integer.valueOf(env.getProperty("druidpool.max-active[0]")));
        druidDataSource.setInitialSize(Integer.valueOf(env.getProperty("druidpool.initial-size[0]")));
        druidDataSource.setMaxWait(Long.valueOf(env.getProperty("druidpool.max-wait[0]")));
        druidDataSource.setMinIdle(Integer.valueOf(env.getProperty("druidpool.min-idle[0]")));
        druidDataSource.setTimeBetweenEvictionRunsMillis(
                Long.valueOf(env.getProperty("druidpool.time-between-eviction-runs-millis[0]")));
        druidDataSource.setMinEvictableIdleTimeMillis(
                Long.valueOf(env.getProperty("druidpool.min-evictable-idle-time-millis[0]")));
        druidDataSource.setValidationQuery(env.getProperty("druidpool.validation-query"));
        druidDataSource.setTestWhileIdle(Boolean.valueOf(env.getProperty("druidpool.test-while-idle")));
        druidDataSource.setTestOnBorrow(Boolean.valueOf(env.getProperty("druidpool.test-on-borrow")));
        druidDataSource.setTestOnReturn(Boolean.valueOf(env.getProperty("druidpool.test-on-return")));
        druidDataSource.setPoolPreparedStatements(
                Boolean.valueOf(env.getProperty("druidpool.pool-prepared-statements")));
        druidDataSource.setMaxOpenPreparedStatements(
                Integer.valueOf(env.getProperty("druidpool.max-open-prepared-statements[0]")));
        druidDataSource.setConnectionProperties(env.getProperty("druidpool.connection-properties[0]"));

        log.info("...................BaseDBConfig init end....................");

        return druidDataSource;
    }

    @Bean(name = "baseTransactionManager")
    @Primary
    public DataSourceTransactionManager baseTransactionManager() throws Exception {
        return new DataSourceTransactionManager(baseDataSource());
    }

    @Bean(name = "baseSqlSessionFactory")
    @Primary
    public SqlSessionFactoryBean baseSqlSessionFactory(@Qualifier("baseDataSource") DataSource rdsDataSource)
            throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(rdsDataSource);
        return sessionFactory;
    }
}
