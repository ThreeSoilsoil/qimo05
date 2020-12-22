package com.example.qimo.settingfragment

import android.content.ContentValues
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.qimo.GameSQlite
import com.example.qimo.R
import com.example.qimo.TABLE_NAME
import com.example.qimo.TABLE_NAME2
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_setting.*


class SettingFragment : Fragment() {
    lateinit var db: SQLiteDatabase

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        button_mstart.setOnClickListener {
            val intent= Intent(activity,MusicActivity::class.java)
            startActivity(intent)
        }

        val openSqLiteHelper = this.context?.let { GameSQlite(it,2 ) }
        if (openSqLiteHelper != null) {
             db = openSqLiteHelper.writableDatabase
        }
        button_changeName.setOnClickListener {
           val playername=editTextName.text.toString()
            val cursor = db.query(TABLE_NAME2,null,null,null,null,null,null)
                    val contentValues = ContentValues().apply {
                        put("gameId",playername)
                    }
            db.update(TABLE_NAME2,contentValues,null, null)
            Toast.makeText(this.context,"修改成功", Toast.LENGTH_SHORT).show()
        }

    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_setting, container, false)
    }


}