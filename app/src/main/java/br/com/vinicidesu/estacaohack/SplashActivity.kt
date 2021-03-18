package br.com.vinicidesu.estacaohack

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.Toast
import br.com.vinicidesu.estacaohack.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //declare the animation
        val cardA = AnimationUtils.loadAnimation(this, R.anim.cardsplash)
        val btnAsplash = AnimationUtils.loadAnimation(this, R.anim.btn1splash)
        val btnBsplash = AnimationUtils.loadAnimation(this, R.anim.btn2splash)
        val edtAsplash = AnimationUtils.loadAnimation(this, R.anim.edt1splash)
        val edtBsplash = AnimationUtils.loadAnimation(this, R.anim.edt2splash)

        val btnBs = binding.btnSplashEntrar
        val btnAs = binding.btnSplashCadastrar
        val card = binding.imvFit
        val edtAs = binding.edtLoginSplash
        val edtBs = binding.edtSenhaSplash

        //set the animation
        card.startAnimation(cardA)
        btnAs.startAnimation(btnAsplash)
        btnBs.startAnimation(btnBsplash)
        edtAs.startAnimation(edtAsplash)
        edtBs.startAnimation(edtBsplash)

        binding.btnSplashEntrar.setOnClickListener {
            val email = binding.edtLoginSplash.text.toString().trim().toLowerCase()
            val senha = binding.edtSenhaSplash.text.toString().trim()

        if (email.isEmpty()){
            binding.edtLoginSplash.error = "Campo Obrigatório"
            binding.edtLoginSplash.requestFocus()
        }else if (senha.isEmpty()){
            binding.edtSenhaSplash.error = "Campo Obrigatório"
            binding.edtSenhaSplash.requestFocus()
        }else{
            val sharedprefs = getSharedPreferences(
                    "cadastro $email",
                    Context.MODE_PRIVATE
            )

            val emailprefs = sharedprefs.getString("EMAIL", "")
            val senhaprefs = sharedprefs.getString("SENHA", "")

            if (email == emailprefs && senha == senhaprefs){
                Toast.makeText(this, "Usuário Logado", Toast.LENGTH_LONG).show()
                    val mIntent = Intent(this, MainActivity::class.java)
                        mIntent.putExtra("INTENT_EMAIL", email)
                            startActivity(mIntent)

            }else{
                Toast.makeText(this, "E-mail e/ou Senha Inválidos", Toast.LENGTH_LONG).show()
            }
        }

        }
        binding.btnSplashCadastrar.setOnClickListener {
            val mIntent = Intent(this, CadastroActivity::class.java)
                startActivity(mIntent)

        }
    }
}