package ctci.chapter1

import scala.collection.BitSet

/**
 * Arrays and strings
 */

object StringExtensions {
  implicit def stringWrapper(string: String) = new StringExtensions(string)

  class StringExtensions(str: String) {

    /**
     * 1.1.1 Implement an algorithm to determine if a string has all unique characters.
     * @return if the input string are all unique characters
     */
    def areAllCharUnique: Boolean = {
      val checker = new Array[Int](256) // increase the array size if we have large character set
      str.foreach(c => {
        if ((checker(c) & 1) > 0)
          return false
        else checker(c) |= 1
      })
      true
    }

    /**
     * 1.1.1 Implement an algorithm to determine if a string has all unique characters. What if you can not use additional data structures?
     * @return if the input string are all unique characters
     */
    def areAllCharUniqueWithNoDataStructure: Boolean = {
      for (i <- 1 to str.length - 1)
        for (j <- i + 1 to str.length - 1)
          if (str(i) == str(j))
            return false
      true
    }

    /**
     * 1.4 Write a method to decide if two strings are anagrams or not.
     * @param right operator
     * @return if those two are anagrams or not
     */
    def isAnagrams(right: String): Boolean = {
      if (str.length != right.length) return false
      for (i <- 0 to (str.length - 1) / 2)
        if (str(i) != right(right.length - i - 1))
          return false
      true
    }
  }

}

