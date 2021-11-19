package com.example.myapplication

import android.os.Bundle
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.databinding.ItemBinding


class MainActivity : AppCompatActivity(){
    private lateinit var fruitModel:FruitViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        val binding: ActivityMainBinding =      //각각의 레이아웃의 루트를 가져옴
            DataBindingUtil.setContentView(this, R.layout.activity_main)

        fruitModel = FruitViewModel()
        binding.recyclerView.apply {
            layoutManager = GridLayoutManager(context,3)
            adapter = MyAdapter(fruitModel.fruits)
        }
    }

    class  MyViewHolder(private val binding:ItemBinding) :
        RecyclerView.ViewHolder(binding.root){
        init{
            binding.viewModel = FruitViewModel()
        }
        fun bind(fruit:Fruit){
            binding.viewModel?.fruit = fruit
            binding.executePendingBindings()
        }
    }

    inner class MyAdapter(private var fruits:List<Fruit>) : RecyclerView.Adapter<MyViewHolder>(){
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
            val binding = DataBindingUtil.inflate<ItemBinding>(
                layoutInflater, R.layout.item, parent, false)
            return MyViewHolder(binding)
        }

        override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
            val fruit = fruits[position]
            holder.bind(fruit)
        }

        override fun getItemCount() = fruits.size
    }


}