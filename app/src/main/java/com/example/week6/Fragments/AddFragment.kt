package com.example.week6.Fragments

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.example.week6.DashboardActivity
import com.example.week6.Models.User
import com.example.week6.R
var users= ArrayList<User>()


class AddFragment : Fragment() {

    private lateinit var edtname: EditText
    private lateinit var edtage: EditText
    private lateinit var edtaddress: EditText
    private lateinit var edtimage:EditText
    private lateinit var rg: RadioGroup
    private lateinit var rdomale: RadioButton
    private lateinit var rdofemale: RadioButton
    private lateinit var rdoother: RadioButton
    private lateinit var btnsave: Button
    lateinit var gender:String;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add, container, false)
        edtname = view.findViewById(R.id.edtname)
        edtage = view.findViewById(R.id.edtage)
        edtaddress = view.findViewById(R.id.edtaddress)
        edtimage=view.findViewById(R.id.edtimage)
        rg = view.findViewById(R.id.rg)
        rdomale = view.findViewById(R.id.rdomale)
        rdofemale = view.findViewById(R.id.rdofemale)
        rdoother = view.findViewById(R.id.rdoother)
        btnsave = view.findViewById(R.id.btnsave)
        rg.setOnCheckedChangeListener(object :RadioGroup.OnCheckedChangeListener{
            override fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {
                when(checkedId)
                {
                    R.id.rdomale->{
                        gender="Male"
                    }
                    R.id.rdofemale->{
                        gender="Female"
                    }
                }
            }
        })
        rg.check(R.id.rdomale)

        btnsave.setOnClickListener {
            if (validateInput()) {
                val p = User(null, edtname.text.toString(), edtage.text.toString(), edtaddress .text.toString(),gender.toString(),edtimage.text.toString())
                users.add(p)
                val intent=Intent (context,DashboardActivity::class.java)
                startActivity(intent)

            } else {
                Toast.makeText(context, "Invalid Post", Toast.LENGTH_LONG).show()
            }
        }

        return view
    }
    public fun getUsers():ArrayList<User>{
        return users
    }

    private fun validateInput(): Boolean {
        var res = true
        when {
            (TextUtils.isEmpty(edtname.text))->{
                edtname.error = "This field should not be empty"
                edtname.requestFocus()
                res = false
            }

            (TextUtils.isEmpty(edtage.text)) ->{
                edtage.error = "This field should not be empty"
                edtage.requestFocus()
                res = false
            }
            (TextUtils.isEmpty(edtaddress.text)) ->{
                edtaddress.error = "This field should not be empty"
                edtaddress.requestFocus()
                res = false
            }

        }
        return res
    }




}