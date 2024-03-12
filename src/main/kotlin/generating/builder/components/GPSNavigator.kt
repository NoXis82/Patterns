package generating.builder.components

class GPSNavigator() {
    private var route: String = "221b, Baker Street, London  to Scotland Yard, 8-10 Broadway, London"

    constructor(manualRoute: String) : this() {
        this.route = manualRoute
    }

    fun getRoute(): String {
        return route
    }

}