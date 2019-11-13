package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class MainActivity extends Activity {
    private ListView Lv = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Lv = (ListView) findViewById(R.id.Lv);

        final String[] name = new String[] { "张国荣", "张学友", "谭咏麟" };
        final String[] message = new String[] {
                "张国荣[1]，1956年9月12日生于香港，歌手、演员、音乐人；影视歌多栖发展的代表之一。1977年正式出道。1983年以《风继续吹》成名。1984年演唱的《Monica》是香港歌坛第一支同获十大中文金曲、十大劲歌金曲的舞曲 。 1986年、1987年获劲歌金曲金奖",
                "张学友，歌手、演员，1961年7月10日出生于香港，1984年获得香港首届十八区业余歌唱大赛冠军，正式出道，1993年发行的国语唱片《吻别》年度销量超过400万张，1995年、1996年连续两年获得世界音乐大奖全球销量最高亚洲流行乐歌手奖",
                "谭咏麟，1950年8月23日出生于香港，籍贯广东新会，中国香港男歌手、音乐人、演员。[1]20世纪60年代末为Loosers乐队成员。1973年任温拿乐队主音歌手。1975年参演首部电影《大家乐》。1978年温拿乐队宣布解散，谭咏麟以个人身份发展。1979年赴台湾发展事业，推出首张个人专辑《反斗星》" };
        final int[] photo = new int[] { R.drawable.add, R.drawable.adds, R.drawable.before };
        final List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();

        Map<String, Object> map1 = new HashMap<String, Object>();
        map1.put("photo", R.drawable.add);
        map1.put("name", name[0]);
        data.add(map1);

        Map<String, Object> map2 = new HashMap<String, Object>();
        map2.put("photo", R.drawable.adds);
        map2.put("name", name[1]);
        data.add(map2);

        Map<String, Object> map3 = new HashMap<String, Object>();
        map3.put("photo", R.drawable.before);
        map3.put("name", name[2]);
        data.add(map3);
//        Lv.setAdapter(new SimpleAdapter(this, data, R.layout.item,new String[] { "photo", "name" }, new int[] { R.id.iv,R.id.tv_name }));
//
//        AdapterView.OnItemClickListener itemClick = new AdapterView.OnItemClickListener(){
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
//            {
//                Bundle bundle=new Bundle();
////                bundle.putInt("photo",data.size());
//                bundle.putInt("id",position);
//                Intent intent = new Intent();
//                intent.putExtras(bundle);
//                intent.setClass(MainActivity.this, MoveList.class);
//                startActivity(intent);
//            }
//        };
//        Lv.setOnItemClickListener(itemClick);

        Lv.setAdapter(new SimpleAdapter(this, data, R.layout.item,new String[] { "photo", "name" }, new int[] { R.id.iv,R.id.tv_name }));
        Lv.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,long arg3) {

                Bundle bundle = new Bundle();
                bundle.putInt("photo", photo[arg2]);
                bundle.putString("message", message[arg2]);
                Intent intent = new Intent();
                intent.putExtras(bundle);
                intent.setClass(MainActivity.this, MoveList.class);
                Log.i("message", message[arg2]);
                startActivity(intent);
            }
        });
    }

}
