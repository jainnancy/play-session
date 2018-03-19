
package views.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

object index extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[Form[users.UserInformation],RequestHeader,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(user: Form[users.UserInformation])(implicit request: RequestHeader):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*2.2*/import helper._


Seq[Any](format.raw/*3.1*/("""
"""),_display_(/*4.2*/main("Welcome to Play")/*4.25*/ {_display_(Seq[Any](format.raw/*4.27*/("""
"""),format.raw/*5.1*/("""<h1 xmlns="http://www.w3.org/1999/html">Welcome to Play!</h1>

<form action=""""),_display_(/*7.16*/routes/*7.22*/.HomeController.storeData()),format.raw/*7.49*/("""" method="POST">

  """),_display_(/*9.4*/CSRF/*9.8*/.formField),format.raw/*9.18*/("""
  """),format.raw/*10.3*/("""First name:<input type="text" name="fname"/></br>
  Last name: <input type="text" name="lname"/></br>
  Email: <input type="email" name="email"/></br>
  <input type="submit" value="Submit">
</form>

""")))}),format.raw/*16.2*/("""
"""))
      }
    }
  }

  def render(user:Form[users.UserInformation],request:RequestHeader): play.twirl.api.HtmlFormat.Appendable = apply(user)(request)

  def f:((Form[users.UserInformation]) => (RequestHeader) => play.twirl.api.HtmlFormat.Appendable) = (user) => (request) => apply(user)(request)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Fri Mar 16 17:56:40 IST 2018
                  SOURCE: /home/knoldus/IdeaProjects/playsession/play-session/app/views/index.scala.html
                  HASH: f73400a790bf26b672fb1022a9441b55b80abdac
                  MATRIX: 764->1|905->71|949->87|976->89|1007->112|1046->114|1073->115|1177->193|1191->199|1238->226|1284->247|1295->251|1325->261|1355->264|1585->464
                  LINES: 21->1|24->2|27->3|28->4|28->4|28->4|29->5|31->7|31->7|31->7|33->9|33->9|33->9|34->10|40->16
                  -- GENERATED --
              */
          