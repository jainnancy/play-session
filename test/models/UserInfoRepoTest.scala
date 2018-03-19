package models

import akka.Done
import org.specs2.mutable.Specification
import play.api.Application
import play.api.inject.guice.GuiceApplicationBuilder

import scala.concurrent.Await
import scala.concurrent.duration.Duration
import scala.reflect.ClassTag

class ModelsTest[T: ClassTag] {

  def fakeApp : Application = {
    new GuiceApplicationBuilder().build()
  }

  lazy val app2doo = Application.instanceCache
  lazy val repository: T = app2doo(fakeApp)

}

class UserInfoRepoTest extends Specification{

  val repo = new ModelsTest[UserInfoRepo]

  //Test-suite
  "store user information" should {
    "store associate details of a user" in {
      val user = repo.repository.UserInfo("Nancy","jain","jain.nancy94@gmail.com")
      val storeResult = Await.result(repo.repository.store(user), Duration.Inf)
      storeResult must equalTo(Done)
    }
  }

}
