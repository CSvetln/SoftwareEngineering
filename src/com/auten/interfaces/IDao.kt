package com.auten.interfaces

import java.util.Optional



interface IDao<T> {


    operator fun get(id: Long): Optional<T>

    fun getAll(): List<T>

    fun save(t: T)

    fun update(t: T, params: Array<String>)

    fun delete(t: T)
}