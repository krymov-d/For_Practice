package kz.kd.for_practice

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import kz.kd.for_practice.api.UserRetrofitBuilder
import kz.kd.for_practice.model.User
import kz.kd.for_practice.rv.UserAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var rvMain: RecyclerView
    private lateinit var rvLayoutManager: LinearLayoutManager
    private lateinit var rvAdapter: UserAdapter
    private lateinit var temporaryList: List<User>
    private lateinit var btnUpdate: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRV()
        initBtnUpdate()
        getUserList()
    }

    private fun initRV() {
        rvMain = findViewById(R.id.rv_main)
        rvLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rvAdapter = UserAdapter(layoutInflater)

        rvMain.adapter = rvAdapter
        rvMain.layoutManager = rvLayoutManager
    }

    private fun initBtnUpdate() {
        btnUpdate = findViewById(R.id.btn_update)
        btnUpdate.setOnClickListener {
            rvAdapter.setUsers(temporaryList)
        }
    }

    private fun getUserList() {
        MainScope().launch(Dispatchers.IO) {
            temporaryList = UserRetrofitBuilder.apiService.getUsers()
        }
    }
}