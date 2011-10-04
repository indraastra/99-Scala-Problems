package lists

/**
 * Duplicate the elements of a list.
 *
 * @author rawlatv@gmail.com (Vishal Talwar)
 */
object Problem14 {

  def duplicate1[A]( l : List[A] ) : List[A] = {
    if ( l.isEmpty ) Nil
    else l.head :: l.head :: duplicate1( l.tail )
  }

  def main( args : Array[String] ) : Unit = {
    assert( duplicate1( List( 'a, 'b, 'c, 'c, 'd ) ) ==
      List( 'a, 'a, 'b, 'b, 'c, 'c, 'c, 'c, 'd, 'd ) )
    println( "all passed!" )
  }
}