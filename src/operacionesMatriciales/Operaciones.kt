package operacionesMatriciales
class Operaciones (  ) {

    fun multiplyMatrices(m1: Array<DoubleArray>, v: DoubleArray) : DoubleArray{
        val fil_m1 = m1.size
        val col_m1 = m1[0].size
        val multiplicacion = DoubleArray(m1[0].size)

        for (i in 0 until m1[0].size) {
            var sum = 0.0
            for (j in 0 until v.size) {
                sum += v[j] * m1[j][i]
            }
            multiplicacion[i] = sum
        }
        return multiplicacion
    }

}