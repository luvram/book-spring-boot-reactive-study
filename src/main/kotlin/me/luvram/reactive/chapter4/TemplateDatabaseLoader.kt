package me.luvram.reactive.chapter4

import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.data.mongodb.core.MongoOperations
import org.springframework.stereotype.Component

@Component
class TemplateDatabaseLoader {

    @Bean
    fun initialize(mongo: MongoOperations): CommandLineRunner {
        // CommandLineRunner: 애플리케이션이 시작된 후에 자동으로 실행되는 특수한 스프링 부트 컴포넌트.
        val item1 = Item(
            name = "Alf alarm clock",
            description = "",
            price = 19.99,
        )
        val item2 = Item(
            name = "Smurf TV tray",
            description = "",
            price = 24.99,
        )
        return CommandLineRunner {
            mongo.dropCollection("item")
            mongo.dropCollection("cart")
            mongo.save(item1)
            mongo.save(item2)
        }
    }
}
