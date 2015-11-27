package com.bthuillier.vdm

import org.scalatest.{ Matchers, WordSpec }
import akka.http.scaladsl.model.StatusCodes
import akka.http.scaladsl.testkit.ScalatestRouteTest
import akka.http.scaladsl.server._
import Directives._
import org.joda.time.DateTime

class VDMSpec extends WordSpec with Matchers with ScalatestRouteTest {

  val fakePostService =
    new ConcretePostService(List(
      VDMPost(1, "test", "test", new DateTime),
      VDMPost(2, "test", "test", new DateTime),
      VDMPost(3, "test", "test", new DateTime),
      VDMPost(4, "test", "test", new DateTime)))

  val route = new VDMRouting {}.postRoute(fakePostService)


  "The service" should {

    "return the list of posts when calling '/api/posts'" in {
      // tests:
      Get("/api/posts") ~> route ~> check {
        status shouldEqual StatusCodes.OK
      }
    }

    "return the list of posts filtered by author when calling '/api/posts?author=test'" in {
      // tests:
      Get("/api/posts?author=test") ~> route ~> check {
        status shouldEqual StatusCodes.OK
      }
    }

    "return the list of posts filtered by date" in {
      // tests:
      Get("/api/posts?from=2014-01-01&to=2014-01-01") ~> route ~> check {
        status shouldEqual StatusCodes.OK
      }
    }

    "return an error if only one parameter between from and to is defined" in {
        // tests:
        Get("/api/posts?from=2014-01-01") ~> route ~> check {
          handled shouldEqual false
        }

        Get("/api/posts?to=2014-01-01") ~> route ~> check {
          handled shouldEqual false
        }
    }

    "return an existing post when calling it with his id '/api/posts/{id}'" in {
      // tests:
      Get("/api/posts/1") ~> route ~> check {
        status shouldEqual StatusCodes.OK
      }
    }

    "return a 404 NotFound Response when trying to retrieve a non existing post" in {
      // tests:
      Get("/api/posts/10") ~> route ~> check {
        status shouldEqual StatusCodes.NotFound
      }
    }
  }
}
