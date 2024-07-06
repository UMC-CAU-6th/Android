package com.example.flo.forLogin

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.flo.database.SongDatabase
import com.example.flo.databinding.ActivitySignupBinding

class SignUpActivity : AppCompatActivity() {
    lateinit var binding : ActivitySignupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.signUpSignUpBtn.setOnClickListener{
            signUP()
            //signUp 조건문 확인 후 getUser 실행, 만약에 형식 잘못됐으면 종료 안됨
        }
    }

    private fun getUser() : User {//EditText는 유저가 직접 입력할 수 있게 만드는 xml코드
        val email : String = binding.signUpIdEt.text.toString() +"@"+binding.signUpDirectInputEt.text.toString()
        val pwd : String = binding.signUpPasswordEt.text.toString()

        return User(email, pwd)
    }

    private fun signUP(){//아무것도 안쳤거나, 이미 있는 값이거나,
        if (binding.signUpIdEt.text.toString().isEmpty() || binding.signUpDirectInputEt.text.toString().isEmpty()){
            Toast.makeText(this, "이메일 형식이 잘못되었습니다.",Toast.LENGTH_SHORT).show()
            return
        }
        if (binding.signUpPasswordEt.text.toString().isEmpty()){
            Toast.makeText(this, "비밀번호 형식이 잘못되었습니다.",Toast.LENGTH_SHORT).show()
            return
        }
        if (binding.signUpPasswordEt.text.toString() != binding.signUpPasswordCheckEt.text.toString()){
            Toast.makeText(this, "비밀번호가 일치하지 않습니다.",Toast.LENGTH_SHORT).show()
            return
        }
        val userDB = SongDatabase.getInstance(this)!!
        userDB.userDao().insert(getUser())


        val user = userDB.userDao().getUsers()
        Log.d("SIGNUPACT", user.toString())
        finish()//사인 업 후 종료
    }
}