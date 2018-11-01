import java.text.DecimalFormat

class Capa(e: Int, p : Int){


    val pesos = Array(e){DoubleArray (p)}

    private var df = DecimalFormat("#.00000")

    init {
        for ( i in 0 until pesos.size)
        {
            for(j in 0 until pesos[0].size){
                pesos[i][j]=df.format(Math.random()).toDouble()
            }
        }


        println()
        println("INICIALIZACIÓN DE PESOS")
        println()
        println()

        for ( i in 0 until pesos.size)
        {
            for(j in 0 until pesos[0].size){
                pesos[i][j]=(df.format(Math.random()).toDouble())
            }
        }

        pesos.forEach {dato->
            dato.forEach {
                print(" $it ")
            }
            println()
        }

        println("-----------------------------------------------------------")


    }

}
