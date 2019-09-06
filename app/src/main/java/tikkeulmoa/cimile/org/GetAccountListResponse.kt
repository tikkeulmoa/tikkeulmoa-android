package tikkeulmoa.cimile.org

data class GetAccountListResponse (
    val status: Int,
    val message: String,
    val data: accountData
)

data class accountData(
    val idx: Int,
    val num: String,
    val name: String,
    val master_idx: Int,
    val price: Int,
    val commu_flag: Int
)