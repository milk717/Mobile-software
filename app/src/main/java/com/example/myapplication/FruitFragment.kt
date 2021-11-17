package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class FruitFragment : Fragment() {
    private val fruitViewModel: FruitViewModel by lazy{
        ViewModelProvider(this).get(FruitViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_fruit, container, false)
        val fruits = fruitViewModel.fruitList
        val recyclerView: RecyclerView = rootView.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = MyAdapter(fruits)
        return rootView
    }
    inner class MyAdapter(var list:List<Fruit>) : RecyclerView.Adapter<MyViewHolder>(){
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
            //val inflater = LayoutInflater.from(parent.context)
            val view = layoutInflater.inflate(R.layout.item, parent,false)
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