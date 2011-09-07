package lists

/**
 * Finds the Kth element of a list.
 *
 * @author rawlatv@gmail.com (Vishal Talwar)
 */
object Problem3 {

  def kth[A]( k : Int, l : List[A] ) = {
    l( k )
  }

  def main( args : Array[String] ) {
    assert( kth( 0, List( 0, 1, 2 ) ) == 0, "integer list" )
    assert( kth( 1, List( 1.1, 2.2, 3.3 ) ) == 2.2, "float list" )
    assert( kth( 2, List( "foo", "bar", "baz" ) ) == "baz", "string list" )
    println( "all passed!" )
  }
}
