import java.util.*



fun main() {
    var width = 0
    var height = 0
    var exit = false
    val sc = Scanner(System.`in`)
    print("Insert command: ")
    var line = sc.nextLine()
    line = line.trim()
    val sp = line.split("\\s+".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray() //one or more space
    if (sp[0] == "c") {
        width = sp[1].toInt()
        height = sp[2].toInt()

    }
    var test = Canvas(width, height)
    test.printCanvas()
    print("Insert command: ")

    line = sc.nextLine()
    line = line.trim()
    while (!exit) {
        val cmd = line.split("\\s+".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
        if (cmd[0] == ("l")) {
            test.drawLine(cmd[1].toInt(), cmd[2].toInt(), cmd[3].toInt(), cmd[4].toInt())
            print("Insert command: ")
            line = sc.nextLine()
        }
        if (cmd[0] == ("r")) {
            test.drawRectangle(cmd[1].toInt(), cmd[2].toInt(), cmd[3].toInt(), cmd[4].toInt())
            print("Insert command: ")
            line = sc.nextLine()
        }
        if (cmd[0] == "q") {
            exit = true
            test.quitCanvas()
            sc.close()

        }


    }
}


