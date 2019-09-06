package tikkeulmoa.cimile.org.model

data class PostDepositResponseData (
    val user_idx : Int,
    val groups_idx : Int,
    val price : Int,
    val memo : String
)