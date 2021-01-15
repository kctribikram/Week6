package com.example.week6.Adapter


import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.week6.DashboardActivity
import com.example.week6.Fragments.HomeFragment
import com.example.week6.Models.User
import com.example.week6.R
import de.hdodenhof.circleimageview.CircleImageView

class UserAdapter(
        val lstUser:ArrayList<User>,
        val context: Context

) :RecyclerView.Adapter<UserAdapter.ActivityViewHolder>() {
    class ActivityViewHolder(view: View):
            RecyclerView.ViewHolder(view){
        val imgProfile:CircleImageView
        val tvName:TextView
        val tvAddress:TextView
        val tvAge:TextView
        val tvGender:TextView
        val delete:ImageView

        init{
            imgProfile=view.findViewById(R.id.imgProfile)
            tvName=view.findViewById(R.id.tvName)
            tvAddress=view.findViewById(R.id.tvAddress)
            tvAge=view.findViewById(R.id.tvAge)
            tvGender=view.findViewById(R.id.tvGender)
            delete=view.findViewById(R.id.delete)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActivityViewHolder {
        val view=LayoutInflater.from(parent.context)
                .inflate(R.layout.userview,parent,false)
        return ActivityViewHolder((view))
    }



    override fun onBindViewHolder(holder: ActivityViewHolder, position: Int) {
        val user=lstUser[position]
        holder.tvName.text=user.name
        holder.tvAge.text=user.age
        holder.tvAddress.text=user.address
        holder.tvGender.text=user.gender
        Glide.with(context)
                .load(user.image)
                .into(holder.imgProfile)
        holder.delete.setOnClickListener {
            lstUser.removeAt(position)
            val intent=Intent(context,DashboardActivity::class.java)
            context.startActivity(intent)
        }

    }
    override fun getItemCount(): Int {
        return lstUser.size
    }

}