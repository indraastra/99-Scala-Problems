package lists

/**
 * Find the number of elements of a list
 *
 * @author rawlatv@gmail.com (Vishal Talwar)
 */
object Problem4 {

  def length[A]( l : List[A] ) : Int = {
    // Trivial to do it using l.length, so let's do it recursively instead.
    1 + length(l.tail)
  }

  def main( args : Array[String] ) {
    assert( length( List( 0 ) ) == 1, "integer list" )
    assert( length( List( 1.1, 2.2 ) ) == 2, "float list" )
    assert( length( List( "foo", "bar", "baz") ) == 3, "string list" )
    println( "all passed!" )
  }
}