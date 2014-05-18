package codeforces

import scala.collection.mutable.ArrayBuffer
import scala.util.control.Breaks._
import scala.annotation.tailrec

/**
 * @author zhouqianli
 *         from [[http://codeforces.com/problemset/problem/388/A]]
 *         Input
 *         The first line contains . The next line contains n integers x1, x2, ..., xn (0 ≤ xi ≤ 100).
 *         Output
 *         Output a single integer — the minimal possible number of piles.
 */
object FoxAndBoxAccumulation {
  /**
   * Fox Ciel wants to construct piles from all the boxes. Each pile will contain some boxes from top to bottom,
   * and there cannot be more than xi boxes on the top of i-th box. What is the minimal number of piles she needs to construct?
   * @param xn n integers x1, x2, ..., xn (0 ≤ xi ≤ 100)
   * @return  a single integer — the minimal possible number of piles. -1 means no pile can created
   */
  def get(xn: Array[Int]): Int = {
    val pilePool = new PilePool
    if (xn.length - 1 < 0 || xn.length > 100) throw new InvalidParameterException("0 ≤ xi ≤ 100")
    xn.foreach(pilePool.append)
    pilePool.size()
  }


  class PilePool {
    private val pool = new ArrayBuffer[Pile]

    @tailrec private def searchPosition(item: Int, index: Int = 0): Unit = {
      if (index == pool.length) return
      else if (!pool(index).append(item))
        searchPosition(item, index + 1)
    }

    def size() = pool.length

    def append(item: Int) {
      if (pool.isEmpty) pool += new Pile()
      else if (item == 0) {
        val pile = new Pile()
        pile.append(item)
        pool += pile
      }
      else searchPosition(item)
    }
  }

  class Pile {
    val itemList = new ArrayBuffer[Int]

    def append(item: Int): Boolean = {
      if (itemList.length <= item) {
        itemList += item
        true
      }
      else false
    }
  }

  case class InvalidPileException(str: String) extends Exception

  case class InvalidParameterException(str: String) extends Exception

}
