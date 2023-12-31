package com.farshad.moviesAppCompose.data.db.Dao

import androidx.room.*
import com.farshad.moviesAppCompose.data.db.Entity.FavoriteMovieEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoriteMovieDao {

    @Query("SELECT * FROM favorite_movie")
    fun getAllItemEntities(): Flow<List<FavoriteMovieEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE  )
    suspend fun insert(itemEntity: FavoriteMovieEntity)

    @Delete
    suspend fun delete(itemEntity: FavoriteMovieEntity)

    @Update
    suspend fun update(itemEntity: FavoriteMovieEntity)

    @Query("DELETE FROM favorite_movie")
    suspend fun deleteAll()

}