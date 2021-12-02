package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MovieFragment : Fragment() {

    private val movieViewModel: MovieViewModel by lazy{
        ViewModelProvider(this).get(MovieViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //리사이클러뷰 객체 볼러오고 레이아웃 매니저를 리니어 레이아웃매니저로 설정
        val rootView = inflater.inflate(R.layout.fragment_movie, container, false)  //루트뷰 선언 꼭!
        var recyclerView: RecyclerView = rootView.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)       //this 대신 context

        recyclerView.adapter = MovieAdapter(movieViewModel.movieList)
        return rootView
    }
}