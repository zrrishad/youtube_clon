package com.example.clonyoutube;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    TextView edText;
    ListView edList;
    ArrayList<HashMap<String,String>>arrayList=new ArrayList<>();
    HashMap<String,String>hashMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //edText=findViewById(R.id.edText);
        edList=findViewById(R.id.edList);
        String url="https://ris71.000webhostapp.com/asma/youtube.clon";
        JsonArrayRequest arrayRequest =new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {


                try {

                    for (int x=0;x<response.length();x++){



                        JSONObject jsonObject=response.getJSONObject(x);

                        String title=jsonObject.getString("title");
                        String video_id=jsonObject.getString("video_id");







                        MyAdapter myAdapter=new MyAdapter();
                        edList.setAdapter(myAdapter);



                        hashMap=new HashMap<>();
                        hashMap.put("title",title);
                        hashMap.put("video_id",video_id);
                        arrayList.add(hashMap);





                    }






                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {

            }
        });


        RequestQueue requestQueue= Volley.newRequestQueue(MainActivity.this);
        requestQueue.add(arrayRequest);


    }

    public class MyAdapter extends BaseAdapter{


        @Override
        public int getCount() {
            return arrayList.size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int position, View view, ViewGroup viewGroup) {
            LayoutInflater layoutInflater=getLayoutInflater();
           View myView= layoutInflater.inflate(R.layout.layout1,null);




           TextView text1=myView.findViewById(R.id.text1);
           TextView text2=myView.findViewById(R.id.text2);
            ImageView edVideo=myView.findViewById(R.id.edVideo);

           HashMap<String,String>hashMap1=arrayList.get(position);


           String title=hashMap1.get("title");
           String video_id=hashMap1.get("video_id");

           String image_url="https://img.youtube.com/vi/"+video_id+"/0.jpg";

            text1.setText(title);

            Picasso.get().load(image_url).into(edVideo);



            edVideo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    MainActivity1.image_url="https://www.youtube.com/embed/WRHz0g-GMVA";
                    Intent myIntent=new Intent(MainActivity.this,MainActivity1.class);
                    startActivity(myIntent);
                }
            });


            return myView;
        }
    }
}