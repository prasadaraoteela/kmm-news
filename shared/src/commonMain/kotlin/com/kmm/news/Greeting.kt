package com.kmm.news

class Greeting {
  fun greeting(): String {
    return "Hello, ${Platform().platform}!"
  }
}