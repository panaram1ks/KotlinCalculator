package org.example

import javafx.scene.control.Label
import javafx.scene.layout.VBox
import javafx.fxml.FXML
import tornadofx.*
import javafx.scene.input.KeyEvent

class CalcView : View("My View") {

    override val root: VBox by fxml()

    //        override val root = vbox {
//        label("Hello world")
//        button("Click here")
//    }
    @FXML
    lateinit var display: Label

    init {
        title = "Kotlin Calculator"
        root.lookupAll(".button").forEach { b ->
            b.setOnMouseClicked {

            }
        }

        root.addEventFilter(KeyEvent.KEY_TYPED){

        }
    }

    var state: Operator = add(0)

}
