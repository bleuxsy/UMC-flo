package com.example.myapplication

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface SongDao {
    @Insert
    fun insert(song:Song)

    @Update
    fun update(song: Song)
    @Delete
    fun delete(song: Song)
    @Query("SELECT * FROM Songtable")
    fun getSongs() : List<Song>

    @Query("SELECT * FROM Songtable WHERE id = :id")
    fun getSong(id : Int) : Song

    @Query("UPDATE Songtable SET isLIke = :isLike WHERE id = :id")
    fun updateIsLikeById(isLike: Boolean, id:Int)

    @Query("SELECT * FROM Songtable WHERE isLike= :isLike")
    fun getLikedSongs(isLike:Boolean): List<Song>
}