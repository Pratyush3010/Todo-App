package com.example.todoapp

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.Query


@Dao
interface TodoDao{

    @Insert
    suspend fun insertTask(todoModel: TodoModel):Long

    @Query("Select * from TodoModel where isFinished != -1")
    fun getTask():LiveData<List<TodoModel>>

    @Query("update TodoModel Set isFinished = 1 where id =:uid")
    fun finishTask(uid:Long)

    @Query("Delete from todomodel where id =:uid")
    fun deleteTask(uid:Long)

}