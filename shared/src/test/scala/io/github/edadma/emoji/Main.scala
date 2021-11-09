package io.github.edadma.emoji

import io.github.edadma.cross_platform.readFile
import io.github.edadma.json.JSONReader

object Main extends App {

  val json = readFile("test.json")

  JSONReader
  println(json)

}
