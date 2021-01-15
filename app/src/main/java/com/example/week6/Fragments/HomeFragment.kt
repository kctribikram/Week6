package com.example.week6.Fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.week6.Adapter.UserAdapter
import com.example.week6.Models.User
import com.example.week6.R

private var lstActors=ArrayList<User>()
class HomeFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private var storage=AddFragment()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_home, container, false)
        recyclerView=view.findViewById(R.id.recyclerView)
        val arr = storage.getUsers()
        val adapter= UserAdapter(arr, view.context)
        recyclerView.layoutManager=LinearLayoutManager(context)
        recyclerView.adapter=adapter



        return view
    }



}