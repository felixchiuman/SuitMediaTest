package com.felix.suitmedia.ui.third

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.felix.suitmedia.databinding.ItemContentBinding
import com.felix.suitmedia.model.GetListUserResponse
import com.felix.suitmedia.model.userData

class ThirdPageAdapter (private val onItemClick: OnClickListener) : RecyclerView.Adapter<ThirdPageAdapter.ViewHolder>() {
    private val diffCallback = object : DiffUtil.ItemCallback<userData>(){
        override fun areItemsTheSame(
            oldItem: userData,
            newItem: userData
        ): Boolean = oldItem.id == newItem.id

        override fun areContentsTheSame(
            oldItem: userData,
            newItem: userData
        ): Boolean = oldItem.hashCode() == newItem.hashCode()
    }

    private val differ = AsyncListDiffer(this, diffCallback)

    fun submitData(value: List<userData>?) = differ.submitList(value)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ThirdPageAdapter.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(ItemContentBinding.inflate(inflater, parent,false))
    }

    override fun onBindViewHolder(holder: ThirdPageAdapter.ViewHolder, position: Int) {
        val data = differ.currentList[position]
        data.let { holder.bind(data) }
    }

    override fun getItemCount(): Int = differ.currentList.size

    inner class ViewHolder(private val binding: ItemContentBinding) :
        RecyclerView.ViewHolder(binding.root){
        fun bind(data: userData){
            binding.apply {
                Glide.with(binding.root)
                    .load(data.avatar)
                    .centerCrop()
                    .circleCrop()
                    .into(binding.ivAvatar)
                binding.tvFirst.text = data.firstName.toString()
                binding.tvLast.text = data.lastName.toString()
                binding.tvEmail.text = data.email.toString()
                root.setOnClickListener {
                    onItemClick.onClickItem(data)
                }
            }
        }
    }
    interface OnClickListener{
        fun onClickItem(data: userData)
    }
}