package com.farshad.moviesAppCompose.data.db

import com.farshad.moviesAppCompose.data.db.Dao.FavoriteMovieDao
import com.farshad.moviesAppCompose.data.db.Dao.MovieSearchHistoryDao
import com.farshad.moviesAppCompose.data.db.Entity.FavoriteMovieEntity
import com.farshad.moviesAppCompose.data.db.Entity.SearchHistoryEntity
import com.farshad.moviesAppCompose.data.db.Entity.SearchHistoryEntityWithoutId
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RoomRepository @Inject constructor(
    private val favoriteMovieDao: FavoriteMovieDao,
    private val movieSearchHistoryDao: MovieSearchHistoryDao
) {

    suspend fun insertFavoriteMovie(movie : FavoriteMovieEntity){
        favoriteMovieDao.insert(movie)
    }

    suspend fun deleteFavoriteMovie(movie : FavoriteMovieEntity){
        favoriteMovieDao.delete(movie)
    }

     fun getAllFavoriteMovies() : Flow<List<FavoriteMovieEntity>>{
        return favoriteMovieDao.getAllItemEntities()
    }





    suspend fun insertMovieSearchHistory(movie : SearchHistoryEntity){
        movieSearchHistoryDao.insert(movie)
    }

    suspend fun deleteAllMovieSearchHistory(){
        movieSearchHistoryDao.deleteAll()
    }

    suspend fun deleteMovieSearchById(movieId : Int){
        movieSearchHistoryDao.deleteMovieById(movieId)
    }

     fun getAllMovieSearchHistory() : Flow<List<SearchHistoryEntityWithoutId>>{
        return movieSearchHistoryDao.getAllItemEntities()
    }







}