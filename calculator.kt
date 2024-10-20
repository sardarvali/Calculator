    package com.example.syed

    import android.os.Bundle
    import android.widget.Button
    import android.widget.TextView
    import androidx.activity.enableEdgeToEdge
    import androidx.appcompat.app.AppCompatActivity
    import androidx.core.view.ViewCompat
    import androidx.core.view.WindowInsetsCompat

    class calculator : AppCompatActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            enableEdgeToEdge()
            setContentView(R.layout.activity_calculator)


            var operand1: Double = 0.0
            var operand2: Double = 0.0
            var operator: String = ""
            var result: Double = 0.0
            var isOperatorSelected = false

            var ctv1 = findViewById<TextView>(R.id.textViewc1)
            var ctv2 = findViewById<TextView>(R.id.textViewc2)


            // Buttons
            var c0 = findViewById<Button>(R.id.buttonc0)
            var c1 = findViewById<Button>(R.id.buttonc1)
            var c2 = findViewById<Button>(R.id.buttonc2)
            var c3 = findViewById<Button>(R.id.buttonc3)
            var c4 = findViewById<Button>(R.id.buttonc4)
            var c5 = findViewById<Button>(R.id.buttonc5)
            var c6 = findViewById<Button>(R.id.buttonc6)
            var c7 = findViewById<Button>(R.id.buttonc7)
            var c8 = findViewById<Button>(R.id.buttonc8)
            var c9 = findViewById<Button>(R.id.buttonc9)
            var cadd = findViewById<Button>(R.id.buttonadd)
            var csub = findViewById<Button>(R.id.buttonsub)
            var cmul = findViewById<Button>(R.id.buttonmul)
            var cdiv = findViewById<Button>(R.id.buttondiv)
            var cdot = findViewById<Button>(R.id.buttondot)
            var cmix = findViewById<Button>(R.id.buttonmix)
            var cequal = findViewById<Button>(R.id.buttonequal)
            var cclean = findViewById<Button>(R.id.buttonclean)
            var creset = findViewById<Button>(R.id.buttonreset)
            var cper = findViewById<Button>(R.id.buttonper)


            fun appendNumber(number: String) {
                if (isOperatorSelected) {
                    ctv1.text = ""
                    isOperatorSelected = false
                }
                ctv1.text = ctv1.text.toString() + number
            }
            // buttons for onsetlistener

            c0.setOnClickListener { appendNumber("0") }
            c1.setOnClickListener { appendNumber("1") }
            c2.setOnClickListener { appendNumber("2") }
            c3.setOnClickListener { appendNumber("3") }
            c4.setOnClickListener { appendNumber("4") }
            c5.setOnClickListener { appendNumber("5") }
            c6.setOnClickListener { appendNumber("6") }
            c7.setOnClickListener { appendNumber("7") }
            c8.setOnClickListener { appendNumber("8") }
            c9.setOnClickListener { appendNumber("9") }

            cadd.setOnClickListener {
                operand1 = ctv1.text.toString().toDouble()
                operator = "+"
                isOperatorSelected = true
            }

            csub.setOnClickListener {
                operand1 = ctv1.text.toString().toDouble()
                operator = "-"
                isOperatorSelected = true
            }

            cmul.setOnClickListener {
                operand1 = ctv1.text.toString().toDouble()
                operator = "*"
                isOperatorSelected = true
            }

            cdiv.setOnClickListener {
                operand1 = ctv1.text.toString().toDouble()
                operator = "/"
                isOperatorSelected = true
            }

            cdot.setOnClickListener {
                if (!ctv1.text.contains(".")) {
                    ctv1.text = ctv1.text.toString() + "."
                }
            }

            cmix.setOnClickListener {
                val currentText = ctv1.text.toString()
                if (currentText.isNotEmpty()) {
                    if (currentText.startsWith("-")) {
                        ctv1.text = currentText.substring(1)
                    } else {
                        ctv1.text = "-$currentText"
                    }
                }
            }

            cper.setOnClickListener {
                val currentText = ctv1.text.toString()
                if (currentText.isNotEmpty()) {
                    ctv1.text = (currentText.toDouble() / 100).toString()
                }
            }

            cclean.setOnClickListener {
                ctv1.text = ""
            }

            creset.setOnClickListener {
                operand1 = 0.0
                operand2 = 0.0
                result = 0.0
                operator = ""
                ctv1.text = ""
            }

            cequal.setOnClickListener {
                operand2 = ctv1.text.toString().toDouble()

                result = when (operator) {
                    "+" -> operand1 + operand2
                    "-" -> operand1 - operand2
                    "*" -> operand1 * operand2
                    "/" -> if (operand2 != 0.0) operand1 / operand2 else Double.NaN
                    else -> 0.0
                }

                ctv1.text = result.toString()
                isOperatorSelected = false
            }
        }
    }
