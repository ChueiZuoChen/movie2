package com.cz.movie2.list


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.cz.movie2.R
import com.cz.movie2.databinding.FragmentListBinding
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.info
import org.jetbrains.anko.support.v4.intentFor
import org.jetbrains.anko.uiThread
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class ListFragment : Fragment(), AnkoLogger {

    lateinit var binding: FragmentListBinding


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_list, container, false)
        var movies:List<Movie>?=null
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.myjson.com/bins/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        doAsync {

            val movieService = retrofit.create(MovieService::class.java)
            movies = movieService.listMovies()
                .execute()
                .body()
//            movies?.forEachIndexed { index, movie ->
//                info("${movie.results[index].original_title} ${movie.results[index].overview} ${movie.results[index].release_date} ${movie.results[index].vote_average}")
//            }
            uiThread {
                binding.recyclerList.layoutManager = LinearLayoutManager(container?.context)
                binding.recyclerList.setHasFixedSize(true)
                binding.recyclerList.adapter = ListMovieAdapter(movies!!)
            }
        }


        return binding.root
    }


}
