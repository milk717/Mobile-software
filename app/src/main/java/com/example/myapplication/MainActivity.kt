package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {
    private val fruitViewModel: FruitViewModel by lazy {
        ViewModelProvider(this).get(FruitViewModel::class.java)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView: RecyclerView
                = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val fruits = fruitViewModel.fruitList
        var adapter = MyAdapter(fruits)
        recyclerView.adapter = adapter
    }

    class MyViewHolder(view: View):
        RecyclerView.ViewHolder(view) {
        var btnView: Button = itemView.findViewById(R.id.btnView)
    }

    inner class MyAdapter(var list: List<Fruit>)
        :RecyclerView.Adapter<MyViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val view = inflater.inflate(R.layout.item, parent, false)
            return MyViewHolder(view)
        }
        override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
            val fruit = list[position]
            holder.apply {
                btnView.text = resources.getString(fruit.resId)
            }
        }
        override fun getItemCount() = list.size
    }
}