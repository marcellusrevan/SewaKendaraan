package com.test.penyewaankendaraan.room

import androidx.room.*

@Dao
interface UserDao {
    @Insert
    suspend fun addUser(user: User)

    @Update
    suspend fun updateUser(user: User)

    @Delete
    suspend fun deleteUser(user: User)

    @Query("SELECT * FROM user")
    suspend fun getNotes(): List<User>

    @Query("SELECT * FROM user WHERE id =:note_id")
    suspend fun getNote(note_id: Int): List<User>

    @Query("SELECT * FROM user WHERE username =:username AND password=:password")
    suspend fun getLogin(username: String,password: String): User?
}