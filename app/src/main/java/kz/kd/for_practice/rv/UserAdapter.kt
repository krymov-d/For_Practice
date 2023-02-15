package kz.kd.for_practice.rv

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kz.kd.for_practice.R
import kz.kd.for_practice.model.User

class UserAdapter(private val layoutInflater: LayoutInflater) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var userList: MutableList<User> =
        mutableListOf(User("007", "Classified", "bond@agent007", "James Bond"))

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = layoutInflater.inflate(R.layout.user_card, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as UserViewHolder).bind(userList[position])
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setUsers(apiUserList: List<User>) {
        userList.clear()
        userList = apiUserList as MutableList<User>
        notifyDataSetChanged()
    }
}