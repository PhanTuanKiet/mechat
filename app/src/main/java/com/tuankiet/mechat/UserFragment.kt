package com.tuankiet.mechat

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import com.tuankiet.mechat.database.RealmHelper
import com.tuankiet.mechat.database.UserInfo
import kotlinx.android.synthetic.main.fragment_user.*




class UserFragment : Fragment() {

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_user, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fab.setOnClickListener {
            showDialog()
        }
    }

    fun showDialog(){
        val layoutInflater = getLayoutInflater()
        val DialogView = layoutInflater.inflate(R.layout.layout_add_user_dialog, null)
        val edtAvatar = DialogView.findViewById<EditText>(R.id.edtAvatar)
        val edtName = DialogView.findViewById<EditText>(R.id.edtUsername)

        val alertDialog : AlertDialog.Builder = AlertDialog.Builder(context)
        alertDialog.setView(DialogView)
        alertDialog.setNegativeButton("Cancel") { dialog, which ->

        }
        alertDialog.setPositiveButton("Add") { dialog, which ->
            AddUser(edtAvatar.text.toString(), edtName.text.toString())
        }
        val dialog = alertDialog.create()
        dialog.show()
    }

    fun AddUser(avatar : String, name : String){
        val helper = RealmHelper()
        val currentRealm = helper.getRealmInstance()
        currentRealm.executeTransaction {
            val currentIdNum = it.where(UserInfo::class.java).max("id")
            val nextId : Int
            if (currentIdNum == null)
                nextId = 1
            else
                nextId = currentIdNum.toInt() + 1
            var user = UserInfo(nextId.toLong(), name, avatar)
            it.copyToRealm(user)
        }
    }
}