package lists

/**
 * Pack consecutive duplicates of list elements into sublists.
 *
 * @author rawlatv@gmail.com (Vishal Talwar)
 */
object Problem9 {

  def pack[A]( l: List[A] ): List[List[A]] = ( l :\ List[List[A]]() ) {
    ( x, xs ) =>
      if ( !xs.isEmpty && x == xs.head.head )
        ( x :: xs.head ) :: xs.tail
      else
        List( x ) :: xs
  }
  
  def main( args: Array[String] ): Unit = {
    assert(
      pack( List( 'a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e ) ) ==
        List( List( 'a, 'a, 'a, 'a ), List( 'b ), List( 'c, 'c ), List( 'a, 'a ), List( 'd ),
          List( 'e, 'e, 'e, 'e ) ) )
    println( "all passed!" )
  }
}