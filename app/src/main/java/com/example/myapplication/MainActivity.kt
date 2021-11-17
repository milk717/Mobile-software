package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity(){
    private val fruitViewModel: FruitViewModel by lazy{
        ViewModelProvider(this).get(FruitViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fruits = fruitViewModel.fruitList

        val recyclerView:RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(this,2)
        recyclerView.adapter = MyAdapter(fruits)
    }

    class MyAdapter(var list:List<Fruit>) : RecyclerView.Adapter<MyViewHolder>(){
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val view = inflater.inflate(R.layout.item, parent,false)
            return MyViewHolder(view)
        }

        override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
            val fruit = list[position]
            holder.bind(fruit)
        }

        override fun getItemCount() = list.size
    }
    //화면에 띄워줄 리사이클러 뷰 정보를 가져오는 메소드
    class  MyViewHolder(view: View) : RecyclerView.ViewHolder(view){
        var textView: TextView = view.findViewById(R.id.textView)

        fun bind(fruit: Fruit){
            textView.text = fruit.name
        }
    }
}

