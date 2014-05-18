package ctci.chapter1

import org.scalatest.FlatSpec
import StringExtensions._

/**
 * Created by zhouzh on 2/8/14.
 */
class StringExTest extends FlatSpec {
  "The areAllCharUnique method" should "return true when input is empty" in {
    assert("".areAllCharUnique == true)
  }

  it should "return true when input only have on character" in {
    assert("a".areAllCharUnique == true)
  }

  it should "return true when input is unique" in {
    assert("1234567 ".areAllCharUnique == true)
  }

  it should "return false when input have duplicate character" in {
    assert(" aa".areAllCharUnique == false)
  }

  "The areAllCharUniqueWithNoDataStructure method" should "return true when input is empty" in {
    assert("".areAllCharUniqueWithNoDataStructure == true)
  }

  it should "return true when input only have on character" in {
    assert("a".areAllCharUniqueWithNoDataStructure == true)
  }

  it should "return true when input is unique" in {
    assert("1234567 ".areAllCharUniqueWithNoDataStructure == true)
  }

  it should "return false when input have duplicate character" in {
    assert(" aa".areAllCharUniqueWithNoDataStructure == false)
  }


  "The isAnagrams method" should "return false if two string have different length" in {
    assert("aba".isAnagrams("ab") == false)
  }

  it should "return true if inputs are same string" in {
    assert("aaa".isAnagrams("aaa") == true)
  }
  it should "return false if inputs are aaa & aba" in {
    assert("aaa".isAnagrams("aba") == false)
  }
  it should "return true if inputs are abab & baba" in {
    assert("abab".isAnagrams("baba") == true)
  }

}
