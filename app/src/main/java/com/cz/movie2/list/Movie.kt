package com.cz.movie2.list

import retrofit2.Call
import retrofit2.http.GET

data class Movie(
    val page: Int,
    val results: List<Result>,
    val total_pages: Int,
    val total_results: Int
)

data class Result(
    val adult: Boolean,
    val backdrop_path: String,
    val genre_ids: List<Int>,
    val id: Int,
    val original_language: String,
    val original_title: String,
    val overview: String,
    val popularity: Double,
    val poster_path: String,
    val release_date: String,
    val title: String,
    val video: Boolean,
    val vote_average: Double,
    val vote_count: Int
)

//https://api.myjson.com/bins/jcu1v
interface MovieService {
    @GET("jcu1v")
    fun listMovies():Call<List<Movie>>
}