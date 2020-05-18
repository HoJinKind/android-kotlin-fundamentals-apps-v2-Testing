package com.example.simplecalc

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    private val TAG = "CalculatorActivity"

    private lateinit var mCalculator: Calculator

    private lateinit var mOperandOneEditText: EditText
    private lateinit var mOperandTwoEditText: EditText
    private lateinit var  mResultTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mCalculator = Calculator()
        mOperandOneEditText = operand_one_edit_text
        mOperandTwoEditText = operand_two_edit_text
        mResultTextView = operation_result_text_view

    }

    /**
     * OnClick method called when the add Button is pressed.
     */
    fun onAdd(view: View?) {
        compute(Calculator.Operator.ADD)
    }

    /**
     * OnClick method called when the subtract Button is pressed.
     */
    fun onSub(view: View?) {
        compute(Calculator.Operator.SUB)
    }

    /**
     * OnClick method called when the divide Button is pressed.
     */
    fun onDiv(view: View?) {
        try {
            compute(Calculator.Operator.DIV)
        } catch (iae: IllegalArgumentException) {
            Log.e(TAG, "IllegalArgumentException", iae)
            mResultTextView.setText(getString(R.string.computationError))
        }
    }

    /**
     * OnClick method called when the multiply Button is pressed.
     */
    fun onMul(view: View?) {
        compute(Calculator.Operator.MUL)
    }

    private fun compute(operator: Calculator.Operator) {
        val operandOne: Double
        val operandTwo: Double
        try {
            operandOne = getOperand(mOperandOneEditText)
            operandTwo = getOperand(mOperandTwoEditText)
        } catch (nfe: NumberFormatException) {
            Log.e(TAG, "NumberFormatException", nfe)
            mResultTextView.setText(getString(R.string.computationError))
            return
        }
        val result: String
        when (operator) {
            Calculator.Operator.ADD -> result =
                mCalculator.add(operandOne, operandTwo).toString()
            Calculator.Operator.SUB -> result = java.lang.String.valueOf(
                mCalculator.sub(operandOne, operandTwo)
            )
            Calculator.Operator.DIV -> result = java.lang.String.valueOf(
                mCalculator.div(operandOne, operandTwo)
            )
            Calculator.Operator.MUL -> result =
                mCalculator.mul(operandOne, operandTwo).toString()
            else -> result = getString(R.string.computationError)
        }
        mResultTextView.setText(result)
    }

    /**
     * @return the operand value entered in an EditText as double.
     */
    private fun getOperand(operandEditText: EditText): Double {
        val operandText: String = getOperandText(operandEditText)
        return java.lang.Double.valueOf(operandText)
    }

    /**
     * @return the operand text which was entered in an EditText.
     */
    private fun getOperandText(operandEditText: EditText): String {
        return operandEditText.text.toString()
    }
}
