package tasnuvaoshin.com.retrofitadvanceputpatchdelete;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.PATCH;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface OurRetrofitClient {
    @PATCH("posts/{id}")
    Call<ObjectStructureClass> PutRequest(@Path("id") int id,@Body ObjectStructureClass objectStructureClass);

    @DELETE("posts/{id}")
    Call<Void> DeleteRequest(@Path("id")int id);

}
