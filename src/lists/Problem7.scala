package lists

/** Flatten a nested list structure.
 *
 *  @author rawlatv@gmail.com (Vishal Talwar)
 */
object Problem7 {

  def flatten1( l: List[Any] ): List[Any] = l match {
    case Nil                         => Nil
    // TODO(indraastra): investigate compiler warning about "erasure".
    case ( head: List[Any] ) :: rest => flatten1( head ) ::: flatten1( rest )
    case head :: rest                => head :: flatten1( rest )
  }
  
  //ls.foldLeft((acc : List[Any], l : List[Any]) => acc ::: l)

  def main( args: Array[String] ) {
    val solutions = List( flatten1 _ )
    for ( fn <- solutions ) {
      assert(
        fn( List( List( 1, 1 ), 2, List( 3, List( 5, 8 ) ) ) ) ==
          List( 1, 1, 2, 3, 5, 8 ), "uniform list" )
      assert(
        fn( List( List( "abc", 1 ), 2, List( "foo", List( 5, 8.01 ) ) ) ) ==
          List( "abc", 1, 2, "foo", 5, 8.01 ), "mixed list" )
    }
    println( "all passed!" )
  }
}
