package generating.factory_method

/**
 * HTML-диалог.
 */
class HtmlDialog(): Dialog() {

    override fun createButton(): Button {
        return HtmlButton()
    }
}