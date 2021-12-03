package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class MovieAdapter(private val list:List<MovieItem>): RecyclerView.Adapter<MovieAdapter.MyViewHolder>() {

    //RecyclerView.Adapter 의 3개의 추상 메소드 구현

    //ViewHolder 객체 생성, item 출력을 위한 레이아웃 파일 inflate(팽창==화면에뿌리기)시킴.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.movie_item, parent, false)
        return MyViewHolder(v)
    }

    //리스트에 속한 item 을 하나씩 가져와 출력 => 리스트에 속한 값을 해당하는 뷰 객체에 넣어줌
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val items:MovieItem = list[position]
        holder.bind(items)
    }

    //아이템 리스트의 사이즈를 반환
    override fun getItemCount(): Int {
        return list.size
    }

    //리사이클러뷰 아이템 레이아웃에 있는 객체들 불러오기
    //버튼클릭리스너 상속받기
    inner class MyViewHolder(view: View): RecyclerView.ViewHolder(view),View.OnClickListener{
        private lateinit var  movie: MovieItem
        var postImageView: ImageView = view.findViewById(R.id.image)
        var titleTextView: TextView = view.findViewById(R.id.title)
        var ratingTextView: TextView = view.findViewById(R.id.rating)
        var genreTextView: TextView = view.findViewById(R.id.genre)
        var releaseYearTextView: TextView = view.findViewById(R.id.releaseYear)

        init {
            //초기화 단계에서 버튼클릭리스너 달아주기
            postImageView.setOnClickListener(this)
        }

        fun bind(movie: MovieItem){
            this.movie = movie
            titleTextView.text = this.movie.title
            ratingTextView.text = this.movie.rating
            genreTextView.text = this.movie.genre
            releaseYearTextView.text = this.movie.year
            postImageView.setImageResource(this.movie.resId)
        }

        override fun onClick(v: View?) {
            //v가 View? 타입인데 토스트의 context 는 null 타입 허용 안하기 때문에 !!붙이기
            Toast.makeText(v!!.context,movie.title, Toast.LENGTH_SHORT).show()
        }
    }
}
