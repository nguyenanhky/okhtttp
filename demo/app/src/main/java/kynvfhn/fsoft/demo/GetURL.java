package kynvfhn.fsoft.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import kynvfhn.fsoft.demo.databinding.ActivityGetUrlBinding;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class GetURL extends AppCompatActivity {
    private ActivityGetUrlBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityGetUrlBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new GetUrl().execute("http://"+binding.txtUrl.getText().toString());
            }
        });

    }

    class GetUrl extends AsyncTask<String,String,String>{

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(10,TimeUnit.SECONDS)
                .readTimeout(15,TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .build();

        @Override
        protected String doInBackground(String... strings) {
            Request.Builder builder = new Request.Builder();
            builder.url(strings[0]);

            Request request = builder.build();
            try {
                Response response = okHttpClient.newCall(request).execute();
                return response.body().string();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return  null;
        }

        @Override
        protected void onPostExecute(String s) {
            if(!s.equals("")){
                binding.txtRecevied.append(s);
            }else{
                Toast.makeText(GetURL.this, "duong dan bi loi ", Toast.LENGTH_SHORT).show();
            }
            super.onPostExecute(s);
        }
    }
}