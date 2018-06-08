package com.example.a11120029.listnew;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.a11120029.listnew.tourpac.aquaplanet;
import com.example.a11120029.listnew.tourpac.building;
import com.example.a11120029.listnew.tourpac.luxury;
import com.example.a11120029.listnew.tourpac.marinabote;
import com.example.a11120029.listnew.tourpac.museum;
import com.example.a11120029.listnew.tourpac.samload;
import com.example.a11120029.listnew.tourpac.seoultower;
import com.example.a11120029.listnew.tourpac.traditional;
import com.example.a11120029.listnew.tourpac.yungsanarthall;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Song> al = new ArrayList<Song>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        al.add(new Song("N서울타워", R.drawable.ntower, "동양 최고의 타워 한국 최초의 타워형태")); //0
        al.add(new Song("63빌딩", R.drawable.building63, "여의도 마천루 한강 서울의 상징적인 관광명소")); //1
        al.add(new Song("쌈지길", R.drawable.ssamtest, "공예품 전문 쇼핑몰 인사동의 새로운 인사동 ")); //2
        al.add(new Song("아쿠아플라넷", R.drawable.img4, "라라라")); //3
        al.add(new Song("한국 관광 명품관", R.drawable.img5, "마마마")); //4
        al.add(new Song("서울 마리나 클럽 요트", R.drawable.img6, "바바바")); //5
        al.add(new Song("박물관이 살아있다", R.drawable.img7, "사사사")); //6
        al.add(new Song("북촌 한옥마을", R.drawable.img8, "아아아")); //7
        al.add(new Song("영산아트홀", R.drawable.img9, "자자자")); //8


        MyAdapter adapter = new MyAdapter(getApplicationContext(), R.layout.row, al);

        ListView lv = (ListView) findViewById(R.id.listView1);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if(position == 0){

                    Intent intent = new Intent(MainActivity.this, seoultower.class);

                   startActivity(intent);

                }

                if(position == 1){

                    Intent intent1 = new Intent(MainActivity.this, building.class);

                    startActivity(intent1);

                }

                if(position == 2){

                    Intent intent2 = new Intent(MainActivity.this, samload.class);

                    startActivity(intent2);

                }

                if(position == 3){

                    Intent intent3 = new Intent(MainActivity.this, aquaplanet.class);

                    startActivity(intent3);

                }

                if(position == 4){

                    Intent intent4 = new Intent(MainActivity.this, luxury.class);

                    startActivity(intent4);

                }

                if(position == 5){

                    Intent intent5 = new Intent(MainActivity.this, marinabote.class);

                    startActivity(intent5);

                }

                if(position == 6){

                    Intent intent6 = new Intent(MainActivity.this, museum.class);

                    startActivity(intent6);

                }

                if(position == 7){

                    Intent intent7 = new Intent(MainActivity.this, traditional.class);

                    startActivity(intent7);

                }

                if(position == 8){

                    Intent intent8 = new Intent(MainActivity.this, yungsanarthall.class);

                    startActivity(intent8);

                }


            }
        });

    }
}

class MyAdapter extends BaseAdapter { // 리스트 뷰의 아답타
    Context context;
    int layout;
    ArrayList<Song> al;
    LayoutInflater inf;

    public MyAdapter(Context context, int layout, ArrayList<Song> al) {
        this.context = context;
        this.layout = layout;
        this.al = al;
        inf = (LayoutInflater) context.getSystemService
                (Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return al.size();
    }

    @Override
    public Object getItem(int position) {
        return al.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inf.inflate(layout, null);
        }
        ImageView iv = (ImageView) convertView.findViewById(R.id.imageView1);
        TextView tvName = (TextView) convertView.findViewById(R.id.textView1);
        TextView tvInfo = (TextView) convertView.findViewById(R.id.textView2);

        Song m = al.get(position);
        iv.setImageResource(m.img);
        tvName.setText(m.title);
        tvInfo.setText(m.artist);

        return convertView;
    }
}

class Song { // 자바빈
    String title = ""; // 곡 title
    int img; // 앨범 이미지
    String artist = ""; // artist

    public Song(String title, int img, String artist) {
        super();
        this.title = title;
        this.img = img;
        this.artist = artist;
    }

    public Song() {
    }
}
