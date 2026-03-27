package br.com.jhonatha.forum.configs

import org.flywaydb.core.Flyway
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.sql.DataSource

@Configuration
class FlywayConfig(private val datasource: DataSource) {

    @Bean(initMethod = "migrate")
    fun flyway(): Flyway {
        return Flyway.configure()
            .dataSource(datasource)
            .locations("classpath:/db/migration")
            .baselineOnMigrate(true)
            .validateOnMigrate(true)
            .load()
    }
}