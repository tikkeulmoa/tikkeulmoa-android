package tikkeulmoa.cimile.org.model

data class GetDpsAndWtdrListResponseData (
   val idx : Int,
   val user_idx : Int,
   val groups_idx : Int,
   val price : String,
   val balance : String,
   val is_in : Int,
   val memo : String,
   val date : String

)