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
import tikkeulmoa.cimile.org.model.AccountData
import tikkeulmoa.cimile.org.ui.account.AccountDetailActivity
import tikkeulmoa.cimile.org.ui.community.CommunityDetailActivity
import tikkeulmoa.cimile.org.ui.community.CommunityMakingActivity

class MainRecyclerViewAdapter(val ctx: MainActivity, var dataList: ArrayList<AccountData>): RecyclerView.Adapter<MainRecyclerViewAdapter.Holder>(){
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): Holder {
        val view: View = LayoutInflater.from(ctx).inflate(R.layout.rv_item_main_account,viewGroup,false)
        return Holder(view)
    }

    override fun getItemCount(): Int = dataList.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.account_num.text = dataList[position].acount_number
        holder.account_name.text = dataList[position].name
        holder.account_balance.text = dataList[position].price.toString()
        holder.btn_account.setOnClickListener {
            ctx.startActivity<AccountDetailActivity>("group_idx" to dataList[position].idx,
                "account_num" to dataList[position].acount_number,
                "account_name" to dataList[position].name,
                "account_money" to dataList[position].price)
            ctx.finish()

        }
        if(dataList[position].exist == 0){
            holder.non_exist.visibility = View.VISIBLE
            holder.exist.visibility = View.GONE
            holder.btn_community.setOnClickListener {
                ctx.startActivity<CommunityMakingActivity>("group_idx" to dataList[position].idx)
            }
        } else if(dataList[position].exist == 1){
            holder.non_exist.visibility = View.GONE
            holder.exist.visibility = View.VISIBLE
            holder.btn_community.setOnClickListener {
                ctx.startActivity<CommunityDetailActivity>("group_idx" to dataList[position].idx)
            }
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