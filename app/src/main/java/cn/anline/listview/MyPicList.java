package cn.anline.listview;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MyPicList extends ListActivity {
    private int[] mPic = {
            R.drawable.m1,
            R.drawable.m2,
            R.drawable.m3,
            R.drawable.m4,
            R.drawable.m5,
            R.drawable.m6,
            R.drawable.m7,
            R.drawable.m8,
            R.drawable.m9
    };
    private String[] mTitle ={
            "安浪语文",
            "安浪数学",
            "安浪英语",
            "安浪地理",
            "安浪物理",
            "安浪生物",
            "安浪化学",
            "安浪政治",
            "安浪历史"
    };
    private String[] mStr = {
            "文言文，作文，端午，高考零分作文，笑话大王，诗歌，屈原",
            "函数，算法，人生几何，算术题，线性函数，技术支持",
            "Hello Anline.I Should be King,the Lead",
            "导航，海拔，地震，海啸，污水处理，计算位置，七大洲，四大洋",
            "宇宙，爱因斯坦，相对论，加速度，万有引力，引力波，冲击波，光线路",
            "细胞，基因分离，基因突变，传染病，遗传病，基因重组，细胞我呢行",
            "氢氧化钠，锰铁同行，燃烧，变黄",
            "郑和下夕阳，奥巴马。金三胖，在哪里，朝鲜，美利坚合众国",
            "秦始皇，骊山，子音，更捏，西安兵马俑，大话西游是不是，结束了吧"
    };
    ListView mListView = null;
    ArrayList<Map<String,Object>> mData = new ArrayList<Map<String,Object>>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mListView = getListView();
        int lengh = mTitle.length;
        for (int i = 0;i<lengh;i++){
            Map<String,Object> item = new HashMap<String, Object>();
            item.put("pic",mPic[i]);
            item.put("title",mTitle[i]);
            item.put("str",mStr[i]);
            mData.add(item);
        }
        SimpleAdapter adapter = new SimpleAdapter(this,mData,R.layout.activity_my_pic_list,new String[]{"pic","title","str"},new int[]{R.id.myPic,R.id.myT1,R.id.myT2});
        setListAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "位置：" + (position + 1) + ",标题：" + mTitle[position] + ",简介：" + mStr[position], Toast.LENGTH_SHORT).show();
            }
        });
        mListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                AlertDialog.Builder builder = new Builder(MyPicList.this);
                  builder.setMessage(mStr[position]);
                  builder.setTitle(mTitle[position]);
                  builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        MyPicList.this.finish();
                           }
                      });
                   builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        }
                });
                 builder.create().show();
                return false;
            }
        });
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_my_pic_list);
    }
}
