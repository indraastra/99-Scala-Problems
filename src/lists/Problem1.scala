package lists

/**
 * Finds the last element of a list.
 *
 * @author rawlatv@gmail.com (Vishal Talwar)
 */
object Problem1 {

  def last[A]( l : List[A] ) = {
    l.last
  }

  def main( args : Array[String] ) {
    assert( last( List( 1 ) ) == 1, "integer list" )
    assert( last( List( 1.1, 2.2, 3.3 ) ) == 3.3, "float list" )
    assert( last( List( "foo", "bar" ) ) == "bar", "string list" )
    println( "all passed!" )
  }
}