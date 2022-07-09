package com.nyller.android.kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.*
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import com.nyller.android.kotlin.adapter.AdapterHabitos
import com.nyller.android.kotlin.models.Habito

class MainActivity : AppCompatActivity() {
    // lateinit tem uma inicialização atrasada na activity
    private lateinit var adapterHabitos : AdapterHabitos
    private lateinit var recyclerView : RecyclerView
    private lateinit var habitosArrayList : ArrayList<Habito>
    private lateinit var db : FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Configurar Recycler
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

        habitosArrayList = arrayListOf()

        adapterHabitos = AdapterHabitos(habitosArrayList)

        recyclerView.adapter = adapterHabitos

        EventChangeListener()

    }

    private fun EventChangeListener() {
        db = FirebaseFirestore.getInstance()
        db.collection("habitos")
            .addSnapshotListener(object : EventListener<QuerySnapshot>{
                override fun onEvent(value: QuerySnapshot?, error: FirebaseFirestoreException?) {
                    if (error != null){
                        Log.e("Firestore erro", error.message.toString())
                        return
                    }
                    for (dc : DocumentChange in value?.documentChanges!!){
                        if (dc.type == DocumentChange.Type.ADDED){
                            habitosArrayList.add(dc.document.toObject(Habito::class.java))
                        }
                    }
                    adapterHabitos.notifyDataSetChanged()

                }
            })
    }
}