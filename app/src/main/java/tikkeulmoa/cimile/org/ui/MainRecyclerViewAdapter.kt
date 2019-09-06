package tikkeulmoa.cimile.org.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.jetbrains.anko.startActivity
import tikkeulmoa.cimile.org.R
import tikkeulmoa.cimile.org.model.accountData
import tikkeulmoa.cimile.org.ui.account.AccountDetailActivity

class MainRecyclerViewAdapter(val ctx: Context, var dataList: ArrayList<accountData>): RecyclerView.Adapter<MainRecyclerViewAdapter.Holder>(){
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): MainRecyclerViewAdapter.Holder {
        val view: View = LayoutInflater.from(ctx).inflate(R.layout.rv_item_main_account,viewGroup,false)
        return Holder(view)
    }

    override fun getItemCount(): Int = dataList.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.account_num.text = dataList[position].num
        holder.account_name.text = dataList[position].name
        holder.account_balance.text = dataList[position].price.toString()
        holder.btn_account.setOnClickListener {
            //ctx.startActivity<CommunityDetailActivity>("group_idx" to dataList[position].idx)
        }
        if(dataList[position].commu_flag == 0){
            holder.non_exist.visibility = View.GONE
            holder.exist.visibility = View.VISIBLE
        } else if(dataList[position].commu_flag == 1){
            holder.non_exist.visibility = View.GONE
            holder.exist.visibility = View.VISIBLE
        }
        holder.btn_community.setOnClickListener {
            ctx.startActivity<AccountDetailActivity>("group_idx" to dataList[position].idx)
        }
    }

    inner class Holder(itemView:View): RecyclerView.ViewHolder(itemView) {
        var account_num = itemView.findViewById(R.id.tv_rv_item_main_account_num) as TextView
        var account_name = itemView.findViewById(R.id.tv_rv_item_main_account_name) as TextView
        var account_balance = itemView.findViewById(R.id.tv_rv_item_main_account_balance) as TextView
        var btn_account = itemView.findViewById(R.id.btn_rv_item_main_account_account) as RelativeLayout
        var btn_community = itemView.findViewById(R.id.btn_rv_item_main_account_community) as RelativeLayout
        var non_exist = itemView.findViewById(R.id.btn_rv_item_main_account_non_exist) as LinearLayout
        var exist = itemView.findViewById(R.id.btn_rv_item_main_account_exist) as TextView
    }
}