package br.com.jhonatha.forum.mappers

interface Mapper<T, U> {
    fun map(t: T): U
}
