package com.example.calculator

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.calculator.R
import kotlin.math.log10
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {

    private lateinit var tvDisplay: TextView
    private lateinit var tvMemory: TextView

    private var currentInput = ""
    private var operator = ""
    private var firstOperand = 0.0
    private var secondOperand = 0.0
    private var memory = 0.0
    private var isResultShown = false
    private var isOperatorPressed = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
        setupNumberButtons()
        setupOperatorButtons()
        setupFunctionButtons()
        setupMemoryButtons()
        updateDisplay()
    }

    private fun initViews() {
        tvDisplay = findViewById(R.id.tvDisplay)
        tvMemory = findViewById(R.id.tvMemory)
    }

    private fun setupNumberButtons() {
        val numberButtons = arrayOf(
            R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4,
            R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9
        )

        numberButtons.forEachIndexed { index, buttonId ->
            findViewById<Button>(buttonId).setOnClickListener {
                onNumberClick(index.toString())
            }
        }

        findViewById<Button>(R.id.btnDot).setOnClickListener {
            onNumberClick(".")
        }
    }

    private fun setupOperatorButtons() {
        findViewById<Button>(R.id.btnAdd).setOnClickListener { onOperatorClick("+") }
        findViewById<Button>(R.id.btnSubtract).setOnClickListener { onOperatorClick("-") }
        findViewById<Button>(R.id.btnMultiply).setOnClickListener { onOperatorClick("×") }
        findViewById<Button>(R.id.btnDivide).setOnClickListener { onOperatorClick("÷") }
        findViewById<Button>(R.id.btnEquals).setOnClickListener { onEqualsClick() }
    }

    private fun setupFunctionButtons() {
        findViewById<Button>(R.id.btnClear).setOnClickListener { onClearClick() }
        findViewById<Button>(R.id.btnClearAll).setOnClickListener { onClearAllClick() }
        findViewById<Button>(R.id.btnBackspace).setOnClickListener { onBackspaceClick() }
        findViewById<Button>(R.id.btnSqrt).setOnClickListener { onSqrtClick() }
        findViewById<Button>(R.id.btnLog).setOnClickListener { onLogClick() }
    }

    private fun setupMemoryButtons() {
        findViewById<Button>(R.id.btnMPlus).setOnClickListener { onMemoryPlusClick() }
        findViewById<Button>(R.id.btnMMinus).setOnClickListener { onMemoryMinusClick() }
        findViewById<Button>(R.id.btnMR).setOnClickListener { onMemoryRecallClick() }
        findViewById<Button>(R.id.btnMC).setOnClickListener { onMemoryClearClick() }
    }

    private fun onNumberClick(number: String) {
        if (isResultShown) {
            currentInput = ""
            isResultShown = false
        }

        if (isOperatorPressed) {
            currentInput = ""
            isOperatorPressed = false
        }

        if (number == "." && currentInput.contains(".")) {
            return
        }

        if (currentInput == "0" && number != ".") {
            currentInput = number
        } else {
            currentInput += number
        }

        updateDisplay()
    }

    private fun onOperatorClick(op: String) {
        if (currentInput.isNotEmpty()) {
            if (operator.isNotEmpty() && !isOperatorPressed) {
                onEqualsClick()
            }

            firstOperand = currentInput.toDoubleOrNull() ?: 0.0
            operator = op
            isOperatorPressed = true
            isResultShown = false
        }
    }

    private fun onEqualsClick() {
        if (currentInput.isNotEmpty() && operator.isNotEmpty()) {
            secondOperand = currentInput.toDoubleOrNull() ?: 0.0

            val result = when (operator) {
                "+" -> firstOperand + secondOperand
                "-" -> firstOperand - secondOperand
                "×" -> firstOperand * secondOperand
                "÷" -> {
                    if (secondOperand != 0.0) {
                        firstOperand / secondOperand
                    } else {
                        showError("Cannot divide by zero")
                        return
                    }
                }
                else -> 0.0
            }

            currentInput = if (result == result.toInt().toDouble()) {
                result.toInt().toString()
            } else {
                String.format("%.8f", result).trimEnd('0').trimEnd('.')
            }

            operator = ""
            isResultShown = true
            updateDisplay()
        }
    }

    private fun onClearClick() {
        currentInput = ""
        updateDisplay()
    }

    private fun onClearAllClick() {
        currentInput = ""
        operator = ""
        firstOperand = 0.0
        secondOperand = 0.0
        isResultShown = false
        isOperatorPressed = false
        updateDisplay()
    }

    private fun onBackspaceClick() {
        if (currentInput.isNotEmpty() && !isResultShown) {
            currentInput = currentInput.dropLast(1)
            updateDisplay()
        }
    }

    private fun onSqrtClick() {
        if (currentInput.isNotEmpty()) {
            val value = currentInput.toDoubleOrNull() ?: 0.0
            if (value >= 0) {
                val result = sqrt(value)
                currentInput = if (result == result.toInt().toDouble()) {
                    result.toInt().toString()
                } else {
                    String.format("%.8f", result).trimEnd('0').trimEnd('.')
                }
                isResultShown = true
                updateDisplay()
            } else {
                showError("Cannot calculate square root of negative number")
            }
        }
    }

    private fun onLogClick() {
        if (currentInput.isNotEmpty()) {
            val value = currentInput.toDoubleOrNull() ?: 0.0
            if (value > 0) {
                val result = log10(value)
                currentInput = if (result == result.toInt().toDouble()) {
                    result.toInt().toString()
                } else {
                    String.format("%.8f", result).trimEnd('0').trimEnd('.')
                }
                isResultShown = true
                updateDisplay()
            } else {
                showError("Cannot calculate log of zero or negative number")
            }
        }
    }

    private fun onMemoryPlusClick() {
        if (currentInput.isNotEmpty()) {
            val value = currentInput.toDoubleOrNull() ?: 0.0
            memory += value
            updateMemoryDisplay()
        }
    }

    private fun onMemoryMinusClick() {
        if (currentInput.isNotEmpty()) {
            val value = currentInput.toDoubleOrNull() ?: 0.0
            memory -= value
            updateMemoryDisplay()
        }
    }

    private fun onMemoryRecallClick() {
        currentInput = if (memory == memory.toInt().toDouble()) {
            memory.toInt().toString()
        } else {
            String.format("%.8f", memory).trimEnd('0').trimEnd('.')
        }
        isResultShown = true
        updateDisplay()
    }

    private fun onMemoryClearClick() {
        memory = 0.0
        updateMemoryDisplay()
    }

    private fun updateDisplay() {
        tvDisplay.text = if (currentInput.isEmpty()) "0" else currentInput
    }

    private fun updateMemoryDisplay() {
        tvMemory.text = if (memory != 0.0) {
            "M: ${if (memory == memory.toInt().toDouble()) memory.toInt().toString() else String.format("%.2f", memory)}"
        } else {
            ""
        }
    }

    private fun showError(message: String) {
        tvDisplay.text = message
        currentInput = ""
        operator = ""
        isResultShown = true
    }
}