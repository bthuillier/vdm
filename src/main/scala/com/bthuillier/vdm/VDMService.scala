package com.bthuillier.vdm

import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormat
import play.api.libs.json._
import play.api.data.validation.ValidationError
import scala.util.Try

case class PostResponse(post: VDMPost)

object PostResponse {
  implicit val postResponseFormat: Format[PostResponse] = Json.format[PostResponse]
}

case class VDMPost(id: Long, content: String, author: String, date: DateTime)

object VDMPost {
  implicit val readsDateTime: Reads[DateTime] =
    Reads.StringReads.collect(ValidationError("error.expected.date-time"))(Function.unlift(n ⇒ Try(jsonDateTimeFormatter.parseDateTime(n)).toOption))

  implicit val writesDateTime: Writes[DateTime] = Writes[DateTime] {
    v ⇒ JsString(v.toString(jsonDateTimeFormatter))
  }

  implicit val vDMPostFormat: Format[VDMPost] = Json.format[VDMPost]

  val jsonDateTimeFormatter = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss")



  //implicit val dateFormat: Format[DateTime] =
}

case class Posts(count: Long, posts: List[VDMPost])

object Posts {
  implicit val postsFormat: Format[Posts] = Json.format[Posts]
}

trait PostService {

  def findPostById(id: Long): Option[VDMPost] =
    all.find(_.id == id)

  def all: List[VDMPost]

  def filterBy(filters: List[VDMPost => Boolean]): Posts = {
    val filteredPosts = all.filter(PostService.composeFilter(filters))
    Posts(filteredPosts.size, filteredPosts)
  }
}

class ConcretePostService(override val all: List[VDMPost]) extends PostService

object PostService {

  val dateTimeFormatter = DateTimeFormat.forPattern("dd/MM/yyyy 'à' HH:mm")

  private val emptyFilter: VDMPost => Boolean =
    _ => true

  def authorFilter(author: String): VDMPost => Boolean =
    post => post.author == author

  def dateFilter(from: DateTime, to: DateTime): VDMPost => Boolean =
    post => post.date.isAfter(from)  && post.date.isBefore(to)

  def composeFilter(filters: List[VDMPost => Boolean]): VDMPost => Boolean =
    post => filters.foldLeft(emptyFilter(post))(_ && _(post))

}
