package tikkeulmoa.cimile.org.ui.account.adapter

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_rcv_account_detail.view.*
import tikkeulmoa.cimile.org.R
import tikkeulmoa.cimile.org.model.GetDpsAndWtdrListResponseData

class AccountDetailAdapter(val ctx : Context, var dataList:ArrayList<GetDpsAndWtdrListResponseData>) : RecyclerView.Adapter<AccountDetailAdapter.Holder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {

        val view: View = LayoutInflater.from(ctx).inflate(R.layout.item_rcv_account_detail,parent,false)
        return Holder(view)
    }

    override fun getItemCount(): Int = dataList.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.date.text = dataList[position].date
        if(dataList[position].is_in==1){
            //입금
            holder.is_in.text = "입금"
            holder.is_in.setTextColor(Color.parseColor("#3672d3"))
            holder.is_in_money.setTextColor(Color.parseColor("#3672d3"))
            holder.is_in_money.text = dataList[position].price
            holder.won.setTextColor(Color.parseColor("#3672d3"))

        }else{
            //출금
            holder.is_in.text = "출금"
            holder.is_in.setTextColor(Color.parseColor("#67b385"))
            holder.is_in_money.setTextColor(Color.parseColor("#67b385"))
            holder.is_in_money.text = dataList[position].price
            holder.won.setTextColor(Color.parseColor("#67b385"))

        }
        holder.total_money.text = dataList[position].balance
        holder.memo.text = dataList[position].memo



    }

    inner class Holder(itemView : View) : RecyclerView.ViewHolder(itemView){
        var date = itemView.findViewById(R.id.account_detail_date) as TextView
        var name = itemView.findViewById(R.id.account_user_name) as TextView
        var memo = itemView.findViewById(R.id.account_user_memo) as TextView
        var is_in = itemView.findViewById(R.id.account_deposit_text) as TextView
        var won = itemView.findViewById(R.id.won) as TextView
        var is_in_money = itemView.findViewById(R.id.account_deposit_money) as TextView
        var total_money = itemView.findViewById(R.id.account_total_money) as TextView
    }
}