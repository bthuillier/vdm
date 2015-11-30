package com.bthuillier.vdm

import org.scalatest.{ Matchers, WordSpec }
import org.jsoup.Jsoup
import org.joda.time.DateTime

class PostServiceSpec extends WordSpec with Matchers with PostService {

  val post1 = VDMPost(1, "content1", "author1", new DateTime(2015, 1, 1, 1, 1, 1))

  override def all: List[VDMPost] = List(
      post1,
      VDMPost(1, "content1", "author2", new DateTime(2016, 1, 1, 1, 1, 1)),
      VDMPost(1, "content1", "author3", new DateTime(2016, 1, 1, 1, 1, 1))
  )

  "the post service" should {

    "correctly don't filter with no filter" in {
      filterBy(List()).posts shouldEqual all
    }

    "correctly filter by author" in {
      filterBy(List(PostService.authorFilter("author1"))).posts.forall(_.author == "author1") shouldEqual true
    }

    "correctly filter by date" in {
      val from = new DateTime(2015, 1, 1, 0, 0, 0)
      val to = new DateTime(2015, 12, 31, 23, 59, 0)
      filterBy(List(PostService.dateFilter(from, to))).posts.
        forall(p => p.date.isAfter(from) && p.date.isBefore(to)) shouldEqual true
    }

    "correctly find by id an existing post" in {
      findPostById(1) shouldEqual Some(post1)
    }

    "handle a non existing post id" in {
      findPostById(0) shouldEqual None
    }
  }
}
