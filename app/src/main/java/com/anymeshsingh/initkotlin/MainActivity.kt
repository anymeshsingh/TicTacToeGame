package com.anymeshsingh.initkotlin

import android.graphics.Color
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN)
    fun btnClick(view:View){
        val btnClicked:Button = view as Button
        var btnId:Int = 0

        when(btnClicked.id){
            R.id.btn1-> btnId = 1
            R.id.btn2-> btnId = 2
            R.id.btn3-> btnId = 3
            R.id.btn4-> btnId = 4
            R.id.btn5-> btnId = 5
            R.id.btn6-> btnId = 6
            R.id.btn7-> btnId = 7
            R.id.btn8-> btnId = 8
            R.id.btn9-> btnId = 9
        }
        if(winner == -1){
            playGame(btnId,btnClicked)
        }else{
            reset(view)
        }

    }

    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()
    var activePlayer = 1
    var winner = -1


    fun playGame(btnId:Int, btnClicked:Button){

        btnClicked.setTextSize(25.0F)

        if(activePlayer == 1){

            btnClicked.text = "X"
            btnClicked.setBackgroundResource(R.color.x)
            player1.add(btnId)
            activePlayer = 2

        }else{

            btnClicked.text = "O"
            btnClicked.setBackgroundResource(R.color.o)
            player2.add(btnId)
            activePlayer = 1

        }

        winner()
        btnClicked.isEnabled = false
    }

    fun winner(){

        if( (player1.contains(1) && player1.contains(2) && player1.contains(3)) || (player1.contains(4) && player1.contains(5) && player1.contains(6)) || (player1.contains(7) && player1.contains(8) && player1.contains(9))){
            Toast.makeText(this,"Player 1 Wins!!",Toast.LENGTH_LONG).show()
            winner = 1
        }
        else if ( (player1.contains(1) && player1.contains(4) && player1.contains(7)) || (player1.contains(2) && player1.contains(5) && player1.contains(8)) || (player1.contains(3) && player1.contains(6) && player1.contains(9)) ){
            Toast.makeText(this,"Player 1 Wins!!",Toast.LENGTH_LONG).show()
            winner = 1
        }
        else if ( (player1.contains(1) && player1.contains(5) && player1.contains(9)) || (player1.contains(3) && player1.contains(5) && player1.contains(7)) ){
            Toast.makeText(this,"Player 1 Wins!!",Toast.LENGTH_LONG).show()
            winner = 1
        }
        else if( (player2.contains(1) && player2.contains(2) && player2.contains(3)) || (player2.contains(4) && player2.contains(5) && player2.contains(6)) || (player2.contains(7) && player2.contains(8) && player2.contains(9))){
            Toast.makeText(this,"Player 2 Wins!!",Toast.LENGTH_LONG).show()
            winner = 2
        }
        else if ( (player2.contains(1) && player2.contains(4) && player2.contains(7)) || (player2.contains(2) && player2.contains(5) && player2.contains(8)) || (player2.contains(3) && player2.contains(6) && player2.contains(9)) ){
            Toast.makeText(this,"Player 2 Wins!!",Toast.LENGTH_LONG).show()
            winner = 2
        }
        else if ( (player2.contains(1) && player2.contains(5) && player2.contains(9)) || (player2.contains(3) && player2.contains(5) && player2.contains(7)) ){
            Toast.makeText(this,"Player 2 Wins!!",Toast.LENGTH_LONG).show()
            winner = 2
        }
        else{

        }

    }

    fun reset(view: View){
        btn1.isEnabled = true
        btn2.isEnabled = true
        btn3.isEnabled = true
        btn4.isEnabled = true
        btn5.isEnabled = true
        btn6.isEnabled = true
        btn7.isEnabled = true
        btn8.isEnabled = true
        btn9.isEnabled = true

        btn1.text = ""
        btn2.text = ""
        btn3.text = ""
        btn4.text = ""
        btn5.text = ""
        btn6.text = ""
        btn7.text = ""
        btn8.text = ""
        btn9.text = ""

        btn1.setBackgroundColor(Color.WHITE)
        btn2.setBackgroundColor(Color.WHITE)
        btn3.setBackgroundColor(Color.WHITE)
        btn4.setBackgroundColor(Color.WHITE)
        btn5.setBackgroundColor(Color.WHITE)
        btn6.setBackgroundColor(Color.WHITE)
        btn7.setBackgroundColor(Color.WHITE)
        btn8.setBackgroundColor(Color.WHITE)
        btn9.setBackgroundColor(Color.WHITE)

        player1.clear()
        player2.clear()
        activePlayer = 1
        winner = -1

    }

}
