package org.example

import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.layout.VBox
//import javafx.fxml.FXML
import tornadofx.*
import javafx.scene.input.KeyEvent

class CalcView : View("My View") {

    override val root: VBox by fxml()

    //        override val root = vbox {
//        label("Hello world")
//        button("Click here")
//    }

    //    @FXML
    lateinit var display: Label

    init {
        title = "Kotlin Calculator"
        root.lookupAll(".button").forEach { b ->
            b.setOnMouseClicked {
                operator((b as Button).text)
            }
        }
        root.addEventFilter(KeyEvent.KEY_TYPED) {
            operator(it.character.toUpperCase().replace("\r", "="))
        }
    }

    var state: Operator = Operator.add(0)

    fun onAction(fn: Operator) {
        state = fn
        display.text = ""
    }

    val displayValue: Long
        get() = when (display.text) {
            "" -> 0
            else -> display.text.toLong()
        }

    private fun operator(x: String) {
        if (Regex("[0-9]").matches(x)) {
            display.text += x
        } else {
            when (x) {
                "+" -> onAction(Operator.add(displayValue))
                "-" -> onAction(Operator.sub(displayValue))
                "/" -> onAction(Operator.div(displayValue))
                "X" -> onAction(Operator.mul(displayValue))
                "%" -> {
                    onAction(Operator.add(displayValue / 100))
                    operator("=")
                }

                "C" -> onAction(Operator.add(0))
                "+/-" -> {
                    onAction(Operator.add(-1 * displayValue))
                    operator("=")
                }

                "=" -> display.text = state.calculate(displayValue).toString()
            }
        }
    }

}
