package codeforces

import org.scalatest.FlatSpec

/**
 * Created by zhouzh on 2/17/14.
 */
class FoxAndBoxAccumulationTest extends FlatSpec {
  "An fox and box accumulation method" should "return 1 when input=(1,1,2)" in
    assert(FoxAndBoxAccumulation.get(Array(1, 1, 2)) == 1)

  it should "return 2 when input=(0,0,10)" in
    assert(FoxAndBoxAccumulation.get(Array(0, 0, 10)) == 2)

  it should "return 1 when input=(0,1,2,3,4)" in
    assert(FoxAndBoxAccumulation.get(Array(0, 1, 2, 3, 4)) == 1)

  it should "return 4 when input=(0,0,0,0)" in
    assert(FoxAndBoxAccumulation.get(Array(0, 0, 0, 0)) == 4)

  it should "return 3 when input=(0, 1, 0, 2, 0, 1, 1, 2, 10)" in
    assert(FoxAndBoxAccumulation.get(Array(0, 1, 0, 2, 0, 1, 1, 2, 10)) == 3)
}
