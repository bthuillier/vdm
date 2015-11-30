package com.bthuillier.vdm

import org.scalatest.{ Matchers, WordSpec }
import akka.http.scaladsl.model.StatusCodes
import akka.http.scaladsl.testkit.ScalatestRouteTest
import akka.http.scaladsl.server._
import Directives._
import org.joda.time.DateTime
import play.api.libs.json._
import de.heikoseeberger.akkahttpplayjson.PlayJsonSupport

class VDMSpec extends WordSpec with Matchers with ScalatestRouteTest with PlayJsonSupport {

  val post1 = VDMPost(1, "test", "author1", new DateTime(2015, 1, 1, 0, 0, 1))

  val fakePostService =
    new ConcretePostService(List(
      post1,
      VDMPost(2, "test", "author2", new DateTime(2015, 2, 1, 0, 0, 0)),
      VDMPost(3, "test", "author3", new DateTime(2015, 2, 1, 0, 0, 0)),
      VDMPost(4, "test", "author3", new DateTime(2015, 3, 1, 0, 0, 0))))

  val route = new VDMRouting {}.postRoute(fakePostService)


  "The service" should {

    "return the list of posts when calling '/api/posts'" in {
      // tests:
      Get("/api/posts") ~> route ~> check {
        status shouldEqual StatusCodes.OK
        responseAs[Posts].count shouldEqual 4
      }
    }

    "return the list of posts filtered by author when calling '/api/posts?author=author2'" in {
      // tests:
      Get("/api/posts?author=author2") ~> route ~> check {
        status shouldEqual StatusCodes.OK
        responseAs[Posts].count shouldEqual 1
      }
    }

    "return the list of posts filtered by date" in {
      // tests:
      Get("/api/posts?from=2015-01-01&to=2015-01-02") ~> route ~> check {
        status shouldEqual StatusCodes.OK
        responseAs[Posts].count shouldEqual 1
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
        responseAs[PostResponse].post shouldEqual post1
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
