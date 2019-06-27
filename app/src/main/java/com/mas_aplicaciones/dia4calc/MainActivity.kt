package com.mas_aplicaciones.dia4calc

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import org.mariuszgromada.math.mxparser.Expression

class MainActivity : AppCompatActivity() {

    var tvDisplay: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvDisplay = findViewById(R.id.tvDisplay)
    }

    fun click(view: View) {
        val txt: String = tvDisplay?.text.toString()
        val c: String = (view as Button).text as String

        if(c.equals(".")) {
            validarPunto()
            if (txt.contains("."))
                return
        }

        if(txt.equals("0"))
            tvDisplay?.text  = c
        else
            tvDisplay?.text  = txt + c
    }
    fun validarPunto(): Boolean {
        val txt: String = tvDisplay?.text.toString()

        val operandos = txt.split("+|-|*|/|(|)")
        for(elemento: String in operandos)
            Log.e("ee", elemento)
        return true;
    }

    fun borrarUltimo(view: View) {
        val txt: String = tvDisplay?.text.toString()
        if(txt.length==1)
            tvDisplay?.text = "0"
        else
            tvDisplay?.text = txt.subSequence(0, txt.length-1)
    }

    fun borrarTodo(view: View) {
        tvDisplay?.text = "0"
    }
    fun calcular(view: View) {
        val txt: String = tvDisplay?.text.toString()
        var ex: Expression;
        ex = Expression(txt)
        tvDisplay?.text = ex.calculate().toString()
    }
}
