package com.example.myapplication

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

@Database(entities = [Song::class, Album::class], version = 2, exportSchema = false)
abstract class SongDatabase : RoomDatabase() {
    abstract fun songDao(): SongDao
    abstract fun albumDao(): AlbumDao

    companion object {
        @Volatile
        private var instance: SongDatabase? = null

        fun getInstance(context: Context): SongDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                SongDatabase::class.java,
                "song-database"
            )
                .addMigrations(MIGRATION_1_2)
                .fallbackToDestructiveMigration() // 파괴적 마이그레이션을 사용할 경우 이 줄을 추가
                .build()

        private val MIGRATION_1_2 = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                // 예: 새로운 열 추가
                // database.execSQL("ALTER TABLE SongTable ADD COLUMN newColumn TEXT")
            }
        }
    }
}
