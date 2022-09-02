//package com.example.demo.data.mongo.config;
//
//import com.mongodb.MongoClientSettings;
//import com.mongodb.MongoCredential;
//import com.mongodb.ServerAddress;
//import com.mongodb.connection.ClusterConnectionMode;
//import com.mongodb.connection.ClusterType;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.boot.context.properties.EnableConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.data.mongodb.core.MongoClientSettingsFactoryBean;
//
//import java.util.ArrayList;
//import java.util.List;
//
////@Slf4j
////@EnableConfigurationProperties(MongoDBProperties.class)
////@Configuration
//public class MongoConfig {
//
//    private final MongoDBProperties mongoSettingsProperties;
//
//    public MongoConfig(MongoDBProperties mongoSettingsProperties) {
//        this.mongoSettingsProperties = mongoSettingsProperties;
//    }
//
//    @Bean
//    public MongoClientSettingsFactoryBean settingsFactoryBean() {
//        MongoClientSettingsFactoryBean settingsFactoryBean = new MongoClientSettingsFactoryBean();
//
//        // MongoDB地址列表
//        List<ServerAddress> serverAddresses = new ArrayList<>();
//        for (String host : mongoSettingsProperties.getHosts()) {
//            int index = mongoSettingsProperties.getHosts().indexOf(host);
//            Integer port = mongoSettingsProperties.getPorts().get(index);
//
//            ServerAddress serverAddress = new ServerAddress(host, port);
//            serverAddresses.add(serverAddress);
//        }
//        log.info("MongoDB Server Addresses:[{}]", serverAddresses.toString());
//        settingsFactoryBean.setClusterHosts(serverAddresses.toArray(new ServerAddress[serverAddresses.size()]));
//        settingsFactoryBean.setClusterConnectionMode(ClusterConnectionMode.SINGLE);
//        settingsFactoryBean.setCusterRequiredClusterType(ClusterType.LOAD_BALANCED);
//        return settingsFactoryBean;
//    }
//
//    @Primary
//    @Bean
//    public MongoClientSettings mongoClientSettings(MongoClientSettingsFactoryBean settingsFactoryBean) throws Exception {
//        MongoClientSettings.Builder builder = MongoClientSettings.builder(settingsFactoryBean.getObject());
//
//        // 连接认证
//        if (mongoSettingsProperties.getUsername() != null) {
//            MongoCredential credential = MongoCredential.createScramSha1Credential(
//                    mongoSettingsProperties.getUsername(),
//                    mongoSettingsProperties.getAuthenticationDatabase() != null ? mongoSettingsProperties.getAuthenticationDatabase() : mongoSettingsProperties.getDatabase(),
//                    mongoSettingsProperties.getPassword().toCharArray());
//            log.info("mongoDB credential:[{}]", credential.toString());
//            builder.credential(credential);
//        }
//        return builder.build();
//    }
//
//
////    @Bean
////    MongoDbFactory mongoDbFactory() {
////        //客户端配置（连接数、副本集群验证）
////        MongoClientOptions.Builder builder = new MongoClientOptions.Builder();
////        builder.connectionsPerHost(mongoSettingsProperties.getMaxConnections());
////        builder.minConnectionsPerHost(mongoSettingsProperties.getMinConnections());
////        builder.threadsAllowedToBlockForConnectionMultiplier(mongoSettingsProperties.getMaxQueue());
////        builder.readPreference(ReadPreference.secondaryPreferred());
////
////        if (mongoSettingsProperties.getReplicaSet() != null) {
////            builder.requiredReplicaSetName(mongoSettingsProperties.getReplicaSet());
////        }
////        MongoClientOptions mongoClientOptions = builder.build();
////
////        // MongoDB地址列表
////        List<ServerAddress> serverAddresses = new ArrayList<>();
////        for (String host : mongoSettingsProperties.getHosts()) {
////            int index = mongoSettingsProperties.getHosts().indexOf(host);
////            Integer port = mongoSettingsProperties.getPorts().get(index);
////
////            ServerAddress serverAddress = new ServerAddress(host, port);
////            serverAddresses.add(serverAddress);
////        }
////        log.info("MongoDB Server Addresses:[{}]", serverAddresses.toString());
////
////        // 连接认证
////        List<MongoCredential> mongoCredentialList = new ArrayList<>();
////        if (mongoSettingsProperties.getUsername() != null) {
////            mongoCredentialList.add(MongoCredential.createScramSha1Credential(
////                    mongoSettingsProperties.getUsername(),
////                    mongoSettingsProperties.getAuthenticationDatabase() != null ? mongoSettingsProperties.getAuthenticationDatabase() : mongoSettingsProperties.getDatabase(),
////                    mongoSettingsProperties.getPassword().toCharArray()));
////        }
////
////        log.info("mongoDB CredentialList:[{}]", mongoCredentialList.toString());
////
////        //创建客户端和Factory
////        MongoClient mongoClient = new MongoClient(serverAddresses, mongoCredentialList, mongoClientOptions);
////
////        return new SimpleMongoDbFactory(mongoClient, mongoSettingsProperties.getDatabase());
////    }
//
////    @Bean(name = "mongoTemplate")
////    @Autowired
////    public MongoTemplate getMongoTemplate(MongoDbFactory mongoDbFactory) {
////        return new MongoTemplate(mongoDbFactory);
////
////    }
//
//}
//
