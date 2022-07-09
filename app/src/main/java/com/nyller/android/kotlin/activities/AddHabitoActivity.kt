package com.nyller.android.kotlin.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.google.firebase.firestore.FirebaseFirestore
import com.nyller.android.kotlin.R
import kotlinx.android.synthetic.main.activity_add_habito.*
import kotlinx.android.synthetic.main.adapter_habito.*

class AddHabitoActivity : AppCompatActivity() {

    private val db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_habito)

        btnSalvar.setOnClickListener(View.OnClickListener {

            val usuariosMap = hashMapOf(
                "name" to editNome.text.toString(),
                "turn" to editTurno.text.toString(),
                "category" to editCategoria.text.toString())

            db.collection("meus_habitos").document("Edu")
                .set(usuariosMap).addOnCompleteListener {
                    Log.i("Db Firestore", "Sucesso ao salvar dados!")
                }.addOnFailureListener {
                    Log.i("Erro Firestore", "Erro ao salvar dados!")
                }
        })

    }
}