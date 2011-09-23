package lists

/**
 * Reverses a list.
 *
 * @author rawlatv@gmail.com (Vishal Talwar)
 */
object Problem5 {

  def reverse[A]( l : List[A] ) : List[A] = {
    def reverseIter[A]( l : List[A], rl : List[A] ) : List[A] = {
      if (l.isEmpty) rl
      else reverseIter(l.tail, l.head :: rl)
    }
    reverseIter(l, List())
  }

  def main( args : Array[String] ) {
    assert( reverse( List( 0 ) ) == List( 0 ), "integer list" )
    assert( reverse( List( 1.1, 2.2 ) ) == List( 2.2, 1.1 ), "float list" )
    assert( reverse( List( "foo", "bar", "baz" ) ) == List( "baz", "bar", "foo" ), "string list" )
    println( "all passed!" )
  }
}
