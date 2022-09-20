package com.example.flowersshop.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.flowshop.R
import com.example.flowshop.data.Repository
import com.example.flowshop.pojo.items
import java.lang.Exception

class FlowerFragment : Fragment() {

    lateinit var recyclerView: RecyclerView
    lateinit var repositry: Repository
    lateinit var adapter: itemAdapter

    companion object {
        fun newInstance() = homeFragment()
        private const val TAG = "flowerFragment"
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_flower, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        try {
            recyclerView=view.findViewById(R.id.recycler_Backpack)
            recyclerView.layoutManager= LinearLayoutManager(context)
            adapter= context?.let { itemAdapter(it) }!!
            repositry= ViewModelProviders.of(this).get(Repository::class.java)
            repositry.getinfo_packpack().observe(viewLifecycleOwner, Observer<ArrayList<items>> { item->
                adapter.setlist(item)
                adapter.notifyDataSetChanged()
                recyclerView.adapter=adapter
            })
        }
        catch (e : Exception){
            Log.d(Companion.TAG, "onViewCreated: "+e.message)
        }

    }


}