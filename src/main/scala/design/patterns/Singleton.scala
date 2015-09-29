package design.patterns

object Singleton {
  private var username = ""
  private var password = ""
  private var _isConnected = false

  def apply(username: String, password: String): Unit = {
    this.username = username
    this.password = password
    this._isConnected = true
    println(s"connect to database by: ${this.username} / ${this.password}.")
  }

  def isConnected: Boolean = this._isConnected
}

object Main {
  def main(args: Array[String]) = {
    println(s"isConnected: ${Singleton.isConnected}")
    Singleton("hello", "world")
    println(s"isConnected: ${Singleton.isConnected}")
  }
}