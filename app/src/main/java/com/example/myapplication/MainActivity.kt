package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var mAdapter: RecyclerViewAdapter
    private lateinit var mModelList: ArrayList<Model>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mAdapter = RecyclerViewAdapter(getListData());
        val manager = LinearLayoutManager(this);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.layoutManager = manager;
        mRecyclerView.adapter = mAdapter;
    }

    private fun getListData(): List<Model> {
        mModelList = ArrayList<Model>();
        for (i in 1..25) {
            mModelList.add(Model("TextView $i"));
        }
        return mModelList;
    }
}
