package com.atguigu.gulimall.search.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GulimallElasticSearchConfig {

    @Bean
    public RestHighLevelClient esRestClient(@Value("${spring.elasticsearch.jest.uris}")String esUrl){

        //TODO 修改为线上的地址
        RestClientBuilder builder = null;
        //final String hostname, final int port, final String scheme

//        builder = RestClient.builder(new HttpHost("192.168.56.10", 9200, "http"));
        builder = RestClient.builder(HttpHost.create(esUrl));
        RestHighLevelClient client = new RestHighLevelClient(builder);
//        RestHighLevelClient client = new RestHighLevelClient(
//                RestClient.builder(
//                        new HttpHost("192.168.56.10", 9200, "http")));

        return client;
    }
}
