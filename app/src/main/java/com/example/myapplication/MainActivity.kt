package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listItems = ArrayList<String>()
        listItems.add("Apple")
        listItems.add("Apricot")
        listItems.add("Avocado")
        listItems.add("Banana")
        listItems.add("Blackberry")
        listItems.add("Blueberry")
        listItems.add("Cherry")
        listItems.add("Coconut")
        listItems.add("Cranberry")
        listItems.add("Grape Raisin")
        listItems.add("Honeydew")
        listItems.add("Jack fruit")
        listItems.add("Lemon")
        listItems.add("Lime")
        listItems.add("Mango")
        listItems.add("Watermelon")

        val recyclerView:RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)      //리사이클러뷰가 어떻게 보일지, this 는 어떤화면에 보여줄지

        recyclerView.adapter = MyAdapter(listItems)
    }

    class MyAdapter(var list:ArrayList<String>) : RecyclerView.Adapter<MyViewHolder>(){
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val view = inflater.inflate(R.layout.item, parent,false)
            return MyViewHolder(view)
        }

        override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
            val name = list[position]
            holder.textView.text = name
        }

        override fun getItemCount() = list.size
    }
    //화면에 띄워줄 리사이클러 뷰 정보를 가져오는 메소드
    class  MyViewHolder(view: View) : RecyclerView.ViewHolder(view){
        var textView: TextView = view.findViewById(R.id.textView)
    }
}

