package com.example.myapplication

import androidx.lifecycle.ViewModel

class WordViewModel:ViewModel() {
    private val wordBank = listOf<Word>(
        Word("부주의한, 소홀한", "degenerate", "unity", "inadvertent", "array", 3),
        Word("쇠약하게 하다", "vanity", "underhand", "enslave", "debilitate", 4),
        Word("(위험·곤란)제거하다", "artisan", "sadistic", "glossy", "obviate", 4),
        Word("우아한", "prostrate", "delude", "urbane", "renowned", 3),
        Word("활기있게 하다", "bereave", "enliven", "occult", "besiege", 2)
    )
    public var curIndex:Int = 0;       //단어 인덱스 초기값

    val curAnswer:Int
        get() = wordBank[curIndex].answer   //get() == curAnswer 은 wordBank[curIndex].answer 를 가져온 것과 같다.
    val curQuestion:String
        get() = wordBank[curIndex].question
    val curNumber1:String
        get() = wordBank[curIndex].number_1
    val curNumber2:String
        get() = wordBank[curIndex].number_2
    val curNumber3:String
        get() = wordBank[curIndex].number_3
    val curNumber4:String
        get() = wordBank[curIndex].number_4

    fun moveToNext() {
        curIndex = (curIndex + 1) % wordBank.size
    }
    fun moveToPrevious() {
        if(curIndex == 0){
            curIndex = wordBank.size - 1
        }else{
            curIndex -= 1
        }
    }
}