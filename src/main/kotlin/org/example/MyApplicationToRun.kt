package org.example

import tornadofx.launch

class MyApplicationToRun {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
//            MyApp().main(args)
            launch<MyApp>(args)
        }
    }
}