package tikkeulmoa.cimile.org.model

data class GetAccountListResponse (
    val status: Int,
    val message: String,
    val data: ArrayList<AccountData>
)

data class AccountData(
    val idx: Int,
    val acount_number: String,
    val name: String,
    val master_idx: Int,
    val price: Int,
    val exist: Int
)