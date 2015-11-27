package com.bthuillier.vdm

import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormat

case class VDMPost(id: Long, content: String, author: String, date: DateTime)

case class Posts(count: Long, posts: List[VDMPost])

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
