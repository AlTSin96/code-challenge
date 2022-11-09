import java.util.*

class Canvas {
    var width: Int
        private set
    var height: Int
        private set
    var matrix: Array<Array<String?>>
        private set

    constructor(w: Int, h: Int, matrix: Array<Array<String?>>) {

        width = w
        height = h
        this.matrix = matrix
    }

    constructor(w: Int, h: Int) {

        width = w
        height = h
        matrix = Array(height) { arrayOfNulls(width) }
        resetMatrix()
    }



    fun clearCanvas() {
        resetMatrix()
    }

    private fun resetMatrix() {
        for (i in 0 until height) {
            for (j in 0 until width) {
                matrix[i][j] = " "
            }
        }
    }




    fun printCanvas() {
        // first row ----------
        for (j in 0 until width + 2) {
            print("-")
        }
        println()

        // the body of the canvas | **** |
        for (i in 0 until height) {
            for (j in 0 until width + 2) {
                if (j == 0 || j == width + 1) {
                    print("|")
                } else {
                    print(matrix[i][j - 1])
                }
            }
            println()
        }

        // footer --------
        for (j in 0 until width + 2) {
            print("-")
        }
        println("\n")
    }
    fun drawLine(x1: Int,y1: Int,x2: Int,y2: Int){
    /*  matrix[1][0] = "X"
        matrix[1][1] = "X"
        matrix[1][2] = "X"
        matrix[1][3] = "X"
        matrix[1][4] = "X"
        matrix[1][5] = "X"
        matrix[2][5] = "X"
        matrix[3][5] = "X"
----------------------
|                    |
|XXXXXX              |
|     X              |
|     X              |
----------------------

     */
        for (i in 0 until height) {
            for (j in 0 until width) {
                // horizontal line from X1 to X2 (shift +1 to match user input)
                if (j + 1 in x1..x2 && i + 1 == y1) {
                    matrix[i][j] = "X"
                }
                // vertical line from Y1 to Y2 (shift +1 to match user input)
                if (i + 1 in y1..y2 && j + 1 == x1) {
                    matrix[i][j] = "X"
                }
            }
        }
        printCanvas()
    }

    fun drawRectangle(x1: Int,y1: Int,x2: Int,y2: Int){
     /* matrix[0][16] = "X"
        matrix[0][17] = "X"
        matrix[0][18] = "X"
        matrix[0][19] = "X"
        matrix[1][16] = "X"
        matrix[1][19] = "X"
        matrix[2][19] = "X"
        matrix[2][16] = "X"
        matrix[2][17] = "X"
        matrix[2][18] = "X"
----------------------
|               XXXXX|
|               X   X|
|               XXXXX|
|                    |
----------------------
    */
        for (i in 0 until height) {
            for (j in 0 until width) {
                // horizontal line from X1 to X2 (shift +1 to match user input)
                // in case we are in the first row(Y1) or in the second row(Y2)
                if (j + 1 in x1..x2 && (i + 1 == y1 || i + 1 == y2)) {
                    matrix[i][j] = "X"
                }

                // vertical line from Y1 to Y2 (shift +1 to match user input)
                // where we are in the first column(X1) or second column(X2)
                if (i + 1 in y1..y2 && (j + 1 ==x1 || j + 1 == x2)) {
                    matrix[i][j] = "X"
                }
            }
        }
        printCanvas()
    }
    fun quitCanvas(){
        print("Quitting")

    }


    override fun toString(): String {
        var res = ""
        // first row ----------
        for (j in 0 until width + 2) {
            res = "$res-"
        }
        res = """
               $res
               
               """.trimIndent()

        // the body of the canvas | **** |
        for (i in 0 until height) {
            for (j in 0 until width + 2) {
                res = if (j == 0 || j == width + 1) {
                    "$res|"
                } else {
                    res + matrix[i][j - 1]
                }
            }
            res = """
                $res
                
                """.trimIndent()
        }

        // footer --------
        for (j in 0 until width + 2) {
            res = "$res-"
        }
        return res
    }
    fun getCanvas(i: Int,j: Int): String? {
        return matrix[i][j]
    }

}



/*
 var test= Canvas(20, 4)
    test.drawLine(1,2,6,2)
    test.drawLine(6,3,6,4)
    test.drawRectangle(16,1,20,3)
    test.clearCanvas()
    test.printCanvas()
    test.drawLine(1,4,6,2)
    test.drawLine(6,3,6,4)
    test.drawRectangle(16,1,20,3)
*/



