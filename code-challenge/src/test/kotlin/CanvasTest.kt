import org.testng.Assert.*
import org.testng.AssertJUnit
import org.testng.annotations.Test


class CanvasTest {
    val width=20
    val height=4
    val sampleCanvas = Canvas(width, height)
    val empty=" "
    val drawn="X"
    val canvas: Array<Array<String?>> =  Array(height) { arrayOfNulls(width) }

    @Test
    fun testCanvasMatrix(){
        assertEquals(canvas[1][1], null)
    }
    @Test
    fun testCanvasPrint(){
        testMakeCanvasBlank()
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
                    print(canvas[i][j - 1])
                }
            }
            println()
        }

        // footer --------
        for (j in 0 until width + 2) {
            print("-")
        }
        println("\n")
        assertEquals(canvas[1][1], " ")
    }
    @Test
    fun testMakeCanvasBlank(){
        for (i in 0 until height) {
            for (j in 0 until width) {
                canvas[i][j] = " "
            }
        }
        assertEquals(canvas[1][1], " ")
    }
    @Test
    fun testEmptyCanvas() {

        val result = sampleCanvas.getCanvas(1,2)
        AssertJUnit.assertEquals(empty, result)
        sampleCanvas.printCanvas()

    }
    @Test
    fun testIsNotEmptyCanvas(){
        sampleCanvas.drawLine(1, 2, 6, 2)
        val result = sampleCanvas.getCanvas(1,2)
        AssertJUnit.assertNotSame(empty,result)
    }
    @Test
    fun testIsDrawn(){
        sampleCanvas.drawLine(1, 2, 6, 2)
        val result = sampleCanvas.getCanvas(1,2)
        AssertJUnit.assertEquals(drawn,result)
    }
    @Test
    fun testIsHLine(){
        sampleCanvas.drawLine(1, 2, 6, 2)

        for(i in 0..5){
            val result = sampleCanvas.getCanvas(1,i)
            AssertJUnit.assertEquals(drawn,result)

        }
    }
    @Test
    fun testIsVLine(){
        sampleCanvas.drawLine(6,3,6,4)

        for(i in 1..3){
            val result = sampleCanvas.getCanvas(i,5)
            AssertJUnit.assertEquals(drawn,result)

        }


    }

    @Test
    fun testIsRectangle() {
        sampleCanvas.drawRectangle(16,1,20,3)

        for (i in 0 until 5) {
            for (j in 0 until 20) {

                if (j + 1 in 16..20 && (i + 1 == 1 || i + 1 == 3)) {
                   val result=  sampleCanvas.getCanvas(i,j)
                    AssertJUnit.assertEquals(drawn,result)
                }


                if (i + 1 in 1..3 && (j + 1 ==16 || j + 1 == 20)) {
                    val result=  sampleCanvas.getCanvas(i,j)
                    AssertJUnit.assertEquals(drawn,result)
                }
            }
        }
    }
}


