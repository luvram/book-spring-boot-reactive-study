package me.luvram.reactive.chapter2

import org.springframework.data.repository.reactive.ReactiveCrudRepository

interface CartRepository: ReactiveCrudRepository<Cart, String> {
}
