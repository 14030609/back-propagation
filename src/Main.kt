
import java.text.DecimalFormat
import javax.swing.JOptionPane;

private var df = DecimalFormat("#.00000")

fun main(args: Array<String>) {

//    val entradas = arrayOf(intArrayOf(1,0,0,0), intArrayOf(0,1,0,0), intArrayOf(0,0,1,0), intArrayOf(0,0,0,1))


    val e=Integer.parseInt(JOptionPane.showInputDialog("cuantas enttradas vas a ingresar"))
    val p=Integer.parseInt(JOptionPane.showInputDialog("cuantas patrones vas a ingresar"))

    val ta=(JOptionPane.showInputDialog("cual es la taza de aprendizaje")).toDouble()
    val u=(JOptionPane.showInputDialog("cual es el umbral")).toDouble()

    val salidasDeseadas =  IntArray(p)
    val entradas =Array(e){ IntArray(p)}
    val capa: ArrayList<Capa> = ArrayList()

//inicializar entradas y salidas
    println()

    println("-------------------------------------------------")
    println("INICIALIZACIÓN DE ENTRADAS Y SALIDAS")
    println()
    println()

    for (i in  0 until e)
    {
        print(" | ")
        for (j in 0 until p)
        {
            entradas[i][j]=JOptionPane.showInputDialog("ingresa la entrada $i del patron $j").toInt()
            print(entradas[i][j])
            print(" ")
        }
         salidasDeseadas[i]=JOptionPane.showInputDialog("ingresa la salida deseada del patron $i ").toInt()

        print(" | ")
        print(salidasDeseadas[i] )
        print(" | ")

        println("")

    }



    val c=Integer.parseInt(JOptionPane.showInputDialog("cuantas capas ocultas son"))

    for (i in 0 until c)
{
    val n=Integer.parseInt(JOptionPane.showInputDialog("cuantas neuronas son para la capa $i "))
    capa.add(Capa(e,n))
}







}

