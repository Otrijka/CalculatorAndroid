package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.calculator.databinding.ActivityMainBinding

open class Calculator {

    private
        var fillA = true
        var fillB = false
        var doingHasClicked = false

        var doing = ' '
        var strA: String = ""
        var strB: String = ""
        var intA: Long = 0
        var intB: Long = 0
        var result: Long = 0

    open
    fun fillString(temp: Char) {
        if (fillA == true) {
            strA += temp
            Log.d("calcLogs", "a: ${strA}")
        } else if (fillB == true) {
            strB += temp
            Log.d("calcLogs", "b: ${strB}")
        }
    }

    fun doDoing(doo: Char) {
        if (strA.isEmpty()){
            return
        }
        doing = doo
        doingHasClicked = true
        fillA = false
        fillB = true
        intA = strA.toLong()
        Log.d("calcLogs", "doing ${doing}")
    }

    fun clear() {
        fillA = true
        fillB = false
        doingHasClicked = false
        intA = 0
        intB = 0
        result = 0
        strA = ""
        strB = ""
        doing = ' '
        Log.d("calcLogs", " Data has cleared")
    }

    fun makeResult() {
        if (doingHasClicked == true) {
            intB = strB.toLong()

            if (doing.equals('+')) {
                result = intA + intB
            } else if (doing.equals('-')) {
                result = intA - intB
            } else if (doing.equals('%')) {
                result = intA % intB
            } else if (doing.equals('/')) {
                result = intA / intB
            } else if (doing.equals('*')) {
                result = intA * intB
            }
            Log.d("calcLogs", "${strA} ${doing} ${strB} = ${result}")
            intA = result
            strA = intA.toString()
            intB = 0
            strB = ""
            doing = ' '
        }
    }
    fun getA() : String{
        return strA
    }
    fun getB() : String{
        return strB
    }

    fun getDo() : Boolean{
        return doingHasClicked
    }

    fun getRes() : Long{
        return result
    }

}

class MainActivity : AppCompatActivity() {

    lateinit var bindingClass: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)

        var calc = Calculator()

        fun fillMainString(){
            if (calc.getDo() == false){
                bindingClass.mainSTring.text = calc.getA()
            }
            else{
                bindingClass.mainSTring.text = calc.getB()
            }
        }

        fun clearMainString(){
            bindingClass.mainSTring.text = "0"
        }

        bindingClass.button0.setOnClickListener {
            if (!calc.strA.isEmpty()) {
                calc.fillString('0')
                fillMainString()
            }
        }

        bindingClass.button1.setOnClickListener {
            calc.fillString('1')
            fillMainString()
        }

        bindingClass.button2.setOnClickListener {
            calc.fillString('2')
            fillMainString()
        }

        bindingClass.button3.setOnClickListener {
            calc.fillString('3')
            fillMainString()
        }

        bindingClass.button4.setOnClickListener {
            calc.fillString('4')
            fillMainString()
        }

        bindingClass.button5.setOnClickListener {
            calc.fillString('5')
            fillMainString()
        }

        bindingClass.button6.setOnClickListener {
            calc.fillString('6')
            fillMainString()
        }

        bindingClass.button7.setOnClickListener {
            calc.fillString('7')
            fillMainString()
        }

        bindingClass.button8.setOnClickListener {
            calc.fillString('8')
            fillMainString()
        }

        bindingClass.button9.setOnClickListener {
            calc.fillString('9')
            fillMainString()
        }

        bindingClass.buttonAC.setOnClickListener {
            calc.clear()
            clearMainString()
        }

        bindingClass.buttonmod.setOnClickListener {
            calc.doDoing('%')
            clearMainString()
        }

        bindingClass.buttonmultiply.setOnClickListener {
            calc.doDoing('*')
            clearMainString()
        }

        bindingClass.buttondiv.setOnClickListener {
            calc.doDoing('/')
            clearMainString()
        }

        bindingClass.buttonminus.setOnClickListener {
            calc.doDoing('-')
            clearMainString()
        }

        bindingClass.buttonplus.setOnClickListener {
            calc.doDoing('+')
            clearMainString()
        }

        bindingClass.buttondiv4equally.setOnClickListener {
            calc.makeResult()
            var res = calc.getRes()
            if (res < 0){
                bindingClass.mainSTring.text = "${res.toString()}"
            }
            else{
                bindingClass.mainSTring.text = res.toString()
            }
        }

        bindingClass.buttoncomma.setOnClickListener{
            bindingClass.mainSTring.text = "It isn't work"
        }

        bindingClass.buttonwtf.setOnClickListener{
            bindingClass.mainSTring.text = "It isn't work"
        }
    }
}
