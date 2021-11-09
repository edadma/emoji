package io.github.edadma.emoji

import io.github.edadma.cross_platform.readFile
import io.github.edadma.json

import java.io.PrintStream
import scala.language.postfixOps

object Main extends App {

  val pairs =
    json.DefaultJSONReader.fromFile("emoji.json").asInstanceOf[json.Object].toList.asInstanceOf[List[(String, String)]]
  val CharRegex = ".*unicode/([0-9a-z]+)[.-].*".r
  val list =
    pairs flatMap {
      case (name, CharRegex(ch)) => List(s"    \"$name\" -> 0x$ch")
      case _                     => Nil
    }
  val out = new PrintStream("Emoji.scala")

  Console.withOut(out) {
    println("val emoji = ")
    println("  Map(")
    println(list mkString ",\n")
    println("  )")
  }

  out.close()

}
