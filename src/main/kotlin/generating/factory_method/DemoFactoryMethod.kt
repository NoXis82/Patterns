package generating.factory_method

fun main() {
    val dialog = if (System.getProperty("os.name").equals("Windows 10")) {
        WindowsDialog()
    } else {
        HtmlDialog()
    }
    dialog.renderWindow()
}

