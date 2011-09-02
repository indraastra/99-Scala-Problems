package lists

/**
 * Finds the last-but-one element of a list.
 *
 * @author rawlatv@gmail.com (Vishal Talwar)
 */
object Problem2 {

  def penultimate[A]( l : List[A] ) = {
    l(l.length - 2)
  }

  def main( args : Array[String] ) {
    assert( penultimate( List( 0, 1, 2 ) ) == 1, "integer list" )
    assert( penultimate( List( 1.1, 2.2, 3.3 ) ) == 2.2, "float list" )
    assert( penultimate( List( "foo", "bar", "baz") ) == "bar", "string list" )
    println( "all passed!" )
  }
}