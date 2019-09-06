package tikkeulmoa.cimile.org.model

data class GetDpsAndWtdrListResponse (

    val status : Int,
    val message : String,
    val data : ArrayList<GetDpsAndWtdrListResponseData>

)