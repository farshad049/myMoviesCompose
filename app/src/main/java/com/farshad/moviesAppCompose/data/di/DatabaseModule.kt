package com.farshad.moviesAppCompose.data.di

import android.content.Context
import androidx.room.Room
import com.farshad.moviesAppCompose.data.db.Dao.FavoriteMovieDao
import com.farshad.moviesAppCompose.data.db.Dao.MovieSearchHistoryDao
import com.farshad.moviesAppCompose.data.db.MovieDatabase
import com.farshad.moviesAppCompose.util.Constants.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)

object DatabaseModule {

    @Singleton
    @Provides
    fun providesDatabase(
        @ApplicationContext context : Context): MovieDatabase {
      return Room.databaseBuilder(
          context ,
          MovieDatabase::class.java ,
          DATABASE_NAME
      ).build()
    }


    @Singleton
    @Provides
    fun providesFavoriteMovieDao (database: MovieDatabase) : FavoriteMovieDao {
        return database.favoriteMovieDao()
    }

    @Singleton
    @Provides
    fun providesMovieSearchHistoryDao (database: MovieDatabase) : MovieSearchHistoryDao {
        return database.movieSearchHistoryDao()
    }

}