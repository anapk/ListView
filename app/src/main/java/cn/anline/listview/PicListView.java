package cn.anline.listview;


import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PicListView extends ListActivity {
    private String[] mListTitle = {"伽利略","培根","拜伦","狄更新","马克思"};
    private String[] mListText = {
            "生命犹如铁毡，愈被敲打，愈能发出火花",
            "瓜是长在营养肥料里的嘴甜，天才是长在恶性土壤里的最好",
            "悲观的人虽生犹死，乐观的人长生不老",
            "顽强的毅力可以征服世界上任何一座高峰",
            "生活就像海洋，只有意志坚强的人，才能达到彼岸"};
    private int[] mPicList ={
            R.drawable.img1,
            R.drawable.img2,
            R.drawable.img3,
            R.drawable.img4,
            R.drawable.img5
    };
    ListView mListView = null;
    ArrayList<Map<String,Object>> mData = new ArrayList<Map<String,Object>>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mListView = getListView();
        int lengh = mListTitle.length;
        for (int i =0;i< lengh;i++){
            Map<String,Object> item =new HashMap<String, Object>();
            item.put("ppPic",mPicList[i]);
            item.put("ppTitle",mListTitle[i]);
            item.put("ppText",mListText[i]);
            mData.add(item);
        }
        SimpleAdapter adapter =new SimpleAdapter(this,mData,R.layout.activity_pic_list_view,new String[]{"ppPic","ppTitle","ppText"},new int[]{R.id.pic,R.id.pTitle,R.id.pText});
//        SimpleAdapter adapter2 =new SimpleAdapter(this,mData,R.layout.activity_pic_list,new String[]{"ppPic","ppTitle","ppText"},new int[]{R.id.img,R.id.title,R.id.info});
        setListAdapter(adapter);
//        setListAdapter(adapter2);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),"名人："+mListTitle[position]+"   名句："+mListText[position],Toast.LENGTH_SHORT).show();
            }
        });

        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_pic_list_view);
    }
}
