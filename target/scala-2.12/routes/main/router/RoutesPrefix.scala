// @GENERATOR:play-routes-compiler
// @SOURCE:/home/knoldus/IdeaProjects/playsession/play-session/conf/routes
// @DATE:Fri Mar 16 17:56:40 IST 2018


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
