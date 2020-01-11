package tasnuvaoshin.com.retrofitadvanceputpatchdelete;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    ObjectStructureClass objectStructureClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Retrofit retrofit = new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .build();

        OurRetrofitClient ourRetrofitClient = retrofit.create(OurRetrofitClient.class);

        Call<Void> call = ourRetrofitClient.DeleteRequest(3);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.code() == 200) {
                    Log.d("response", "deleted");
                } else {
                    Log.d("response", "Failed");
                }


            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Log.d("response", "Failed");
            }
        });


//objectStructureClass = new ObjectStructureClass("Lets Study",null,3);
//       Call<ObjectStructureClass> call = ourRetrofitClient.PutRequest(3,objectStructureClass);


//       call.enqueue(new Callback<ObjectStructureClass>() {
//           @Override
//           public void onResponse(Call<ObjectStructureClass> call, Response<ObjectStructureClass> response) {
//               Log.d("response",response.body().getTitle() + " : "+response.body().getBody() +" : "+response.body().getUserId());
//           }
//
//           @Override
//           public void onFailure(Call<ObjectStructureClass> call, Throwable t) {
//               Log.d("response","failed");
//           }
//       });
//    }
    }
}
