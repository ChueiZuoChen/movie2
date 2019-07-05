package com.cz.movie2.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cz.movie2.R
import kotlinx.android.synthetic.main.row_movie.view.*

class ListMovieAdapter(val movies:List<Movie>) : RecyclerView.Adapter<ListMovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListMovieViewHolder {
        return ListMovieViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.row_movie, parent, false))
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onBindViewHolder(holder: ListMovieViewHolder, position: Int) {
        holder.bindTo(movies[position])
    }
}

class ListMovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val title = itemView.title_text
    val date = itemView.date_text
    val overview = itemView.overview_text
    val vote = itemView.vote_text

    fun bindTo(movie: Movie) {
        title.text = movie.results[10].toString()
        date.text = movie.results[9].toString()
        overview.text = movie.results[6].toString()
        vote.text = movie.results[12].toString()
    }
}