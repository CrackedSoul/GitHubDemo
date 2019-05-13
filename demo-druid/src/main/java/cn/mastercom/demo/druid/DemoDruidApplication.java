package cn.mastercom.demo.druid;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.stat.DruidDataSourceStatManager;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.SQLException;

@SpringBootApplication
public class DemoDruidApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(DemoDruidApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

    }
    public static Connection getConnection(String dsName) throws SQLException {
        DruidDataSource ds = null;
        if (dsName != null) {
            for (DruidDataSource dataSource : DruidDataSourceStatManager.getDruidDataSourceInstances()) {
                if (dataSource.getName().equals(dsName)) {
                    ds = dataSource;
                    break;
                }
            }
        }
        return ds.getConnection();
    }
}
