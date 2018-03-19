package controllers

import javax.inject._

import models.UserInfoRepo
import play.api._
import play.api.mvc._
import users.UserForm

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

/**
  * This controller creates an `Action` to handle HTTP requests to the
  * application's home page.
  */
@Singleton
class HomeController @Inject()(userForm: UserForm, userInfoRepo: UserInfoRepo, cc: ControllerComponents) extends AbstractController(cc) {

  def index: Action[AnyContent] = Action.async { implicit request =>
    throw new Exception()
    Future.successful(Ok(views.html.index(userForm.userInfoForm)))
  }
  def storeData: Action[AnyContent] = Action.async {implicit request =>
    userForm.userInfoForm.bindFromRequest().fold(
      formWithErrors => {
        Future.successful(BadRequest(views.html.index(formWithErrors)))
      },
      data => {
        userInfoRepo.getUser(data.email).flatMap { optionalRecord =>
          optionalRecord.fold {
            val record = userInfoRepo.UserInfo(data.fname, data.lname, data.email)
            userInfoRepo.store(record)
            userInfoRepo.store(record).map { _ =>
              Ok("stored")
            }
          } { _ =>
            Future.successful(InternalServerError("user already exist."))
          }
        }
      })
  }

  def getData(email: String): Action[AnyContent] = Action.async {

    userInfoRepo.getUser(email).map { optionalRecord =>
      optionalRecord.fold {
        NotFound("User Not Found!")
      } { record =>
        Ok(s"User's Fullname = ${record.fname} ${record.lname} ")
      }
    }

  }

  /**
    * Create an Action to render an HTML page.
    *
    * The configuration in the `routes` file means that this method
    * will be called when the application receives a `GET` request with
    * a path of `/`.
    */
  /*def index() = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.index())
  }*/
}
