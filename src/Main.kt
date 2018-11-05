
import java.text.DecimalFormat
import javax.swing.JOptionPane
import operacionesMatriciales.Operaciones

private var df = DecimalFormat("#.00000")

fun main(args: Array<String>) {
//    val entradas = arrayOf(intArrayOf(1,0,0,0), intArrayOf(0,1,0,0), intArrayOf(0,0,1,0), intArrayOf(0,0,0,1))

    val e=Integer.parseInt(JOptionPane.showInputDialog("cuantas enntradas vas a ingresar"))
    val p=Integer.parseInt(JOptionPane.showInputDialog("cuantas patrones vas a ingresar"))

    val ta=(JOptionPane.showInputDialog("cual es la taza de aprendizaje")).toDouble()
    val u=(JOptionPane.showInputDialog("cual es el umbral")).toDouble()

    val salidasDeseadas =  IntArray(p)
    val entradas =Array(p){ DoubleArray(e)}
    val capas: ArrayList<Capa> = ArrayList()
    val oper = Operaciones()
    var yCapa : Array<DoubleArray>? = null
    var bandera = true


    println()
/*------------INICIALIZACIÓN DE PATRONES DE ENTRADA Y SUS SALIDAS--------------*/
    println("-------------------------------------------------")
    println("INICIALIZACIÓN DE ENTRADAS Y SALIDAS")
    println()

    for (i in  0 until p)
    {
        print(" | ")
        for (j in 0 until e)
        {
            entradas[i][j]=JOptionPane.showInputDialog("ingresa la entrada $j del patron $i").toDouble()
            print(entradas[i][j])
            print(" ")
        }
         salidasDeseadas[i]=JOptionPane.showInputDialog("ingresa la salida deseada del patron $i ").toInt()
        print(" | ")
        print(salidasDeseadas[i] )
        print(" | ")
        println("")
    }

    /*-----------DEFINIR CUANTAS CAPAS OCULTAS HABRÁ -----------------*/
    val c=Integer.parseInt(JOptionPane.showInputDialog("cuantas capas ocultas son"))

    /*-----------INICIALIZACIÓN DE PESOS---------*/
    for (i in 0 until c+1)
    {
        if(i==c)
        {
            val n = Integer.parseInt(JOptionPane.showInputDialog("cuantas neuronas son para la capa de salida "))
            capas.add(Capa(capas[i-1].pesos[0].size, n))
        }
        else
        {
            val n = Integer.parseInt(JOptionPane.showInputDialog("cuantas neuronas son para la capa $i "))
            if (bandera==true) {
                capas.add(Capa(e, n))
                bandera=false
            }
            else{
                capas.add(Capa(capas[i-1].pesos[0].size, n))
            }
        }
    }
    println()

    val iter = capas.listIterator(capas.size)
    //------FUNCIONAMIENTO------

    entradas.forEach { patron ->
        print("patron: ")
        patron.forEach {
            print(it)
        }
        println()
        bandera=true

        /*------------PROPAGACIÓN HACIA ADELANTE--------------*/
        capas.forEach { capa ->

            if (bandera) {
                yCapa = arrayOf(oper.multiplyMatrices(capa.pesos, patron))

                yCapa!!.forEach { fila ->
                    fila.forEach { dato ->
                        print(dato)
                    }
                }
                bandera=false
            }
            else {
                yCapa= arrayOf(oper.multiplyMatrices(capa.pesos, yCapa!![0]!!))

                yCapa!!.forEach { fila ->
                    fila.forEach { dato ->
                        print(dato)
                    }
                }
            }
            println()
        }
        println()
        /*-----------PROPAGACIÓN DEL ERROR HACIA ATRÁS--------------*/
        while (iter.hasPrevious()) {
            iter.previous().pesos.forEach { peso->
                peso.forEach { valor->
                    print(valor)

                    /*CODIGO CORRECCION DE PESOS*/


                }
                println()
            }
            println()
        }

        println()


    }



}

