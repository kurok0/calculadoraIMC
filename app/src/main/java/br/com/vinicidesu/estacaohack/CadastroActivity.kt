package br.com.vinicidesu.estacaohack

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Toast
import br.com.vinicidesu.estacaohack.databinding.ActivityCadastroBinding

class CadastroActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCadastroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCadastroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val btncad = AnimationUtils.loadAnimation(this, R.anim.btncadcadastro)
        val btncadastro = binding.btnCadCadastro
        btncadastro.startAnimation(btncad)

        val cardcad = AnimationUtils.loadAnimation(this, R.anim.cardcadastro)
        val cardcadastro = binding.imvCardCadastro
        cardcadastro.startAnimation(cardcad)

        val txvemailcad = AnimationUtils.loadAnimation(this, R.anim.txvemailcadastro)
        val tvxemailcadastro = binding.edtEmailCadastro
        tvxemailcadastro.startAnimation(txvemailcad)

        val txvnomecad = AnimationUtils.loadAnimation(this, R.anim.txvnomecadastro)
        val txvnomecadastro = binding.edtNomeCadastro
        txvnomecadastro.startAnimation(txvnomecad)

        val txvsenhacad = AnimationUtils.loadAnimation(this, R.anim.txvsenhacadastro)
        val txvsenhacadastro = binding.edtSenhaCadastro
        txvsenhacadastro.startAnimation(txvsenhacad)

        val sobrenomecad = AnimationUtils.loadAnimation(this, R.anim.txvsobrenomecadastro)
        val sobrenomecadastro = binding.edtSobrenomeCadastro
        sobrenomecadastro.startAnimation(sobrenomecad)

        binding.btnCadCadastro.setOnClickListener {
            val nome = binding.edtNomeCadastro.text.toString().trim()
            val sobrenome = binding.edtSobrenomeCadastro.text.toString().trim()
            val email = binding.edtEmailCadastro.text.toString().trim()
            val senha = binding.edtSenhaCadastro.text.toString().trim()

                    if (nome.isEmpty() ||
                    sobrenome.isEmpty() ||
                    email.isEmpty() ||
                    senha.isEmpty()
                    ){
              Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_LONG).show()

         }else{
                        val sharedprefs = getSharedPreferences(
                        "cadastro $email",
                        Context.MODE_PRIVATE)

                        val editprefs = sharedprefs.edit()

                        editprefs.putString("NOME", nome)
                        editprefs.putString("SOBRENOME", sobrenome)
                        editprefs.putString("EMAIL", email)
                        editprefs.putString("SENHA", senha)

                        editprefs.apply()

                        val mIntent = Intent(this, MainActivity ::class.java)

                        mIntent.putExtra("INTENT_EMAIL", email)
                        startActivity(mIntent)

                    }
        }



    }
}