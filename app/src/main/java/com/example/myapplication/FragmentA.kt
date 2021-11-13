package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class FragmentA : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //(레이아웃, 레이아웃을 포함할 수 있는 컨테이너, false 는 이렇게 만들어진 레이아웃이 루트뷰가 된다.)
        return inflater.inflate(R.layout.fragment_a, container, false)
    }

}