package com.example.springcloudvaultdemo;

import com.example.springcloudvaultdemo.config.ClientCredentials;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;


@SpringBootApplication
@RequiredArgsConstructor
@EnableConfigurationProperties(ClientCredentials.class)
public class SpringCloudVaultDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudVaultDemoApplication.class, args);
    }

}
