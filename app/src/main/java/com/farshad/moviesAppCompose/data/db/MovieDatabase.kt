package com.farshad.moviesAppCompose.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.farshad.moviesAppCompose.data.db.Dao.FavoriteMovieDao
import com.farshad.moviesAppCompose.data.db.Dao.MovieSearchHistoryDao
import com.farshad.moviesAppCompose.data.db.Entity.FavoriteMovieEntity
import com.farshad.moviesAppCompose.data.db.Entity.SearchHistoryEntity

@Database(entities = [FavoriteMovieEntity::class , SearchHistoryEntity::class] , version = 1, exportSchema = false)
abstract class MovieDatabase : RoomDatabase(){
    abstract fun favoriteMovieDao() : FavoriteMovieDao
    abstract fun movieSearchHistoryDao() : MovieSearchHistoryDao
}





