package org.example

import javafx.stage.Stage
import tornadofx.*
import tornadofx.launch

class MyApp : App() {

//     fun main(args: Array<String>){
//         launch<MyApp>(args)
//     }

    override val primaryView = CalcView::class

    override fun start(stage: Stage) {
        importStylesheet("/style.css")
        stage.isResizable = false
        super.start(stage)
    }
}