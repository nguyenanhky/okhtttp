package kynvfhn.fsoft.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;

import java.io.IOException;

import kynvfhn.fsoft.demo.databinding.ActivityGetAnImageBinding;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class GetAnImage extends AppCompatActivity {
    private ActivityGetAnImageBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityGetAnImageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new GetIMAGE().execute("https://media-cdn-v2.laodong.vn/storage/newsportal/2022/6/4/1052777/Psg-Messi.jpg");
            }
        });
    }

    class GetIMAGE extends AsyncTask<String,Void,byte[]>{
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .build();

        @Override
        protected byte[] doInBackground(String... strings) {
            Request.Builder builder = new Request.Builder();
            builder.url(strings[0]);

            Request request = builder.build();
            try {
                Response response = okHttpClient.newCall(request).execute();
                return  response.body().bytes();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(byte[] bytes) {
            if(bytes.length>0){
                Bitmap bitmap = BitmapFactory.decodeByteArray(bytes,0,bytes.length);
                binding.imageview.setImageBitmap(bitmap);
            }
            super.onPostExecute(bytes);
        }
    }
}