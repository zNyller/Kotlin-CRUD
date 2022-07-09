package com.nyller.android.kotlin.activities

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.google.firebase.firestore.FirebaseFirestore
import com.nyller.android.kotlin.MainActivity
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
                "nome" to editNome.text.toString(),
                "turno" to editTurno.text.toString(),
                "categoria" to editCategoria.text.toString())

            db.collection("habitos").add(usuariosMap)
                .addOnCompleteListener {
                    Log.i("Db Firestore", "Sucesso ao salvar dados!")
                }.addOnFailureListener {
                    Log.i("Erro Firestore", "Erro ao salvar dados!")
                }
        })

        btnAbrir.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        })

    }
}