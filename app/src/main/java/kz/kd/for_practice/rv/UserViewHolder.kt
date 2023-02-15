package kz.kd.for_practice.rv

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kz.kd.for_practice.R
import kz.kd.for_practice.model.User

class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val userID: TextView = itemView.findViewById(R.id.user_id)
    private val userName: TextView = itemView.findViewById(R.id.user_name)
    private val userEmail: TextView = itemView.findViewById(R.id.user_email)

    fun bind(user: User) {
        userID.text = user.id
        userName.text = user.name
        userEmail.text = user.email
    }
}