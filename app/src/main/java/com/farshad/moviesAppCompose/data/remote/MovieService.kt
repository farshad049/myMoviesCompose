package com.farshad.moviesAppCompose.data.remote

import com.farshad.moviesAppCompose.data.model.network.GenresModel
import com.farshad.moviesAppCompose.data.model.network.NetworkMovieModel
import com.farshad.moviesAppCompose.data.model.network.PagingModel
import com.farshad.moviesAppCompose.data.model.network.RegisterPostBody
import com.farshad.moviesAppCompose.data.model.network.UserAuthModel
import com.farshad.moviesAppCompose.data.model.network.UserRegisteredModel
import com.farshad.moviesAppCompose.data.model.network.*
import com.farshad.moviesAppCompose.ui.submitMovie.model.UploadMovieModel
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.*


interface MovieService {
    @GET("api/v1/movies?")
    suspend fun getMoviesPaging(@Query("page") pageIndex:Int): Response<PagingModel>

    @GET("api/v1/movies?page=1")
    suspend fun getMovieByPage(): Response<PagingModel>

    @GET("api/v1/movies/{movie-id}")
    suspend fun getSingleMovie(@Path("movie-id") movieId:Int):Response<NetworkMovieModel>

    @GET("api/v1/genres")
    suspend fun getAllGenres():Response<List<GenresModel>>

    @GET("api/v1/genres/{genre-id}/movies?page")
    suspend fun getFirsPageMovieByGenre(@Path("genre-id") genreId:Int): Response<PagingModel>

    @GET("api/v1/genres/{genre-id}/movies?page")
    suspend fun getMovieByGenrePaging(@Path("genre-id") genreId:Int, @Query("page") pageIndex:Int): Response<PagingModel>

    @GET("api/v1/movies?")
    suspend fun getMoviesPagingByName(@Query("q") movieName:String, @Query("page") pageIndex:Int): Response<PagingModel>

    @POST("api/v1/movies")
    suspend fun pushMovies(@Body movie: UploadMovieModel): Response<UploadMovieModel>

    @Multipart
    @POST("api/v1/movies/multi")
    suspend fun pushMoviesMulti(
                    @Part poster: MultipartBody.Part?,
                    @Part ("title") title:RequestBody,
                    @Part ("imdb_id") imdb_id:RequestBody,
                    @Part ("country") country:RequestBody,
                    @Part ("year") year:RequestBody,
        ): Response<UploadMovieModel>


    @POST("api/v1/register/")
    suspend fun registerUser (@Body user: RegisterPostBody): Response<UserRegisteredModel>


    @Multipart
    @POST("oauth/token")
    suspend fun loginUser (@Part ("username") username:RequestBody,
                           @Part ("password") password:RequestBody,
                           @Part("grant_type") grantType:RequestBody
    ):Response<UserAuthModel>

    @GET("api/user")
    suspend fun getUserInfo():Response<UserRegisteredModel>









}