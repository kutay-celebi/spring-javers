package tr.com.nekasoft.springjavers;

import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import org.javers.core.Javers;
import org.javers.core.JaversBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class SpringJaversApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringJaversApplication.class, args);
    }

    //@Bean
    //public Javers javers() {
    //    MongoRepository javersMongoRepository =
    //            new MongoRepository(mongo().getDatabase("mydatabase"));
    //
    //    return JaversBuilder.javers()
    //            .registerJaversRepository(javersMongoRepository)
    //            .build();
    //}
    //
    //@Bean("javersMongoClientSettings")
    //public MongoClientSettings clientSettings() {
    //    return MongoClientSettings.builder()
    //            .applyToSslSettings(builder -> builder.enabled(true))
    //            .applyToSocketSettings(
    //                    builder -> builder.connectTimeout(500, TimeUnit.MILLISECONDS))
    //            .build();
    //}
}
