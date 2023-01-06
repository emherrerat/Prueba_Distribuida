package com.distribuida.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.ConfigProvider;
import org.jdbi.v3.core.Jdbi;

@ApplicationScoped
public class DbConfig {
    public Jdbi conf(){
        Config config = ConfigProvider.getConfig();
        String user=config.getValue("db.user",String.class);
        String passwd=config.getValue("db.password",String.class);
        String url =config.getValue("db.url",String.class);
        String driver=config.getValue("db.driver",String.class);
        //Pool de conexiones
        HikariConfig hk=new HikariConfig();
        hk.setMaximumPoolSize(5);
        hk.setJdbcUrl(url);
        hk.setUsername(user);
        hk.setPassword(passwd);
        hk.setDriverClassName(driver);
        return Jdbi.create(new HikariDataSource(hk));
    }
}
